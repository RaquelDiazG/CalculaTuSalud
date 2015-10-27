package es.upm.miw.calculatusalud;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class PesoActivity extends AppCompatActivity {

    private EditText estatura;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso);
        //asignamos los controles a las variable
        estatura = (EditText) findViewById(R.id.input_estatura);
        resultado = (TextView) findViewById(R.id.resultado);
    }

    public void calcularPeso(View view) {
        //Recuperamos los valores introducidos
        String valor2 = estatura.getText().toString();
        //Parseamos a numero
        double nro2 = Integer.parseInt(valor2);
        //Calculamos el IMC
        double peso_ideal = 22*Math.pow(nro2/100,2);
        //Redondeamos a 2 decimales
        peso_ideal=Math.round(peso_ideal * 100) / 100;
        //Escribimos el resultado
        String imc_string = "Peso ideal = " + String.valueOf(peso_ideal)+" kg";
        resultado.setText(imc_string);
        //Ocultamos el teclado
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(estatura.getWindowToken(), 0);
    }
}
