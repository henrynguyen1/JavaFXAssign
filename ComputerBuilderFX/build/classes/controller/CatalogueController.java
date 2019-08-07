package controller;
import au.edu.uts.ap.javafx.*;

import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import java.util.List;
import javafx.collections.*;
import javafx.collections.transformation.*;
import javafx.event.*;
import javafx.fxml.FXML;
import model.*;




public class CatalogueController extends Controller<Catalogue> {
    
   @FXML private TextField typeTf;
   @FXML private TextField minPriceTf;
   @FXML private TextField maxPriceTf;
   @FXML private Button addNewPartBtn;
   @FXML private Button addToBuildBtn;
   @FXML private Button removePartBtn;
   @FXML private TableColumn <Part, String> nameClm;
   @FXML private TableColumn <Part, String> priceClm;
   @FXML private TableColumn <Part, String> typeClm;
   @FXML private TableView<Part> catalogueTv;
   
   public final Catalogue getCatalogue(){
       return model;
   }
  
private String getType() { 
    return typeTf.getText();
}
private String minPriceTf() { 
        return minPriceTf.getText(); 
    }
private String maxPriceTf() { 
        return maxPriceTf.getText(); 
    

}     
   @FXML private void initialize(){
   priceClm.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asString("$%.2f"));
   typeTf.textProperty().addListener((o, oldText, newText) ->
                getCatalogue().filterList(newText, minPriceTf(), maxPriceTf()));
   minPriceTf.textProperty().addListener((o, oldText, newText) ->
                getCatalogue().filterList(getType(), newText, maxPriceTf()));
   maxPriceTf.textProperty().addListener((o, oldText, newText) ->
                getCatalogue().filterList(getType(), minPriceTf(), newText));
   nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
   
   typeClm.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
   catalogueTv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
   catalogueTv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldPart, newPart) -> addToBuildBtn.setDisable(newPart == null));
   catalogueTv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldPart, newPart) -> removePartBtn.setDisable(newPart == null));
    
   }
    

   
   
   
 
@FXML private void handleAddPart(ActionEvent event)throws Exception{
   ViewLoader.showStage(getCatalogue(), "/view/addtocatalogue.fxml", "Add New Part to Catalogue", new Stage());  
     
 }
@FXML private void handleRemovePart(ActionEvent event)throws Exception{
   getCatalogue().remove(catalogueTv.getSelectionModel().getSelectedItem());
}

private List<Part> getSelectedParts() {
        return catalogueTv.getSelectionModel().getSelectedItems();
    }

@FXML private void handleAddPartBuild(ActionEvent event)throws Exception{
    if (catalogueTv.getSelectionModel().getSelectedItems().size() > 1 ){
    getCatalogue().addToBuild(catalogueTv.getSelectionModel().getSelectedItems());
    }
    if (catalogueTv.getSelectionModel().getSelectedItem() != null){
            getCatalogue().addToBuild(catalogueTv.getSelectionModel().getSelectedItem());
            }
    

}
    
@FXML private void handleCloseApp(ActionEvent event)throws Exception{
 stage.close();
}
     
    

  
   
  
  



}