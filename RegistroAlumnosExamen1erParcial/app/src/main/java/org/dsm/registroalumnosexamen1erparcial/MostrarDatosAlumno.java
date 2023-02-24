package org.dsm.registroalumnosexamen1erparcial;

import static org.dsm.registroalumnosexamen1erparcial.BuscarAlumnos.datos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MostrarDatosAlumno extends AppCompatActivity {
    private Button volver;
    private EditText idRegistro;
    private EditText nombre;
    private EditText primerApellido;
    private EditText segundoApellido;
    private EditText matricula;
    private EditText grupo;
    private EditText email;
    private EditText cuatrimestre;
    private ImageView foto;
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos_alumno);
        idRegistro = findViewById(R.id.txtIdRegistroMDA);
        nombre = findViewById(R.id.txtNombreMDA);
        primerApellido = findViewById(R.id.txtPrimerApeMDA);
        segundoApellido = findViewById(R.id.txtSegundoApeMDA);
        matricula = findViewById(R.id.txtMatriculaMDA);
        grupo = findViewById(R.id.txtGrupoMDA);
        email = findViewById(R.id.txtEmailMDA);
        cuatrimestre = findViewById(R.id.txtCuatrimestreMDA);
        foto=findViewById(R.id.iv1);

        volver = findViewById(R.id.btnVolver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volverBuscador();
            }});
        Bundle b= getIntent().getExtras();
        matricula.setText(b.getString("matricula"));

        for(int l=1;l>i;l++){
        if(this.matricula.getText().toString().equals(b.getString("matricula"))){
            Drawable foto1 = null;
            String rutaImagen = null;
            int idResourceFoto=0;

            //cargar imagen
            rutaImagen = "@drawable/"+ matricula.getText().toString();
            //utilizaremos la ruta de la imagen, obtendremos su ID de recurso
            idResourceFoto =getResources().getIdentifier(rutaImagen,null,getPackageName());
            //Con el ID obtenido, recuperamos la imagen como un objeto de tipo drawable, cargamos el recurso al objeto foto1
            foto1 = getResources().getDrawable(idResourceFoto);
            //Colocamos la foto dentro del control de ImageView
            foto.setImageDrawable(foto1);

            nombre.setText(datos[0].getNombre());
            primerApellido.setText(datos[0].getPrimerApellido());
            segundoApellido.setText(datos[0].getSegundoApellido());
            cuatrimestre.setText(datos[0].getCuatrimestre());
            email.setText(datos[0].getEmail());
            grupo.setText(datos[0].getGrupo());
            matricula.setText(datos[0].getMatricula());
            idRegistro.setText(String.valueOf(datos[0].getId()));
        }}

        if(this.matricula.getText().toString().equals("a21002445")){
            Drawable foto1 = null;
            String rutaImagen = null;
            int idResourceFoto=0;

            //cargar imagen
            rutaImagen = "@drawable/"+ matricula.getText().toString();
            //utilizaremos la ruta de la imagen, obtendremos su ID de recurso
            idResourceFoto =getResources().getIdentifier(rutaImagen,null,getPackageName());
            //Con el ID obtenido, recuperamos la imagen como un objeto de tipo drawable, cargamos el recurso al objeto foto1
            foto1 = getResources().getDrawable(idResourceFoto);
            //Colocamos la foto dentro del control de ImageView
            foto.setImageDrawable(foto1);

            nombre.setText(datos[0].getNombre());
            primerApellido.setText(datos[0].getPrimerApellido());
            segundoApellido.setText(datos[0].getSegundoApellido());
            cuatrimestre.setText(datos[0].getCuatrimestre());
            email.setText(datos[0].getEmail());
            grupo.setText(datos[0].getGrupo());
            matricula.setText(datos[0].getMatricula());
            idRegistro.setText(String.valueOf(datos[0].getId()));
        }
        if(this.matricula.getText().toString().equals("a21002446")){
            Drawable foto1 = null;
            String rutaImagen = null;
            int idResourceFoto=0;

            //cargar imagen
            rutaImagen = "@drawable/"+ matricula.getText().toString();
            //utilizaremos la ruta de la imagen, obtendremos su ID de recurso
            idResourceFoto =getResources().getIdentifier(rutaImagen,null,getPackageName());
            //Con el ID obtenido, recuperamos la imagen como un objeto de tipo drawable, cargamos el recurso al objeto foto1
            foto1 = getResources().getDrawable(idResourceFoto);
            //Colocamos la foto dentro del control de ImageView
            foto.setImageDrawable(foto1);

            nombre.setText(datos[1].getNombre());
            primerApellido.setText(datos[1].getPrimerApellido());
            segundoApellido.setText(datos[1].getSegundoApellido());
            cuatrimestre.setText(datos[1].getCuatrimestre());
            email.setText(datos[1].getEmail());
            grupo.setText(datos[1].getGrupo());
            matricula.setText(datos[1].getMatricula());
            idRegistro.setText(String.valueOf(datos[1].getId()));
        }
        if(this.matricula.getText().toString().equals("a21002447")){
            Drawable foto1 = null;
            String rutaImagen = null;
            int idResourceFoto=0;

            //cargar imagen
            rutaImagen = "@drawable/"+ matricula.getText().toString();
            //utilizaremos la ruta de la imagen, obtendremos su ID de recurso
            idResourceFoto =getResources().getIdentifier(rutaImagen,null,getPackageName());
            //Con el ID obtenido, recuperamos la imagen como un objeto de tipo drawable, cargamos el recurso al objeto foto1
            foto1 = getResources().getDrawable(idResourceFoto);
            //Colocamos la foto dentro del control de ImageView
            foto.setImageDrawable(foto1);

            nombre.setText(datos[2].getNombre());
            primerApellido.setText(datos[2].getPrimerApellido());
            segundoApellido.setText(datos[2].getSegundoApellido());
            cuatrimestre.setText(datos[2].getCuatrimestre());
            email.setText(datos[2].getEmail());
            grupo.setText(datos[2].getGrupo());
            matricula.setText(datos[2].getMatricula());
            idRegistro.setText(String.valueOf(datos[2].getId()));
        }
        if(this.matricula.getText().toString().equals("a21002448")){
            Drawable foto1 = null;
            String rutaImagen = null;
            int idResourceFoto=0;

            //cargar imagen
            rutaImagen = "@drawable/"+ matricula.getText().toString();
            //utilizaremos la ruta de la imagen, obtendremos su ID de recurso
            idResourceFoto =getResources().getIdentifier(rutaImagen,null,getPackageName());
            //Con el ID obtenido, recuperamos la imagen como un objeto de tipo drawable, cargamos el recurso al objeto foto1
            foto1 = getResources().getDrawable(idResourceFoto);
            //Colocamos la foto dentro del control de ImageView
            foto.setImageDrawable(foto1);

            nombre.setText(datos[3].getNombre());
            primerApellido.setText(datos[3].getPrimerApellido());
            segundoApellido.setText(datos[3].getSegundoApellido());
            cuatrimestre.setText(datos[3].getCuatrimestre());
            email.setText(datos[3].getEmail());
            grupo.setText(datos[3].getGrupo());
            matricula.setText(datos[3].getMatricula());
            idRegistro.setText(String.valueOf(datos[3].getId()));
        }

    }
    public void volverBuscador(){
        Intent i = new Intent(this,BuscarAlumnos.class);
        startActivity(i);
    }

}