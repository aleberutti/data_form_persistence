/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;


/**
 *
 * @author Admin
 */
//Singleton Class // Solo se creará una sola instancia que manejará distintos archivos xml mediante el cambio del path
public class FormController {
    //Singleton
    
    private static FormController instance;
    
    //Unused//public HashMap<String, Nodo> form;
    public FileController filecontroller;
    public Document doc;
    public String path;
    
    //Public empty constructor
    private FormController() {
    }
    //getInstance del patrón singleton
    public static synchronized FormController getInstance(){
    if(instance==null){
        instance = new FormController();
    }
    return instance;
    }
    //Se carga el archivo xml y se obtiene el documento raíz
    public void loadXML()throws Exception{
        this.filecontroller = new FileController(this.path);
        filecontroller.cargar();
        SAXBuilder saxBuilder = new SAXBuilder();
        this.doc=saxBuilder.build(filecontroller.getArchivo());
    }
    

    
    //Método que realiza un call del método recursivo y devuelve el valor modificado
    public String getSimpleDataForm(String xpath) throws EmptyException {
        
        StringBuilder value= new StringBuilder();     
        
        //Call al método recursivo con la raíz del xml tree y el camino a seguir hacia el nodo deseado
        this.SimpleNodeSearcher(doc.getRootElement(), xpath, value);
        
        return value.toString();
    }
    //Método que realiza un call del método recursivo y devuelve una lista con los valores, se utiliza para campos dinámicos como las actividades
    public ArrayList <Element> getComplexDataForm(String xpath){
        
        ArrayList <Element> nodes = new ArrayList<>();
        
        //Call al método recursivo con la raíz del xml tree y el camino a seguir hacia el nodo deseado
        this.ComplexNodeSearcher(doc.getRootElement(), xpath, nodes);
        
        return nodes;
    }
    
    //Método recursivo para la obtención de un dato mediante su camino al nodo en el archivo xml
    public static void SimpleNodeSearcher (Element element, String xpath, StringBuilder value) throws EmptyException {
        StringTokenizer st= new StringTokenizer(xpath, ".");
        //System.out.println(xpath);
        while(st.hasMoreTokens()){
            //Caso base del método recursivo
            if(st.countTokens()==1){
                String nodeName= st.nextToken();
                String textContent = element.getChild(nodeName).getText();
                
                if(textContent.equals("")){
                    throw new EmptyException("The next node is empty: " + nodeName);
                }
                else{
                    //Modificamos el valor pasado como parámetro
                    value.append(textContent);
                }
                break;
            }
            else{
                //Recursividad
                String nodeName= st.nextToken();
                SimpleNodeSearcher(element.getChild(nodeName),st.nextToken("\n"), value);
                
            }
        }
    }
    public static void ComplexNodeSearcher (Element element, String xpath, ArrayList<Element> value){
        StringTokenizer st= new StringTokenizer(xpath, ".");
        //System.out.println(xpath);
        while(st.hasMoreTokens()){
            //Caso base del método recursivo
            if(st.countTokens()==1){
                String nodeName= st.nextToken();
                //System.out.println(nodeName);
                List<Element> nList = element.getChildren(nodeName);
                //System.out.println(nList.getLength());
                if (nList.size()>=1){
                    //Modificamos el valor pasado como parámetro
                    value.addAll(nList);
                }
                break;
                
            }
            else{
                //Recursividad
                String nodeName= st.nextToken();
                ComplexNodeSearcher(element.getChild(nodeName),st.nextToken("\n"), value);
                
            }
        }
    }
    public void setPath(String path){
        this.path=path;    
    }
    
    
}
