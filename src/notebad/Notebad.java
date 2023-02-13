/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package notebad;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author salah
 */
public class Notebad extends Application {
    TextArea tArea = new TextArea();
    
    @Override
    public void start(Stage primaryStage) {
        
        
        MenuBar bar = new MenuBar();
        bar.setStyle("-fx-font:normal bold 12px 'serif'");
        
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");
        
        MenuItem NewFile = new MenuItem("New");
        NewFile.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(tArea.getText().trim().isEmpty()){
                    tArea.setText("");
                }else{
                    Alert alert = new Alert(AlertType.CONFIRMATION, "Do you want to save before opening new file?",
                    ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                    alert.showAndWait();
                    if(alert.getResult()==ButtonType.YES){
                        try {
                            FileWriter writer = new FileWriter(new Date()+".txt");
                            writer.write(tArea.getText());
                            writer.close();
                            tArea.clear();
                        } catch (IOException ex) {
                            Logger.getLogger(Notebad.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        tArea.forward();
                    }
                }
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            
            
            }
            
        });
        MenuItem OpenFile = new MenuItem("Open");
        OpenFile.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(tArea.getText().trim().isEmpty()){
                    FileChooser filechooser = new FileChooser();
                    filechooser.setTitle("Save Text File");
                    File file = filechooser.showOpenDialog(primaryStage);
                }else{
                Alert alert = new Alert(AlertType.CONFIRMATION, "Do you want to save before opening new file?",
                    ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                    alert.showAndWait();
                    if(alert.getResult()==ButtonType.YES){
                        try {
                            FileWriter writer = new FileWriter(new Date()+".txt");
                            writer.write(tArea.getText());
                            writer.close();
                            tArea.clear();
                        } catch (IOException ex) {
                            Logger.getLogger(Notebad.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        tArea.forward();
                    }
                }
                
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });
        MenuItem SaveFile = new MenuItem("Save");
        SaveFile.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(tArea.getText().trim().isEmpty()){
                    Alert aler = new Alert(AlertType.ERROR);
                    String s = "Nothing to Save!!";
                    aler.setContentText(s);
                    aler.show();
                }else{
                    Alert alert = new Alert(AlertType.CONFIRMATION, "Do you want to save before opening new file?",
                    ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                    alert.showAndWait();
                    if(alert.getResult()==ButtonType.YES){
                        try {
                            FileWriter writer = new FileWriter(new Date()+".txt");
                            writer.write(tArea.getText());
                            writer.close();
                            tArea.clear();
                        } catch (IOException ex) {
                            Logger.getLogger(Notebad.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        tArea.forward();
                    }
                }
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });
        MenuItem ExitFile = new MenuItem("Exit");
        ExitFile.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(tArea.getText().trim().isEmpty()){
                    primaryStage.close();
                }else{
                    Alert alert = new Alert(AlertType.CONFIRMATION, "Do you want to save before opening new file?",
                    ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                    alert.showAndWait();
                    if(alert.getResult()==ButtonType.YES){
                        try {
                            FileWriter writer = new FileWriter(new Date()+".txt");
                            writer.write(tArea.getText());
                            writer.close();
                            primaryStage.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Notebad.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        tArea.forward();
                    }
                }
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });
        
        
        MenuItem CopyFile= new MenuItem("copy");
        CopyFile.setAccelerator(KeyCombination.keyCombination("Ctrl+c"));
        CopyFile.addEventHandler(ActionEvent.ACTION, (e) -> tArea.copy());
        
        MenuItem CutFile= new MenuItem("cut");
        CutFile.setAccelerator(KeyCombination.keyCombination("Ctrl+x"));
        CutFile.addEventHandler(ActionEvent.ACTION, (e) -> tArea.cut());
        
        MenuItem PasteFile= new MenuItem("paste");
        PasteFile.setAccelerator(KeyCombination.keyCombination("Ctrl+v"));
        PasteFile.addEventHandler(ActionEvent.ACTION, (e) -> tArea.paste());
        
        MenuItem DeleteFile= new MenuItem("delete");
        DeleteFile.setAccelerator(KeyCombination.keyCombination("del"));
        DeleteFile.addEventHandler(ActionEvent.ACTION, (e) -> tArea.deleteText(tArea.getSelection()));
        
        MenuItem SelectAllFile= new MenuItem("select-all");
        PasteFile.setAccelerator(KeyCombination.keyCombination("Ctrl+a"));
        PasteFile.addEventHandler(ActionEvent.ACTION, (e) -> tArea.selectAll());
        
        
        MenuItem UndoFile= new MenuItem("undo");        
        UndoFile.setAccelerator(KeyCombination.keyCombination("Ctrl+z"));
        UndoFile.addEventHandler(ActionEvent.ACTION , (e)-> tArea.undo());
        
        MenuItem AboutNotepad= new MenuItem("About");
        AboutNotepad.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("About Notepad");
                alert.setHeaderText("Notepad");
                String str = "Made By Mohamed Salah ";
                alert.setContentText(str);
                alert.show();
                        
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });
        
        
        file.getItems().addAll(NewFile,OpenFile,SaveFile,ExitFile);
        edit.getItems().addAll(CopyFile,CutFile,PasteFile,DeleteFile,SelectAllFile,UndoFile);
        help.getItems().addAll(AboutNotepad);
        
        bar.getMenus().addAll(file,edit,help);
        
        
        
        
        BorderPane root = new BorderPane();
        root.setTop(bar);
        root.setCenter(tArea);
        
//        tRoot.getChildren().addAll(tArea,root);
        
        Scene scene = new Scene(root, 600, 450);
        
//        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
