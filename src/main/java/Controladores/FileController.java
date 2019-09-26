/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author ale_b
 */
//Clase controladora de archivos
public class FileController {
    public String path;
    public File archivo;
    public FileReader fr;
    public FileWriter fw;
    public BufferedReader br;
    public BufferedWriter bw;
    
    
    public FileController (String path){
        this.path=path;
        this.archivo= null;
        this.fw=null;
        fr = null;
        br = null;
        bw =null;
    }
    public void crear(){
        try{
            this.archivo = new File (this.path);
            archivo.createNewFile();
            this.fw = new FileWriter(archivo);
            this.bw = new BufferedWriter(fw);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void cargar(){
        try{
            this.archivo = new File (this.path);
            this.fr = new FileReader (archivo);
            this.br = new BufferedReader(fr);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void cerrar(){
        try{                    
            if(this.fr != null){   
               this.fr.close();
            }                  
         }
         catch (Exception e2){ 
            e2.printStackTrace();
          }
    }
    public void cerrarCreado(){
        try{                    
            if(this.fw != null){   
               this.fw.close();
            }                  
         }
         catch (Exception e3){ 
            e3.printStackTrace();
          }
    }

    public File getArchivo() {
        return archivo;
    }

    public FileReader getFr() {
        return fr;
    }

    public BufferedReader getBr() {
        return br;
    }
    public BufferedWriter getWriter(){
        return bw;
    }
}
