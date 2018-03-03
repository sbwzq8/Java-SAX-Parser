/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaSAXParser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author SBWin
 */
public class SAXParserFXMLDocumentController implements Initializable
{
    @FXML
    private MenuItem openMenuItem;
    
    @FXML
    private TreeView domTreeRepresentation;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
    public void start(Stage stage) {
        openMenuItem.setOnAction((event) -> {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Open XML File");
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML files", "*.xml"));
            File selected = chooser.showOpenDialog(stage);
            if(selected != null) {
                try{
                    XMLNode xmlRoot = XMLSAXParser.load(selected);
//                    TreeItem treeRoot = new TreeItem();
//                    treeRoot.setValue(xmlRoot.getName());
//                    domTreeRepresentation.setRoot(treeRoot);
                }catch(Exception e){
                    System.out.println("Error parsing xml: " + e.getMessage());
                }
            }
       });
    }
    
}
