/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import org.hibernate.Session;

/**
 *
 * @author Admin
 */
//Clase de la cual extenderán todos los DAO
public class GenericDAO {
    private static Session SS;
    
    public GenericDAO(){
        SS = HibernateUtil.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.getTransaction().commit();
        SS.close();
    }

    public static void create(Object o){
        SS = HibernateUtil.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.save(o);
        SS.getTransaction().commit();
        SS.close();
    }
    
    
    public static Object read(Object o, int id){
        SS = HibernateUtil.getSessionFactory().openSession();
        SS.beginTransaction();
        Class c = o.getClass();
        Object obj = SS.get(c, id);
        SS.getTransaction().commit();
        SS.close();
        return obj;
    }
    
    public static void update(Object o){
        SS = HibernateUtil.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.update(o);
        SS.getTransaction().commit();
        SS.close();
    }

    public static void delete(Object o){
        SS = HibernateUtil.getSessionFactory().openSession();
        SS.beginTransaction();
        SS.delete(o);
        SS.getTransaction().commit();
        SS.close();
    }
}
