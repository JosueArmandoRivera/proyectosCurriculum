package org.dsm.miniagendatel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText t1;
    private Button b1;
    private ListView lv1;
    private ArrayList telefonos;

    private ArrayAdapter adapter1;
    //Es el manejador de la lista, para que cuando se selecccione algún elemento sepa cuál es

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.ed1);
        b1= findViewById(R.id.btn1);
        lv1=findViewById(R.id.lista1);
        contactosInicio();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregar();

            }
        });
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                telefonos.remove(i);// Esta i es la posición y es la que aparece en el evento
                adapter1.notifyDataSetChanged();
            }
        });
    }
    //Asignar 3 contactos por default
    public void contactosInicio(){
       telefonos= new ArrayList();
       telefonos.add("Armando : 4772309891");
       telefonos.add("Josué : 4771234567");
       telefonos.add("Enrique : 4777654321");
       adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,telefonos);
       lv1.setAdapter(adapter1);
    }
    public void agregar(){
        telefonos.add(this.t1.getText().toString());
        adapter1= new ArrayAdapter(this,android.R.layout.simple_list_item_1,telefonos);
        lv1.setAdapter(adapter1);
        t1.setText(null);
    }
}
