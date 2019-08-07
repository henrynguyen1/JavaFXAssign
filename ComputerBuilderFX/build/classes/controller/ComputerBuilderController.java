package controller;
import au.edu.uts.ap.javafx.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import javafx.application.Platform;
import javafx.collections.*;
import javafx.collections.transformation.*;
import javafx.event.*;
import javafx.fxml.FXML;
import model.*;



public class ComputerBuilderController extends Controller<ComputerBuilder> {
 
    @FXML private void initialize() {
        
    }
    public final ComputerBuilder getComputerBuilder() {
        return model;
    }
    
  
    
    @FXML private void handleViewCatalogue(ActionEvent event) throws Exception {
        ViewLoader.showStage(getComputerBuilder().getCatalogue(), "/view/catalogue.fxml", "Catalogue", new Stage());
    }
    
    @FXML private void handleViewBuild(ActionEvent event) throws Exception {
        ViewLoader.showStage(getComputerBuilder().getBuild(), "/view/build.fxml", "Current Build", new Stage());
    }
    
    @FXML private void handleQuit(ActionEvent event) throws Exception {
        Platform.exit();
    }
    
}
