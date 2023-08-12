package com.example.assignment2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Currency;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private Label priceLabel;

    @FXML
    private ComboBox currencyBox;
    @FXML
    String select(ActionEvent e){
        String selection = currencyBox.getSelectionModel().getSelectedItem().toString();
        return selection;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        ObservableList<String> list = FXCollections.observableArrayList("USD","GBD","EUR");
        currencyBox.setItems(list);
    }

   public void search(ActionEvent e){
       Filler filler = new Filler();
       switch (select(e)){
           case "USD":
               priceLabel.setText(filler.getBitcoinValueUSD());
               break;
           case "GBD":
               priceLabel.setText(filler.getBitcoinValueGBP());
               break;
           case "EUR":
               priceLabel.setText(filler.getBitcoinValueEUR());
               break;
           default:
               priceLabel.setText("no selection");
       }
   }

}