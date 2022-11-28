package cl.jorgeluisgomezsoto.aprendeconmigo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class explicacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicacion);
    }
    public void salir(View view){
        Intent intent = new Intent(explicacion.this,MainActivity.class);
        startActivity(intent);
    }
}