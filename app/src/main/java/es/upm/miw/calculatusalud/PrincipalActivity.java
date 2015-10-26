package es.upm.miw.calculatusalud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void mostrarIMC(View view) {
        Intent intent = new Intent(this,IMCActivity.class);
        startActivity(intent);
    }

    public void mostrarPeso(View view) {
        Intent intent = new Intent(this,PesoActivity.class);
        startActivity(intent);
    }

    public void mostrarMetabolismo(View view) {
        Intent intent = new Intent(this,MetabolismoActivity.class);
        startActivity(intent);
    }

    public void mostrarCalorias(View view) {
        Intent intent = new Intent(this,CaloriasActivity.class);
        startActivity(intent);
    }
}
