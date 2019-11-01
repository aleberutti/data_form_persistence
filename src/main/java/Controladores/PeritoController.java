/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.*;


/**
 *
 * @author Admin
 */
//Clase para gestionar los datos del perito
public class PeritoController {
    
    public FormController formcontroller;
    public MultipleDataController multiplecontroller;
    public Perito perito;
    public final PeritoDAO peritoDAO;
    
    
    public PeritoController(){
      this.formcontroller = FormController.getInstance();
      this.multiplecontroller = MultipleDataController.getInstance();
      this.peritoDAO = new PeritoDAO();
    }
    
    public void instantiate(){
        //Se obtienen todos los datos mediante formcontroller y multiplecontroller
    }
}
