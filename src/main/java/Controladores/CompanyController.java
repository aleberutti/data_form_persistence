/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;


/**
 *
 * @author Admin
 */

//Clase para gestionar los datos de la empresa y de la planta en general
public class CompanyController {
    
    public FormController formcontroller;
    public MultipleDataController multiplecontroller;
    public Empresa company;
    private final CompanyDAO companyDAO;
    
    
    public CompanyController(){
        this.formcontroller = FormController.getInstance();
        this.multiplecontroller = MultipleDataController.getInstance();
        this.companyDAO = new CompanyDAO();
    }
    
    public void instantiate (){
        //Acá se obtienen todos los datos mediante formcontroller y multiplecontroller
        try{
           //Instancia Empresa
           String scuit = formcontroller.getSimpleDataForm("Pagina1.P1P1.Cuit1")
                   + formcontroller.getSimpleDataForm("Pagina1.P1P1.Cuit2")
                   + formcontroller.getSimpleDataForm("Pagina1.P1P1.Cuit3");
           Long cuit = Long.parseLong(scuit);
           String razonSocial = formcontroller.getSimpleDataForm("Pagina1.P1P1.RazonSocial");
           String sdate = formcontroller.getSimpleDataForm("Pagina1.P1P1.InicioDeActividades");
           System.out.println(sdate); 
           DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
           LocalDate localDate = LocalDate.parse(sdate, fmt);
           System.out.println(localDate.toString());
           Date fechaInicioActividades = Date.valueOf(localDate);
           System.out.println(fechaInicioActividades.toString());
           String nTipo = formcontroller.getSimpleDataForm("Pagina1.P1P1.TipoPersona");
           String tipoPersona = "";
           switch (nTipo){
               case "1":
                   tipoPersona+="Persona Física";
                   break;
                case "2":
                   tipoPersona+="Sociedad de Hecho";
                   break;
                case "3":
                   tipoPersona+="Persona Jurídica";
                   break;
           }
           this.company=new Empresa(cuit, razonSocial, fechaInicioActividades, tipoPersona);
           companyDAO.writeEmpresa(company);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    //Getters and setters
    public FormController getFormcontroller() {
        return formcontroller;
    }

    public void setFormcontroller(FormController formcontroller) {
        this.formcontroller = formcontroller;
    }

    public MultipleDataController getMultiplecontroller() {
        return multiplecontroller;
    }

    public void setMultiplecontroller(MultipleDataController multiplecontroller) {
        this.multiplecontroller = multiplecontroller;
    }

    public Empresa getCompany() {
        return company;
    }

    public void setCompany(Empresa company) {
        this.company = company;
    }
}
