/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

package Controladores;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UILoginController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="imgIconLogin"
    private ImageView imgIconLogin; // Value injected by FXMLLoader

    @FXML // fx:id="anchorPaneLoginRoot"
    private AnchorPane anchorPaneLoginRoot; // Value injected by FXMLLoader

    @FXML // fx:id="anchorPaneDatosLogin"
    private AnchorPane anchorPaneDatosLogin; // Value injected by FXMLLoader

    @FXML // fx:id="imgBtnMinimizar"
    private ImageView imgBtnMinimizar; // Value injected by FXMLLoader

    @FXML // fx:id="imgButtonCerrar"
    private ImageView imgButtonCerrar; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldUsername"
    private TextField textFieldUsername; // Value injected by FXMLLoader

    @FXML // fx:id="btnMinimizarLogin"
    private Button btnMinimizarLogin; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancelar"
    private Button btnCancelar; // Value injected by FXMLLoader

    @FXML // fx:id="btnInicioSesion"
    private Button btnInicioSesion; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerrarLogin"
    private Button btnCerrarLogin; // Value injected by FXMLLoader

    @FXML // fx:id="passwordFieldLogin"
    private PasswordField passwordFieldLogin; // Value injected by FXMLLoader

    @FXML // fx:id="imgLogin"
    private ImageView imgLogin; // Value injected by FXMLLoader


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert imgIconLogin != null : "fx:id=\"imgIconLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert anchorPaneLoginRoot != null : "fx:id=\"anchorPaneLoginRoot\" was not injected: check your FXML file 'Login.fxml'.";
        assert anchorPaneDatosLogin != null : "fx:id=\"anchorPaneDatosLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert imgBtnMinimizar != null : "fx:id=\"imgBtnMinimizar\" was not injected: check your FXML file 'Login.fxml'.";
        assert imgButtonCerrar != null : "fx:id=\"imgButtonCerrar\" was not injected: check your FXML file 'Login.fxml'.";
        assert textFieldUsername != null : "fx:id=\"textFieldUsername\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnMinimizarLogin != null : "fx:id=\"btnMinimizarLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnCancelar != null : "fx:id=\"btnCancelar\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnInicioSesion != null : "fx:id=\"btnInicioSesion\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnCerrarLogin != null : "fx:id=\"btnCerrarLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert passwordFieldLogin != null : "fx:id=\"passwordFieldLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert imgLogin != null : "fx:id=\"imgLogin\" was not injected: check your FXML file 'Login.fxml'.";
    }
    
    @FXML
    public void btnCerrarLoginAction(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
    
    @FXML
    public void btnMinimizarLoginAction(ActionEvent event){
        ((Stage) (((Button)event.getSource()).getScene().getWindow())).setIconified(true);
    } 
    
    @FXML
    public void btnCancelarAction(ActionEvent event){
        textFieldUsername.clear();
        passwordFieldLogin.clear();
    }
    
    @FXML
    public void btnInicioSesionAction(ActionEvent event) throws MalformedURLException, IOException{
        String user = textFieldUsername.getText();
        String pswd = passwordFieldLogin.getText();
        
       if((user.isEmpty() || pswd.isEmpty()) || (user.length() != 8 || pswd.length() != 8 )){
           //Notifications.create().title("Error").text("Network is unreachable").showError();
           display("","Debe completar correctamente los campos de usuario y contraseña para iniciar sesión.");
           System.out.println("Debe completar correctamente los campos de usuario y contraseña para iniciar sesión.");
       }
       else{
           if(user.length() == 8 && pswd.length() == 8){
               System.out.println("Campos correctos. Sesión iniciada.");
               
               UIGenericController controller = UIGenericController.getInstance();
               controller.showMainScene();
               
               //UNUSED CODE
//               Scene scene;
//               FXMLLoader loader = new FXMLLoader();
//               
//               URL location = getClass().getResource("/fxml/MainScene.fxml");
//               loader.setLocation(location);
//                              
//               AnchorPane rootAnchorPane = (AnchorPane) loader.load();
//               scene = new Scene(rootAnchorPane);
//               ((Stage) (((Button)event.getSource()).getScene().getWindow())).setScene(scene);
           }     
       }    
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
