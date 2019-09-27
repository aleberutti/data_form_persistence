/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Admin
 */
  //Singleton Class
public class MainController {
    
    //Singleton instance
    private static MainController instance;
    
    //Se declaran todos los controladores que se necesitan para persistir todos los datos
    private static FormController formcontroller;
    private static CompanyController companycontroller;
    
    //Public empty constructor
    public MainController(){
        //Se instancian todos los controladores necesarios para la persistencia de todos los datos
        this.formcontroller = FormController.getInstance();
        this.companycontroller = new CompanyController();
    }
    //getInstance del patrón singleton
    public static synchronized MainController getInstance(){
    if(instance==null){
        instance = new MainController();
    }
    return instance;
    }
    
    public static void write(ObservableList<String> listaArchivos){
        //Por cada path de la lista, se persisten los datos del formulario
        for (String path: listaArchivos){
            
            try {
                formcontroller.setPath(path);
                formcontroller.loadXML();
                System.out.println(path);
                //ACÁ SE TIENEN QUE LLAMAR AL MÉTODO instantiate() DE CADA CONTROLADOR
                companycontroller.instantiate();
                
                
            } catch (Exception ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
