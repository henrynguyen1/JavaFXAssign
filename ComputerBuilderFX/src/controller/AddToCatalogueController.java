package controller;
import au.edu.uts.ap.javafx.*;

import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import javafx.collections.*;
import javafx.collections.transformation.*;

import javafx.event.*;
import javafx.fxml.FXML;
import model.*;


public class AddToCatalogueController extends Controller<Catalogue>{
        @FXML private TextField typeAddTf;
        @FXML private TextField nameAddTf;
        @FXML private TextField priceAddTf;
        @FXML private Button AddtoCatalogueBtn;
        
    public final Catalogue getCatalogue(){
      return model;
              
}
    
@FXML private void initialize(){

}   
    
private String getAddType(){
    return typeAddTf.getText();
}
private String getAddName(){
     return nameAddTf.getText();
}
private Double getAddPrice(){
    return Double.parseDouble(priceAddTf.getText());
    }


@FXML private void handleAddPart(ActionEvent event)throws IOException{
 try {
            getCatalogue().addPart(getAddName(), getAddType(), getAddPrice());
            stage.close();
        } catch (Exception e) {
            ViewLoader.showStage(e, "/view/error.fxml", "Incorrect Input", new Stage());
        }
    }
}


 
