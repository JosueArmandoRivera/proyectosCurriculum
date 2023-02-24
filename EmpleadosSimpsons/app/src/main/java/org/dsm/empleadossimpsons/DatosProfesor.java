package org.dsm.empleadossimpsons;

import static org.dsm.empleadossimpsons.MainActivity.datos;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class DatosProfesor extends AppCompatActivity {
    private EditText tid;
    private EditText tn;
    private EditText tsa;
    private EditText tpa;
    private EditText te;
    private EditText temail;
    private EditText tsu;
    private ImageView foto;

    Drawable foto3 = null;
    Drawable foto4 = null;
    String rutaImagen3 = null;
    String rutaImagen4 = null;
    String rutaImagen5 = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_profesor);
        tid=findViewById(R.id.et2);
        tn=findViewById(R.id.et3);
        tpa=findViewById(R.id.et4);
        tsa =findViewById(R.id.txtApeMaterno);
        te=findViewById(R.id.txtEdad);
        temail=findViewById(R.id.txtEmail);
        tsu=findViewById(R.id.txtSueldo);
        foto=findViewById(R.id.iv1);

        Bundle b= getIntent().getExtras();
        tid.setText(b.getString("id"));

        if(this.tid.getText().toString().equals("e1")){
            Drawable foto1 = null;
            String rutaImagen = null;
            int idResourceFoto=0;

            //cargar imagen
            rutaImagen = "@drawable/"+ tid.getText().toString();
            //utilizaremos la ruta de la imagen, obtendremos su ID de recurso
            idResourceFoto =getResources().getIdentifier(rutaImagen,null,getPackageName());
            //Con el ID obtenido, recuperamos la imagen como un objeto de tipo drawable, cargamos el recurso al objeto foto1
            foto1 = getResources().getDrawable(idResourceFoto);
            //Colocamos la foto dentro del control de ImageView
            foto.setImageDrawable(foto1);

            tn.setText(datos[0].getNombre());
            tpa.setText(datos[0].getPrimerApellido());
            tsa.setText(datos[0].getSegundoApellido());
            te.setText(String.valueOf(datos[0].getEdad()));
            temail.setText(datos[0].getEmail());
            tsu.setText(String.valueOf(datos[0].getSueldo()));
        }
        if(this.tid.getText().toString().equals("e2")){
            Drawable foto2 = null;
            String rutaImagen2 = null;
            int idResourceFoto=0;


            //cargar imagen
            rutaImagen2 = "@drawable/"+ tid.getText().toString();
            //utilizaremos la ruta de la imagen, obtendremos su ID de recurso
            idResourceFoto = getResources().getIdentifier(rutaImagen2,null,getPackageName());
            //Con el ID obtenido, recuperamos la imagen como un objeto de tipo drawable, cargamos el recurso al objeto foto1
            foto2 = getResources().getDrawable(idResourceFoto);
            //Colocamos la foto dentro del control de ImageView
            foto.setImageDrawable(foto2);

            tn.setText(datos[1].getNombre());
            tpa.setText(datos[1].getPrimerApellido());
            tsa.setText(datos[1].getSegundoApellido());
            te.setText(datos[1].getEdad());
            temail.setText(datos[1].getEmail());
            tsu.setText(datos[1].getSueldo());

        }/*
        if(this.tid.getText().toString().equals("e3")){
            //cargar imagen
            rutaImagen = "@drawable/"+ tid.getText().toString();
            //utilizaremos la ruta de la imagen, obtendremos su ID de recurso
            idResourceFoto =getResources().getIdentifier(rutaImagen,null,getPackageName());
            //Con el ID obtenido, recuperamos la imagen como un objeto de tipo drawable, cargamos el recurso al objeto foto1
            foto1 = getResources().getDrawable(idResourceFoto);
            //Colocamos la foto dentro del control de ImageView
            foto.setImageDrawable(foto1);


            tn.setText(datos[2].getNombre());
            tpa.setText(datos[2].getPrimerApellido());
            tsa.setText(datos[2].getSegundoApellido());
            te.setText(datos[2].getEdad());
            temail.setText(datos[2].getEmail());
            tsu.setText(datos[2].getSueldo());
        }
        if(this.tid.getText().toString().equals("e4")){
            //cargar imagen
            rutaImagen = "@drawable/"+ tid.getText().toString();
            //utilizaremos la ruta de la imagen, obtendremos su ID de recurso
            idResourceFoto =getResources().getIdentifier(rutaImagen,null,getPackageName());
            //Con el ID obtenido, recuperamos la imagen como un objeto de tipo drawable, cargamos el recurso al objeto foto1
            foto1 = getResources().getDrawable(idResourceFoto);
            //Colocamos la foto dentro del control de ImageView
            foto.setImageDrawable(foto1);


            tn.setText(datos[3].getNombre());
            tpa.setText(datos[3].getPrimerApellido());
            tsa.setText(datos[3].getSegundoApellido());
            te.setText(datos[3].getEdad());
            temail.setText(datos[3].getEmail());
            tsu.setText(datos[3].getSueldo());
        }
        if(this.tid.getText().toString().equals("e5")){
            //cargar imagen
            rutaImagen = "@drawable/"+ tid.getText().toString();
            //utilizaremos la ruta de la imagen, obtendremos su ID de recurso
            idResourceFoto =getResources().getIdentifier(rutaImagen,null,getPackageName());
            //Con el ID obtenido, recuperamos la imagen como un objeto de tipo drawable, cargamos el recurso al objeto foto1
            foto1 = getResources().getDrawable(idResourceFoto);
            //Colocamos la foto dentro del control de ImageView
            foto.setImageDrawable(foto1);


            tn.setText(datos[4].getNombre());
            tpa.setText(datos[4].getPrimerApellido());
            tsa.setText(datos[4].getSegundoApellido());
            te.setText(datos[4].getEdad());
            temail.setText(datos[4].getEmail());
            tsu.setText(datos[4].getSueldo());
        }*/
    }
}