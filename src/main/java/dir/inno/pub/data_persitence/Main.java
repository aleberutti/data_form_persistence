/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dir.inno.pub.data_persitence;

import Controladores.*;
import javafx.application.Application;
import java.util.ArrayList;
import javafx.stage.Stage;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 *
 * @author Admin
 */
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Obtenemos el singleton
        UIGenericController controller = UIGenericController.getInstance();
        //Iniciamos la UI
        controller.start(primaryStage);
    }
     public static void main(String[] args) {
 
      try {
            launch(args);
//            FormController formController = FormController.getInstance();
//            formController.setPath("C:\\Users\\Admin\\Desktop\\Formulario de presentación v4.18 prueba 4 cerra3_datos.xml");
//            formController.loadXML();
//            CompanyController cc = new CompanyController();
//            cc.instantiate();
            //System.out.println(cc.getCompany().getFechaInicioActividades());
            //MultipleDataController multipleDataController = MultipleDataController.getInstance();
//            ArrayList<ArrayList<String>> data = multipleDataController.getWastePData();
//            if (!data.isEmpty()){
//                for(ArrayList<String> s: data){
//                System.out.println(s);
//                }
//            }
//            else{
//                System.out.println("VACIO NEGRI");
//            }
            //System.out.println("Retorno: " + formcontroller.getSimpleDataForm("Pagina1.P1P1.RazonSocial"));
           
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
    
}
