package org.dsm.registroalumnosexamen1erparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button ClickRegistrar;
    private Button ClickConsultar;
    private Button Clicksalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClickRegistrar = findViewById(R.id.btnRegistro);
        ClickRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirVentanaRegistrar();
            }
        });f
        ClickConsultar = findViewById(R.id.btnConsulta);
        ClickConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirVentanaBuscar();
            }
        });
        Clicksalir = findViewById(R.id.btnSalir);
        Clicksalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salir();
            }
        });

    }
    public void abrirVentanaRegistrar(){
        Intent i= new Intent(this,RegistroAlumnos.class);
        startActivity(i);
    }
    public void abrirVentanaBuscar(){
        Intent i= new Intent(this,BuscarAlumnos.class);
        startActivity(i);
    }
    public void salir() {
      //  super.onDestroy();
        //System.runFinalizersOnExit(true);
        android.os.Process.killProcess(android.os.Process.myPid());
    }


}