/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import dir.inno.pub.data_persitence.UIMain;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MODERNIZACION04
 */
public class UIMainSceneController{
    
     @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="vBox1"
    private VBox vBox1; // Value injected by FXMLLoader

    @FXML // fx:id="imgSantaFe"
    private ImageView imgSantaFe; // Value injected by FXMLLoader

    @FXML // fx:id="imgButtonProcesarLista"
    private ImageView imgButtonProcesarLista; // Value injected by FXMLLoader

    @FXML // fx:id="imgBtnMinimizar"
    private ImageView imgBtnMinimizar; // Value injected by FXMLLoader

    @FXML // fx:id="vBox2"
    private VBox vBox2; // Value injected by FXMLLoader

    @FXML // fx:id="rootAnchorPane"
    private AnchorPane rootAnchorPane; // Value injected by FXMLLoader

    @FXML // fx:id="labelExtraccion"
    private Label labelExtraccion; // Value injected by FXMLLoader

    @FXML // fx:id="imgButtonCargar"
    private ImageView imgButtonCargar; // Value injected by FXMLLoader

    @FXML // fx:id="buttonEliminar"
    private Button buttonEliminar; // Value injected by FXMLLoader

    @FXML // fx:id="buttonProcesarLista"
    private Button buttonProcesarLista; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerrar"
    private Button btnCerrar; // Value injected by FXMLLoader

    @FXML // fx:id="listViewArchivos"
    private ListView<String> listViewArchivos; // Value injected by FXMLLoader

    @FXML // fx:id="buttonCerrarSesion"
    private Button buttonCerrarSesion; // Value injected by FXMLLoader

    @FXML // fx:id="imgBtnCerrar"
    private ImageView imgBtnCerrar; // Value injected by FXMLLoader

    @FXML // fx:id="btnMinimizar"
    private Button btnMinimizar; // Value injected by FXMLLoader

    @FXML // fx:id="labelArchivos"
    private Label labelArchivos; // Value injected by FXMLLoader

    @FXML // fx:id="buttonCargar"
    private Button buttonCargar; // Value injected by FXMLLoader

    @FXML // fx:id="imgButtonEliminar"
    private ImageView imgButtonEliminar; // Value injected by FXMLLoader

    @FXML // fx:id="imgButtonCerrarSesion"
    private ImageView imgButtonCerrarSesion; // Value injected by FXMLLoader
    
    private Point mouseDownCompCoords = null;
    private UIMain ui;
    private ObservableList<String> listaArchivos = FXCollections.observableArrayList(); 
    
    
    /**
     * Constructor. Debe ser llamado antes del método initialize
     */
    public UIMainSceneController(){
        
    }
    
    /**
     * Initializes the controller class.
     */
    
    @FXML
    public void initialize() {
        assert vBox1 != null : "fx:id=\"vBox1\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert imgSantaFe != null : "fx:id=\"imgSantaFe\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert imgButtonProcesarLista != null : "fx:id=\"imgButtonProcesarLista\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert imgBtnMinimizar != null : "fx:id=\"imgBtnMinimizar\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert vBox2 != null : "fx:id=\"vBox2\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert rootAnchorPane != null : "fx:id=\"rootAnchorPane\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert labelExtraccion != null : "fx:id=\"labelExtraccion\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert imgButtonCargar != null : "fx:id=\"imgButtonCargar\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert buttonEliminar != null : "fx:id=\"buttonEliminar\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert buttonProcesarLista != null : "fx:id=\"buttonProcesarLista\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert btnCerrar != null : "fx:id=\"btnCerrar\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert listViewArchivos != null : "fx:id=\"listViewArchivos\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert buttonCerrarSesion != null : "fx:id=\"buttonCerrarSesion\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert imgBtnCerrar != null : "fx:id=\"imgBtnCerrar\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert btnMinimizar != null : "fx:id=\"btnMinimizar\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert labelArchivos != null : "fx:id=\"labelArchivos\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert buttonCargar != null : "fx:id=\"buttonCargar\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert imgButtonEliminar != null : "fx:id=\"imgButtonEliminar\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert imgButtonCerrarSesion != null : "fx:id=\"imgButtonCerrarSesion\" was not injected: check your FXML file 'MainScene.fxml'.";
      
    }
    
    @FXML
    public void buttonDelete(){
        String item;
        item = this.listViewArchivos.getSelectionModel().getSelectedItem();
        this.listViewArchivos.getItems().remove(item);  
    }
    
    @FXML
    public void btnMinimizar(ActionEvent event){
        ((Stage) (((Button)event.getSource()).getScene().getWindow())).setIconified(true);
    }
    
    @FXML
    public void btnCerrar(ActionEvent event){
        ((Stage) (((Button)event.getSource()).getScene().getWindow())).close();
    }
    
    @FXML
    public void buttonCargar(ActionEvent event){
        String path;
        Stage stage = ((Stage) (((Button)event.getSource()).getScene().getWindow()));
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Elija los archivos");
        // Set extension filter
        FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        File archivo = fileChooser.showOpenDialog(stage);
        
        if (archivo != null) {
            path = archivo.toString();
            listaArchivos.add(path);
            listViewArchivos.setItems(listaArchivos);
            listViewArchivos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        }
    }
    @FXML
    public void buttonProcesarLista(ActionEvent event){
        MainController maincontroller = MainController.getInstance();
        maincontroller.write(listaArchivos);
    }
    
    @FXML
    public void buttonCerrarSesion(ActionEvent event) throws MalformedURLException, IOException{

        UIGenericController controller = UIGenericController.getInstance();
        controller.showLogin();


         //UNUSED CODE
//       Scene scene;
//       FXMLLoader loader = new FXMLLoader();
//       
//       URL location = getClass().getResource("/fxml/Login.fxml");
//       loader.setLocation(location);
//              
//       AnchorPane anchorPaneLoginRoot = (AnchorPane) loader.load();
//       scene = new Scene(anchorPaneLoginRoot);
//       ((Stage) (((Button)event.getSource()).getScene().getWindow())).setScene(scene);
    }
    
    public static void display(String title, String message) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        //window.initStyle(StageStyle.UNDECORATED);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Cerrar");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
