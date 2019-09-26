/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dir.inno.pub.data_persitence;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Controladores.*;

import java.io.IOException;
import java.net.URL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;

/**
 *
 * @author MODERNIZACION04
 */

//UNUSED MAIN CLASS
/**
 *
 * NO USAR NO USAR
 * 
 */




public class UIMain extends Application {
    /**
     * https://code.makery.ch/es/library/javafx-tutorial/part1/
     * http://tutorials.jenkov.com/javafx/fxml.html
     * https://www.callicoder.com/javafx-fxml-form-gui-tutorial/
     */
    private Stage stagePrimario;
    public BorderPane rootLayout;
    private ObservableList<String> listaArchivos = FXCollections.observableArrayList(); 
    private double xoffset;
    private double yoffset;
    
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        this.stagePrimario = primaryStage;
        this.stagePrimario.initStyle(StageStyle.UNDECORATED);
        showLogin(); 
    }
    
    /**
     * inicializa rootLayout
     */
    public void initRootLayout(){
        try{
            //cargo el layout raiz desde el archivo fxml
            FXMLLoader loader = new FXMLLoader();
            
            URL location = getClass().getResource("/fxml/RootLayout.fxml");
            loader.setLocation(location);
            
            //loader.setLocation(new URL("file:///D:/Netbeans/Proyectos/data_extractor_pdf_form/src/main/resources/fxml/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            rootLayout.setOnMousePressed(event->{
                xoffset = event.getSceneX();
                yoffset = event.getSceneY();
            });
            
            rootLayout.setOnMouseDragged(e->{
                stagePrimario.setX(e.getScreenX() - xoffset);
                stagePrimario.setY(e.getScreenY() - yoffset);
            });
            
            //muestro el contenido dentro del layout raiz
            Scene scene = new Scene(rootLayout);
            stagePrimario.setScene(scene);
            stagePrimario.show(); 
        }
        catch(IOException e){
            e.printStackTrace();
        };
    }
    
    /**
     * inicializa y muestra mainScene
     */
    public void showMainScene(){
        try{
            initRootLayout();
            //cargo el mainscene desde el archivo fxml
            FXMLLoader loader = new FXMLLoader();
            
            URL location = getClass().getResource("/fxml/MainScene.fxml");
            loader.setLocation(location);

            //loader.setLocation(new URL("file:///D:/Netbeans/Proyectos/data_extractor_pdf_form/src/main/resources/fxml/MainScene.fxml"));
            AnchorPane rootAnchorPane = (AnchorPane) loader.load();
            
            //seteo el mainscene al centro del scene raiz
            rootLayout.setCenter(rootAnchorPane);
        }
        catch(IOException e){
            e.printStackTrace();
        };
    }
    
    /**
     * inicializa y muestra la pantalla de login
     */
    public void showLogin(){
        try{
            initRootLayout();
            //cargo el login desde el archivo fxml
            FXMLLoader loader = new FXMLLoader();
            
            URL location = getClass().getResource("/fxml/Login.fxml");
            loader.setLocation(location);
            
            //loader.setLocation(new URL("file:///D:/Netbeans/Proyectos/data_extractor_pdf_form/src/main/resources/fxml/Login.fxml"));
            AnchorPane anchorPaneLoginRoot = (AnchorPane) loader.load();
            
            //seteo el login en el centro del scene raíz
            rootLayout.setCenter(anchorPaneLoginRoot);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * retorna el stage principal
     * @return 
     */
    public Stage getStagePrimario(){
        return stagePrimario;
    }
    
     /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        launch(args);
//    }
    
   /**
    * constructor UIMain
    */
    public UIMain(){
    }
}
