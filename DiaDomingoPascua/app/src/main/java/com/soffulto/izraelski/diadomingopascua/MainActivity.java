package com.soffulto.izraelski.diadomingopascua;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtYear;
    TextView txtRta;
    Button btnDo;
    Integer year,a,b,c,d,e,dia, M, N, mes;
    String styear;
    CheckBox chkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ObtenerReferencias();
        SetListener();
    }
    public void ObtenerReferencias(){
        btnDo = (Button) findViewById(R.id.btnDo);
        edtYear= (EditText) findViewById(R.id.edtYear);
        chkBox= (CheckBox) findViewById(R.id.chkBox);
        txtRta= (TextView) findViewById(R.id.textView4);
    }
    public void SetListener(){
        btnDo.setOnClickListener(Click);
    }
    View.OnClickListener Click = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if (edtYear.getText().length() == 4) {
                if (Integer.parseInt(edtYear.getText().toString())>1582&&Integer.parseInt(edtYear.getText().toString())<2300) {
                    year = Integer.parseInt(edtYear.getText().toString());
                    a = year % 19;
                    b = year % 4;
                    c = year % 7;

                    if (1583 <= year && year <= 1699) {
                        M = 22;
                        N = 2;
                    }
                    if (1700 <= year && year <= 1799) {
                        M = 23;
                        N = 3;
                    }
                    if (1800 <= year && year <= 1899) {
                        M = 23;
                        N = 4;
                    }
                    if (1900 <= year && year <= 2099) {
                        M = 24;
                        N = 5;
                    }
                    if (2100 <= year && year <= 2199) {
                        M = 24;
                        N = 6;
                    }
                    if (2200 <= year && year <= 2299) {

                        M = 25;
                        N = 0;
                    }
                    d = (19 * a + M) % 30;
                    e = (2 * b + 4 * c + 6 * d + N) % 7;

                    if (d + e < 10) {
                        dia = d + e + 22;
                        mes = 03;
                    } else {
                        dia = d + e - 9;
                        mes = 04;
                    }
                    if (mes == 04 && dia == 26) {
                        dia = 19;
                    } else {
                        if (mes == 04 && dia == 25) {
                            if (d == 28 && e == 6 && a > 10) {
                                dia = 18;
                            }
                        }
                    }
                    if (mes == 04) {
                        styear = "Abril";
                    }
                    if (mes == 03) {
                        styear = "Marzo";
                    }
                    if (chkBox.isChecked())
                    {
                        txtRta.setText("La fecha cae en el dia " + dia.toString() + " y en el mes de " + styear);
                    }
                    else {
                        if (dia.toString().length()==2) {
                            txtRta.setText("0" + mes.toString() + "/" + dia.toString());
                        }else{
                            txtRta.setText("0" + mes.toString() + "/0" + dia.toString());
                        }
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Debe estar entre 1583 y 2299 incluidos.", Toast.LENGTH_SHORT).show();
                }
            }else
            {
                Toast.makeText(MainActivity.this, "Debe ingresar un año de 4 digitos entre 1583 y 2299.", Toast.LENGTH_SHORT).show();
            }
        }

    };
}
