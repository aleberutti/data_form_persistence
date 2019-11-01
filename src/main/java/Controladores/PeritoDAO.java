/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Perito;
import org.hibernate.Session;
/**
 *
 * @author Admin
 */

//Clase que se encarga de la persistencia
public class PeritoDAO extends GenericDAO{
    private Session SS;
    
    public PeritoDAO(){
    }
    public void writeEmpresa(Perito perito){
        SS = HibernateUtil.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.save(perito);
        SS.getTransaction().commit();
        SS.close();
    }
    
}
