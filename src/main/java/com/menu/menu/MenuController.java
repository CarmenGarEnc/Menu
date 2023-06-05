package com.menu.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    //CARNE
    @FXML
    private ToggleGroup hamburguesa;
    @FXML
    private RadioButton rbPollo;
    @FXML
    private RadioButton rbCerdo;

    @FXML
    private RadioButton rbTernera;

    @FXML
    private RadioButton rbVegana;

    //PAN
    @FXML
    private ToggleGroup pan;
    @FXML
    private RadioButton rbNormal;
    @FXML
    private RadioButton rbIntegral;
    @FXML
    private RadioButton rbCenteno;

    //PATATAS
    @FXML
    private ToggleGroup patatas;
    @FXML
    private RadioButton rbFritas;
    @FXML
    private RadioButton rbGajo;
    @FXML
    private RadioButton rbCaseras;

    //BEBIDAS
    @FXML
    private ToggleGroup bebida;
    @FXML
    private RadioButton rbCola;
    @FXML
    private RadioButton rbNaranja;
    @FXML
    private RadioButton rbLimon;
    @FXML
    private RadioButton rbAgua;
    @FXML
    private RadioButton rbCerveza;

    //EXTRAS
    @FXML
    private CheckBox cbHambDoble;
    @FXML
    private CheckBox cbExQue;
    @FXML
    private CheckBox cbExpa;

    //SALSAS
    @FXML
    private  ChoiceBox<Integer> combBarbacoa;
    Integer[] bbq={0,1,2,3,4,5};
    @FXML
    private  ChoiceBox<Integer> combKetchup;
    Integer[] ketchup={0,1,2,3,4,5};
    @FXML
    private  ChoiceBox<Integer> combMostaza;
    Integer[] mostaza={0,1,2,3,4,5};
    public void  initialize(URL url, ResourceBundle resourceBundle){
        //Esto sirve para rellenar el comboBox inicialmente
        combBarbacoa.getItems().addAll(bbq);
        combBarbacoa.setValue(0);
        combKetchup.getItems().addAll(ketchup);
        combKetchup.setValue(0);
        combMostaza.getItems().addAll(mostaza);
        combMostaza.setValue(0);
    }

    //TIPO ENTREGA
    @FXML
    private ToggleGroup entrega;
    @FXML
    private RadioButton rbRecoger;
    @FXML
    private RadioButton rbDomicilio;

    //PEDIDO
    @FXML
    private Button btcalcular;
    @FXML
    private TextField txtPVP;

    @FXML
    private TextField txtiva;

    @FXML
    private TextField txtprecio;

    @FXML
    void calcular(ActionEvent event) {
        double precio=8;
        Alert alert, alert2, alert3, alert4, alert5, alert6;
        //Elección de carne
        if (!rbPollo.isSelected()&&!rbCerdo.isSelected()&&!rbTernera.isSelected()&&!rbVegana.isSelected()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de datos");
            alert.setContentText("Debe introducir el tipo de carne que quiere en la hamburguesa");
            alert.showAndWait();
        }else if(rbTernera.isSelected()||rbVegana.isSelected()){
                precio++;
        }
        //Elección pan
        if (!rbNormal.isSelected()&&!rbCenteno.isSelected()&&!rbIntegral.isSelected()){
            alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Error de datos");
            alert2.setContentText("Debe introducir el tipo de pan que quiere en la hamburguesa");
            alert2.showAndWait();
        }
        //Elección patatas
        if(!rbFritas.isSelected()&&!rbGajo.isSelected()&&!rbCaseras.isSelected()){
            alert3 = new Alert(Alert.AlertType.ERROR);
            alert3.setTitle("FALTAN LAS PATATAS");
            alert3.setContentText("Debe introducir el tipo de patatas que quiere en el menú");
            alert3.showAndWait();
        }else if(rbCaseras.isSelected()){
            precio++;
        }
        //Elección de la bebida
        if(!rbCola.isSelected()&&!rbNaranja.isSelected()&&!rbLimon.isSelected()&&!rbAgua.isSelected()&&!rbCerveza.isSelected()){
            alert4 = new Alert(Alert.AlertType.WARNING);
            alert4.setTitle("FALTA LA BEBIDA");
            alert4.setContentText("El menú le incluye un bebida,por favor debe introducir el tipo de bebida que quiere en el menú");
            alert4.showAndWait();
        }
        //Extras
        if (cbHambDoble.isSelected()){
            precio=precio+2;
        }
        if (cbExQue.isSelected()){
            precio=precio+0.5;
        }
        if (cbExpa.isSelected()){
            precio++;
        }
        //Salsas
        int salsas=combKetchup.getValue()+combMostaza.getValue()+combBarbacoa.getValue();
        precio=precio+(salsas*0.5);
        //Tipo entrega
        if (!rbRecoger.isSelected()&&!rbDomicilio.isSelected()){
            alert5 = new Alert(Alert.AlertType.ERROR);
            alert5.setTitle("Error de datos");
            alert5.setContentText("Debe introducir el tipo de entrega de su pedidos: Recoger o a Domicilio.");
            alert5.showAndWait();
        }else if(rbRecoger.isSelected()){
            precio=precio-precio*0.2;
        }
        double iva=precio*0.21;
        txtprecio.setText(precio+"€");
        txtiva.setText(String.format("%.2f", iva)+"€");
        txtPVP.setText(String.format("%.2f", (precio+iva)) + "€");

        alert6 = new Alert(Alert.AlertType.INFORMATION);
        alert6.setTitle("Pedido Realizado");
        alert6.setContentText("Muchas gracias esperamos que le guste nuestro menú");
        alert6.showAndWait();
    }

}
