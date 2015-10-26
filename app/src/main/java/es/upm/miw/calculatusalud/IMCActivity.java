package es.upm.miw.calculatusalud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class IMCActivity extends AppCompatActivity {

    private EditText peso;
    private EditText estatura;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        //asignamos los controles a las variables
        peso = (EditText) findViewById(R.id.input_peso);
        estatura = (EditText) findViewById(R.id.input_estatura);
        resultado = (TextView) findViewById(R.id.resultado);
    }

    public void calcularIMC(View view) {
        //Recuperamos los valores introducidos
        String valor1 = peso.getText().toString();
        String valor2 = estatura.getText().toString();
        //Parseamos a numero
        double nro1 = Integer.parseInt(valor1);
        double nro2 = Integer.parseInt(valor2);
        //Calculamos el IMC
        double imc = nro1 / Math.pow(nro2 / 100, 2);
        //Redondeamos a 2 decimales
        imc=Math.round(imc * 100) / 100;
        //Escribimos el resultado
        String imc_string = "IMC = " + String.valueOf(imc) + "\n\n";
        if (imc < 16.00) {
            imc_string += "Infrapeso: Delgadez Severa";
        } else if (imc >= 16.00 && imc <= 16.99) {
            imc_string += "Infrapeso: Delgadez moderada";
        } else if (imc >= 17.00 && imc <= 18.49) {
            imc_string += "Infrapeso: Delgadez aceptable";
        } else if (imc >= 18.50 && imc <= 24.99) {
            imc_string += "Peso Normal";
        } else if (imc >= 25.00 && imc <= 29.99) {
            imc_string += "Sobrepeso";
        } else if (imc >= 30.00 && imc <= 34.99) {
            imc_string += "Obeso: Tipo I";
        } else if (imc >= 35.00 && imc <= 40.00) {
            imc_string += "Obeso: Tipo II";
        } else if (imc >= 40.00) {
            imc_string += "Obeso: Tipo III";
        }

        resultado.setText(imc_string);
    }
}
