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


public class CheckBuildController extends Controller<Build>{
    @FXML private Text buildPartsTxt;
    @FXML private Button okayBtn;
    
     public final Build getBuild() { 
         return model; 
     }

@FXML private void initialize() {
     String buildMssg = "";
   
           if (!getBuild().hasPartOfType("cpu")){
                buildMssg += "The build is missing a CPU." + System.lineSeparator();
            }
            if (!getBuild().hasPartOfType("motherboard")){
                buildMssg += "The build is missing a motherboard." + System.lineSeparator();
            }
            if (!getBuild().hasPartOfType("memory")){
                buildMssg += "The build is missing RAM." + System.lineSeparator();
            }
            if (!getBuild().hasPartOfType("case")){
                buildMssg += "The build is missing a case." + System.lineSeparator();
            }
            if (!getBuild().hasPartOfType("storage")){
                buildMssg += "The build is missing storage." + System.lineSeparator();
            }
            buildPartsTxt.textProperty().set(buildMssg);
               if (getBuild().isValid()){
                  buildPartsTxt.textProperty().set("The build is functional." + System.lineSeparator());
        }

}
@FXML private void handleBuildOkay(ActionEvent event) throws Exception {
        stage.close();
    }
}