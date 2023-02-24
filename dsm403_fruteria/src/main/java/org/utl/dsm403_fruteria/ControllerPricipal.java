package org.utl.dsm403_fruteria;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class ControllerPricipal {

    int i=0;

    @FXML
    private Button btnAnterior;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnSiguiete;

    @FXML
    private Label txtCabtidad;

    @FXML
    private TextField txtCantidadFruta;

    @FXML
    private Label txtId;

    @FXML
    private TextField txtIdfruta;

    @FXML
    private Label txtNombre;

    @FXML
    private TextField txtNombreFruta;

    @FXML
    private Label txtPresentacion;

    @FXML
    private TextField txtPresentacioonFruta;

    @FXML
    private Label indexFruta;

    List<Fruta>listaFruta = new ArrayList<>();

    public void guardarFruta(){
        Fruta newFruta = new Fruta();
        newFruta.setIdFruta(Integer.parseInt(txtIdfruta.getText()));
        newFruta.setNombre(txtNombreFruta.getText());
        newFruta.setCatidad(Integer.parseInt(txtCantidadFruta.getText()));
        newFruta.setPresetacion(txtPresentacioonFruta.getText());
        listaFruta.add(newFruta);

        System.out.println(listaFruta.size());

        System.out.println(listaFruta.get(listaFruta.size()-1).getIdFruta());
        System.out.println(listaFruta.get(listaFruta.size()-1).getNombre());
        System.out.println(listaFruta.get(listaFruta.size()-1).getCatidad());
        System.out.println(listaFruta.get(listaFruta.size()-1).getPresetacion());

        txtId.setText(String.valueOf(newFruta.getIdFruta()));
        txtNombre.setText(String.valueOf(newFruta.getNombre()));
        txtCabtidad.setText(String.valueOf(newFruta.getCatidad()));
        txtPresentacion.setText(String.valueOf(newFruta.getPresetacion()));
        indexFruta.setText(String.valueOf(listaFruta.size()));

    }

    public void siguiente(){
        if (i == listaFruta.size()-1){
            i=0;
            this.txtId.setText(String.valueOf(listaFruta.get(i).getIdFruta()));
            this.txtNombre.setText(listaFruta.get(i).getNombre());
            this.txtCabtidad.setText(String.valueOf(listaFruta.get(i).getCatidad()));
            this.txtPresentacion.setText(listaFruta.get(i).getPresetacion());
            //this.indexFruta.setText(String.valueOf(listaFruta.size()));
        }else{

            i++;
            this.txtId.setText(String.valueOf(listaFruta.get(i).getIdFruta()));
            this.txtNombre.setText(listaFruta.get(i).getNombre());
            this.txtCabtidad.setText(String.valueOf(listaFruta.get(i).getCatidad()));
            this.txtPresentacion.setText(listaFruta.get(i).getPresetacion());
            //this.indexFruta.setText(String.valueOf(listaFruta.size()));
        }
    }
    public void anterior() {
        if (i == 0) {
            i = listaFruta.size()-1;
            this.txtId.setText(String.valueOf(listaFruta.get(i).getIdFruta()));
            this.txtNombre.setText(listaFruta.get(i).getNombre());
            this.txtCabtidad.setText(String.valueOf(listaFruta.get(i).getCatidad()));
            this.txtPresentacion.setText(listaFruta.get(i).getPresetacion());
            //this.indexFruta.setText(String.valueOf(listaFruta.size()));
        } else {
            i--;
            this.txtId.setText(String.valueOf(listaFruta.get(i).getIdFruta()));
            this.txtNombre.setText(listaFruta.get(i).getNombre());
            this.txtCabtidad.setText(String.valueOf(listaFruta.get(i).getCatidad()));
            this.txtPresentacion.setText(listaFruta.get(i).getPresetacion());
            //this.indexFruta.setText(String.valueOf(listaFruta.size()));
        }
    }
}