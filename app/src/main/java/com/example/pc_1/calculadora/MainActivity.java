package com.example.pc_1.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double termino1,termino2,terminof;
    String prim="",number[];
    int operador,contop=0,error=0,error2=0,gs=0;
    TextView resultado;
    char mult='*',sum='+',div='/',rest='-',point='.';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultadoid);
    }

    public void boton(View view) {

        switch (view.getId()){
            case R.id.unoid:
                prim = prim+"1";
                break;
            case R.id.dosid:
                prim =prim+"2";
                break;
            case R.id.tresid:
                prim =prim+"3";

                break;
            case R.id.cuatroid:
                prim =prim+"4";
                break;
            case R.id.cincoid:
                prim =prim+"5";
                break;
            case R.id.seisid:
                prim =prim+"6";
                break;
            case R.id.sieteid:
                prim =prim+"7";
                break;
            case R.id.ochoid:
                prim =prim+"8";
                break;
            case R.id.nueveid:
                prim =prim+"9";
                break;
            case R.id.ceroid:
                prim =prim+"0";
                break;
            case R.id.puntoid:
                prim =prim+".";
                break;
            case R.id.masid:
                prim =prim+"+";
                operador=1;
                contop++;
                break;
            case R.id.menosid:
                prim =prim+"-";
                operador=2;
                contop++;
                break;
            case R.id.multiplicacionid:
                prim =prim+"*";
                operador=3;
                contop++;
                break;
            case R.id.divisionid:
                prim =prim+"/";
                operador=4;
                contop++;
                break;
            case R.id.borrarid:
                prim="";
                gs = 1;
                contop=0;
                operador=0;
                break;
            case R.id.igualid:

                if(prim.charAt(prim.length()-1) == mult){
                    Toast.makeText(this,"Error de sintaxis", Toast.LENGTH_SHORT).show();
                    break;
                }else if(prim.charAt(prim.length()-1) == div){
                    Toast.makeText(this,"Error de sintaxis", Toast.LENGTH_SHORT).show();
                    break;
                }else if(prim.charAt(prim.length()-1) == sum){
                    Toast.makeText(this,"Error de sintaxis", Toast.LENGTH_SHORT).show();
                    break;
                }else if(prim.charAt(prim.length()-1) == rest){
                    Toast.makeText(this,"Error de sintaxis", Toast.LENGTH_SHORT).show();
                    break;
                }else if(prim.charAt(prim.length()-1) == point){
                    Toast.makeText(this,"Error de sintaxis", Toast.LENGTH_SHORT).show();
                    break;
                }else if (contop>1){
                    Toast.makeText(this,"Error de sintaxis", Toast.LENGTH_SHORT).show();
                    break;
                }

                for(int i=0 ; i < prim.length()-1 ; i++){

                    if(prim.charAt(i) == mult){
                        error = 1;
                    }else if(prim.charAt(i) == div){
                        error = 1;
                    }else if(prim.charAt(i) == sum){
                        error = 1;
                    }else if(prim.charAt(i) == rest){
                        error = 1;
                    }else if(prim.charAt(i) == point){
                        error = 1;
                    }else {
                        error=0;
                    }

                    if(prim.charAt(i+1) == mult){
                        error2 = 1;
                    }else if(prim.charAt(i+1) == div){
                        error2 = 1;
                    }else if(prim.charAt(i+1) == sum){
                        error2 = 1;
                    }else if(prim.charAt(i+1) == rest){
                        error2 = 1;
                    }else if(prim.charAt(i+1) == point){
                        error2 = 1;
                    }else {
                        error2=0;
                    }

                    if(error==1 && error2==1){
                        gs = 0;
                        Toast.makeText(this,"Error de sintaxis", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    gs = 1;
                    contop=0;
                }

                if(gs==1){
                    switch (operador){
                        case 1:
                            number = prim.split("\\+");
                            termino1 = Double.parseDouble(number[0]);
                            termino2 = Double.parseDouble(number[1]);
                            terminof = termino1 + termino2;
                            prim = String.valueOf(terminof);
                            operador=0;
                            break;
                        case 2:
                            number = prim.split("-");
                            termino1 = Double.parseDouble(number[0]);
                            termino2 = Double.parseDouble(number[1]);
                            terminof = termino1 - termino2;
                            prim = String.valueOf(terminof);
                            operador=0;
                            break;
                        case 3:
                            number = prim.split("\\*");
                            termino1 = Double.parseDouble(number[0]);
                            termino2 = Double.parseDouble(number[1]);
                            terminof = termino1 * termino2;
                            prim = String.valueOf(terminof);
                            operador=0;
                            break;
                        case 4:
                            number = prim.split("/");
                            termino1 = Double.parseDouble(number[0]);
                            termino2 = Double.parseDouble(number[1]);
                            terminof = termino1 / termino2;
                            prim = String.valueOf(terminof);
                            operador=0;
                            break;
                    }
                }
                break;

        }

        resultado.setText(prim);
    }
}
