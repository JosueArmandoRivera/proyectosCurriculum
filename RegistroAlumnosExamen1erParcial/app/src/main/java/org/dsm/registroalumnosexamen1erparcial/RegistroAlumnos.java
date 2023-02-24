package org.dsm.registroalumnosexamen1erparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroAlumnos extends AppCompatActivity {
    private Button volverInicio;
    private Button registrarAlumno;

    private EditText id;
    private EditText nombre;
    private EditText primerApellido;
    private EditText segundoApellido;
    private EditText matricula;
    private EditText grupo;
    private EditText email;
    private EditText cuatrimestre;
    int i;

    //public static Alumno[]datos= new Alumno[6];
    static Alumno[]datos= new Alumno[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_alumnos);
        volverInicio = findViewById(R.id.btnInicio);
        volverInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrocederInicio();
            }
        });
        registrarAlumno = findViewById(R.id.btnRegistrar);
        registrarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar();
            }
        });

    }
    public void retrocederInicio(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void registrar(){
        Toast.makeText(this, "Alumo registrado", Toast.LENGTH_SHORT).show();

        Alumno alumno = new Alumno();
        id = findViewById(R.id.txtIdRegistro);
        nombre = findViewById(R.id.txtNombre);
        primerApellido = findViewById(R.id.txtPrimerApe);
        segundoApellido = findViewById(R.id.txtSegundoApe);
        matricula = findViewById(R.id.txtMatricula);
        grupo = findViewById(R.id.txtGrupo);
        email = findViewById(R.id.txtEmail);
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
/*
        datos[0]=new Alumno(id,matricula,nombre,segundoApellido,cuatrimestre,email,grupo);
        datos[1]=new Alumno(id,matricula,nombre,segundoApellido,cuatrimestre,email,grupo);
        datos[2]=new Alumno(id,matricula,nombre,segundoApellido,cuatrimestre,email,grupo);
        datos[3]=new Alumno(id,matricula,nombre,segundoApellido,cuatrimestre,email,grupo);
        datos[4]=new Alumno(id,matricula,nombre,segundoApellido,cuatrimestre,email,grupo);
  */
        //   Toast.makeText((Context) this, (CharSequence) datos[0], Toast.LENGTH_SHORT).show();


    }
}