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

public class BuildController extends Controller<Build> {
    @FXML private Text priceTxt;
    @FXML private Button checkBuildBtn;
    @FXML private Button removePartBtn;
    @FXML private TableView<Part> buildTv;
    @FXML private TableColumn <Part, String> priceClm;
    
    public final Build getBuild() { 
        return model;
    }
@FXML private void initialize(){
    buildTv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldPart, newPart) -> removePartBtn.setDisable(newPart == null));
    buildTv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    buildTv.getItems().addListener(new ListChangeListener() {
            @Override
            public void onChanged (ListChangeListener.Change change){
                priceTxt.textProperty().set(String.format("Total: $%.2f", getBuild().totalPrice()));
            }
            });
    priceClm.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asString("$%.2f"));
  }


 @FXML private void handleCheckBuild(ActionEvent event) throws Exception {
        ViewLoader.showStage(getBuild(), "/view/buildcheck.fxml", "Build Validity Status", new Stage());
    }
    
 @FXML private void handleRemovePart(ActionEvent event) throws Exception {
       if (buildTv.getSelectionModel().getSelectedItems().size() >= 1){
                getBuild().remove(buildTv.getSelectionModel().getSelectedItems());
        } else {
        if (buildTv.getSelectionModel().getSelectedItem() != null){
            getBuild().remove(buildTv.getSelectionModel().getSelectedItem());
            }
        }
    }

 @FXML private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
    
}