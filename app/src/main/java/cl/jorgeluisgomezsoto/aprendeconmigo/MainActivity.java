package cl.jorgeluisgomezsoto.aprendeconmigo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void quiensoy(View view){
        Intent intent = new Intent(MainActivity.this, explicacion.class);
        startActivity(intent);
    }
    public void soporte(View view){
        Intent intent = new Intent(MainActivity.this, soporte.class);
        startActivity(intent);
    }
    public void googlemaps(View view){
        Intent intent = new Intent(MainActivity.this, googlemaps.class);
        startActivity(intent);
    }
    public void irbd(View view){
        Intent intent = new Intent(MainActivity.this, basedatos.class);
        startActivity(intent);
    }
}