package org.dsm.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private Socket socket;
    private PrintWriter printWriter;
    private EditText Nombre, Edad, Mensaje;
    Button buttonEnviar;
    //int puerto=5000;
    String mensaje, nombre, edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = findViewById(R.id.txtNombre);
        Mensaje = findViewById(R.id.txtMensaje);
        Edad = findViewById(R.id.txtEdad);
        buttonEnviar = findViewById(R.id.btnEnviar);
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mensaje = Mensaje.getText().toString();
                nombre = Nombre.getText().toString();
                edad = Edad.getText().toString();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        socket = new Socket("192.168.137.1",5000);
                        printWriter = new PrintWriter(socket.getOutputStream());
                        printWriter = new PrintWriter("nombre: " +nombre+" "+ "Edad: "+edad+" "+"mensaje: "+mensaje);
                        printWriter.flush();
                        printWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }
            }).start();
            /*
            Nombre.setText(null);
            Edad.setText(null);
            Mensaje.setText(null);*/
            }
        });
    }
}