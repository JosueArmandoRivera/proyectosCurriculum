package org.dsm.registroalumnosexamen1erparcial;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BuscarAlumnos extends AppCompatActivity {

    private Button buscarAInicio;
    private Button buscar;
    private EditText busqueda;
    public static Alumno[] datos = new Alumno[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_alumnos);
//        crearAlumno();
        datos[0]=new Alumno(1,"a21002445","Armando","Rivera","Hernandez","Quinto","cerveza@gmail.com","DSM502");
        datos[1]=new Alumno(2,"a21002446","Juan","Rubalcava","Hernandez","Quinto","juan@gmail.com","DSM502");
        datos[2]=new Alumno(3,"a21002447","Enrique","Rubalcava","Hernandez","Quinto","enrique@gmail.com","DSM502");
        datos[3]=new Alumno(4,"a21002448","Guadalupe","Gomez","Hernandez","Quinto","lupita@gmail.com","DSM502");
        datos[4]=new Alumno(4,"1","1","1","1","1","1","1");

       // datos[4]=new Alumno(5,"a21002449","Daniela","Laguna","Moreno","Cuarto","dani@gmail.com","DSM502");

        buscarAInicio = findViewById(R.id.btnBuscarInicio);
        buscarAInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volerBuscarAInicio();
            }
        });
        buscar = findViewById(R.id.btnBuscar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarAlumno();
            }
        });
        busqueda = findViewById(R.id.txtBusqueda);
    }
    public void volerBuscarAInicio(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void buscarAlumno(){
        Intent i=new Intent(this, MostrarDatosAlumno.class);
        i.putExtra("matricula",busqueda.getText().toString());
        startActivity(i);
    }
    public void crearAlumno(){
        datos[0]=new Alumno(1,"a21002445","Armando","Rivera","Hernandez","Quinto","cerveza@gmail.com","DSM502");
        datos[1]=new Alumno(2,"a21002446","Juan","Rubalcava","Hernandez","Quinto","juan@gmail.com","DSM502");
        datos[2]=new Alumno(3,"a21002447","Guadalupe","Rubalcava","Hernandez","Quinto","enrique@gmail.com","DSM502");
        datos[3]=new Alumno(4,"a21002448","Enrique","Gomez","Hernandez","Quinto","lupita@gmail.com","DSM502");
        datos[4]=new Alumno(5,"a21002449","Daniela","Laguna","Moreno","Quinto","dani@gmail.com","DSM502");
    }
}