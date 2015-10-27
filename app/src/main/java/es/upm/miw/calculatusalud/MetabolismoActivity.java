package es.upm.miw.calculatusalud;

import android.content.Context;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MetabolismoActivity extends AppCompatActivity {

    private RadioButton sexo;
    private EditText peso;
    private EditText estatura;
    private EditText edad;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metabolismo);
        //asignamos los controles a las variable
        peso = (EditText) findViewById(R.id.input_peso);
        estatura = (EditText) findViewById(R.id.input_estatura);
        edad = (EditText) findViewById(R.id.input_edad);
        resultado = (TextView) findViewById(R.id.resultado);
    }

    public void onRadioButtonClicked(View view) {
        //Recuperamos el radio button seleccionado
        RadioGroup sexo_group = (RadioGroup) findViewById(R.id.radio_group_sexo);
        int radioButtonID = sexo_group.getCheckedRadioButtonId();
        sexo = (RadioButton) sexo_group.findViewById(radioButtonID);
    }

    public void calcularMB(View view) {
        //Recuperamos los valores introducidos
        String valor1 = peso.getText().toString();
        String valor2 = estatura.getText().toString();
        String valor3 = edad.getText().toString();
        //Parseamos a numero
        double nro1 = Double.parseDouble(valor1);
        double nro2 = Double.parseDouble(valor2);
        int nro3 = Integer.parseInt(valor2);
        //Calculamos el MB
        double mb = 0;
        Log.d("sexo", sexo.getText().toString());
        //Las ecuaciones de Harris-Benedict revisadas ​​por Mifflin y St Jeor en 1990 y utilizadas en la actualidad
        if (sexo.getText().toString().equals(getString(R.string.txt_sexo_hombre))) {
            mb =(10 *nro1) + (6.25 *nro2) - (5* nro3) + 5;
        } else if (sexo.getText().toString().equals(getString(R.string.txt_sexo_mujer))) {
            mb=(10 *nro1) + (6.25 *nro2) - (5 * nro3) - 161;
        }
        //Redondeamos a 2 decimales
        mb = Math.round(mb * 100) / 100;
        //Escribimos el resultado
        String imc_string = "Metabolismo Basal = " + String.valueOf(mb)+" kilocalorías/día";
        resultado.setText(imc_string);

        //Ocultamos el teclado
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(peso.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(estatura.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(edad.getWindowToken(), 0);

    }


}
