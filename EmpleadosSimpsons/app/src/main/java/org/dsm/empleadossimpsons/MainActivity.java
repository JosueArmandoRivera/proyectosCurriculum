package org.dsm.empleadossimpsons;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText t1;
    private Button b1;
    private Profesor profesor;
    public static Profesor[] datos= new Profesor[4];
   // @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.et1);
        b1=findViewById(R.id.btn1);
        creaProfesor();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             enviar();
            }
        });
    }
    public void creaProfesor(){
        datos[0]=new Profesor("e1","Homero","J","Simposon",40,"cerveza@gmail.com",80000);
        datos[1]=new Profesor("e2","March","J","Simposon",40,"cerveza@gmail.com",5550);
        datos[2]=new Profesor("e3","Lisa","J","Simposon",9,"cerveza@gmail.com",50);
        datos[3]=new Profesor("e4","Bart","J","Simposon",10,"cerveza@gmail.com",10);
        datos[4]=new Profesor("e5","Maggie","J","Simposon",1,"cerveza@gmail.com",8);
    }
    public void enviar(){
        Intent i=new Intent(this, DatosProfesor.class);
        i.putExtra("id",t1.getText().toString());
        startActivity(i);
    }
}