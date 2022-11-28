package cl.jorgeluisgomezsoto.aprendeconmigo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class basedatos extends AppCompatActivity {

    public void salirdb(View view){
        Intent intent = new Intent(basedatos.this, MainActivity.class);
        startActivity(intent);
    }
    private final List<accion> accioneslist = new ArrayList<accion>();
    ArrayAdapter<accion> accionArrayAdapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    EditText tiipoa, detalle;
    ListView listadeacciones;
    accion accionselecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basedatos);

        tiipoa = findViewById(R.id.inputactividad);
        detalle = findViewById(R.id.inputdes);
        listadeacciones = findViewById(R.id.lista);
        partirfirebase();
        listarinformacion();

        listadeacciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                accionselecionada = (accion) parent.getItemAtPosition(position);
                tiipoa.setText(accionselecionada.getTipoaccion());
                detalle.setText(accionselecionada.getDetalle());
            }
        });
    }

    private void listarinformacion() {
        databaseReference.child("basedatos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                accioneslist.clear();
                for (DataSnapshot objSnapshot : snapshot.getChildren()){
                    accion ac = objSnapshot.getValue(accion.class);
                    accioneslist.add(ac);

                    accionArrayAdapter = new ArrayAdapter<accion>(basedatos.this, android.R.layout.simple_list_item_1,accioneslist);
                    listadeacciones.setAdapter(accionArrayAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void partirfirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String tipoaccion = tiipoa.getText().toString();
        String detalleaccion = detalle.getText().toString();
        switch (item.getItemId()) {
            case R.id.iconadd:{
                if (tipoaccion.equals("")){
                    validar();
                }else{
                    accion ac = new accion();
                    ac.setUid(UUID.randomUUID().toString());
                    ac.setTipoaccion(tipoaccion);
                    ac.setDetalle(detalleaccion);
                    databaseReference.child("accion").child(ac.getUid()).setValue(ac);
                    Toast.makeText(this,"Agregar",Toast.LENGTH_LONG).show();
                    limpiar();
                    break;}
            }
            case R.id.icondel:{
                accion acc = new accion();
                acc.setUid(accionselecionada.getUid());
                databaseReference.child("accion").child(acc.getUid()).removeValue();
                limpiar();
                Toast.makeText(this,"Eliminar",Toast.LENGTH_LONG).show();
                break;
            }
            default:break;
        }
        return true;
    }

    private void limpiar() {
        tiipoa.setText("");
        detalle.setText("");
    }

    private void validar(){
        String nombrer = tiipoa.getText().toString();
        if (nombrer.equals("")){
            tiipoa.setError("Required");
        }
    }
}