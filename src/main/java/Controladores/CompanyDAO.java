/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import org.hibernate.Session;
import Modelo.Empresa;
/**
 *
 * @author Admin
 */

//Clase que se encarga de la persistencia
public class CompanyDAO extends GenericDAO{
    private Session SS;
    
    public CompanyDAO(){
    }
    public void writeEmpresa(Empresa company){
        SS = HibernateUtil.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.save(company);
        SS.getTransaction().commit();
        SS.close();
    }
}
