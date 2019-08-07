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

public class ErrorController extends Controller<Exception> {
    @FXML private Text errorTxt;
    @FXML private Button okayBtn;
    
    
    public final Exception getException() {
        return model; 
    }
    
    @FXML private void handleOkay(ActionEvent event) {
        stage.close();
    }
}
