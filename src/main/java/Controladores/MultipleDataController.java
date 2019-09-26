/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.util.ArrayList;
import org.jdom2.Element;

/**
 *
 * @author Admin
 */
//Clase para gestionar los datos dinámicos del formulario
//Singleton Class // Solo se creará una sola instancia
public class MultipleDataController {
    //Attributes
    public ArrayList<Element> nodes = new ArrayList<>();
    public FormController formController;
    
    //Singleton
    
    private static MultipleDataController instance;
    
    //Public constructor
    public MultipleDataController(){
        this.formController = FormController.getInstance();
    }
    
    //getInstance del patrón singleton
    public static synchronized MultipleDataController getInstance(){
    if(instance==null){
        instance = new MultipleDataController();
    }
    return instance;
    }
    
    //Método para obtener las actividades de la empresa
    public ArrayList<ArrayList<String>> getActivitiesData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina1.P1P2.P1P2SP2.P1P2SP2.Actividad");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
                //Grupo
                formController.SimpleNodeSearcher(n,"HeaderGrupo.ACTGRAL", value);
                temp.add(value.toString());
                value.setLength(0);
                //Actividad
                formController.SimpleNodeSearcher(n,"HeaderActividad.ACTIVIDADES", value);
                temp.add(value.toString());
                value.setLength(0);
                //Prioridad
                formController.SimpleNodeSearcher(n,"HeaderTipoCodigoEstandar.TIPOACT", value);
                temp.add(value.toString());
                value.setLength(0);
                //CUACM
                formController.SimpleNodeSearcher(n,"HeaderTipoCodigoEstandar.CUACM", value);
                temp.add(value.toString());
                value.setLength(0);
                //Estandar
                formController.SimpleNodeSearcher(n,"HeaderTipoCodigoEstandar.ESTANDAR", value);
                temp.add(value.toString());
                value.setLength(0);
               

                data.add(temp);
            }catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
            }
            
        }
        return data;
    }
    //Método para obtener los datos de las autoridades de la empresa
    public ArrayList<ArrayList<String>> getAutoritiesData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina2.P2P2.P2P2SP2.TablaAutoridades.Autoridades");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
                //Apellido
                formController.SimpleNodeSearcher(n,".ApellidoAutoridadesSocietarias", value);
                temp.add(value.toString());
                value.setLength(0);
                //Nombre
                formController.SimpleNodeSearcher(n,".NombreAutoridadesSocietarias", value);
                temp.add(value.toString());
                value.setLength(0);
                //Documento
                formController.SimpleNodeSearcher(n,".DocumentoAutoridadesSocietarias", value);
                temp.add(value.toString());
                value.setLength(0);
                //Cargo
                formController.SimpleNodeSearcher(n,".CargoAutoridadesSocietarias", value);
                temp.add(value.toString());
                value.setLength(0);

                data.add(temp);
            }catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
            }
            
        }
        return data;
    }
    //Método para obtener los datos de los administradores/representantes de la empresa
    public ArrayList<ArrayList<String>> getAdministratorsData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina2.P2P3.P2P3SP2.TablaAdministradores.Administradores");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
                //Apellido
                formController.SimpleNodeSearcher(n,".ApellidoAdministradores", value);
                temp.add(value.toString());
                value.setLength(0);
                //Nombre
                formController.SimpleNodeSearcher(n,".NombreAdministradores", value);
                temp.add(value.toString());
                value.setLength(0);
                //Documento
                formController.SimpleNodeSearcher(n,".DocumentoAdministradores", value);
                temp.add(value.toString());
                value.setLength(0);
                //Cargo
                formController.SimpleNodeSearcher(n,".CargoAdministradores", value);
                temp.add(value.toString());
                value.setLength(0);

                data.add(temp);
            }catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
            }
            
        }
        return data;
    }
    //Método para obtener los números de partidas junto con su latitud y longitud
    public ArrayList<ArrayList<String>> getPartidaData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina3.PartidaInmobiliaria.TablaPartidaInmobiliaria.Row1");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try {
                //Numero de partida inmobiliaria
                formController.SimpleNodeSearcher(n,".NumPartidaInmobiliaria", value);
                temp.add(value.toString());
                value.setLength(0);
                //Latitud
                formController.SimpleNodeSearcher(n,".LatPartidaInmobiliaria", value);
                temp.add(value.toString());
                value.setLength(0);
                //Longitud
                formController.SimpleNodeSearcher(n,".LongPartidaInmobiliaria", value);
                temp.add(value.toString());
                value.setLength(0);

                data.add(temp);
            }catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
            }
            
        }
        return data;
    }
    //Método para obtener los domicilios de las plantas fuera de la provincia
    public ArrayList<ArrayList<String>> getPlantAddressData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina4.P4P3.P4P3SP2.TablaPlantasFueraProv.Row1");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
                //Primero comprobamos el valor del radio button
                String rbPlantasFueraDeProv = this.formController.getSimpleDataForm("Pagina4.P4P3.P4P3SP1.RBPlantasFueraProv");
                if(rbPlantasFueraDeProv.equals("2"))throw new EmptyException("NO");
               //Domicilio de la planta fuera de la provincia
                formController.SimpleNodeSearcher(n,".DomicilioPlantaFueraProvincia", value);
                temp.add(value.toString());
                value.setLength(0);
                //Provincia de la planta fuera de la provincia
                formController.SimpleNodeSearcher(n,".PROVINCIAPlantaFueraProvincia", value);
                temp.add(value.toString());
                value.setLength(0);
                //Localidad de la planta fuera de la provincia
                formController.SimpleNodeSearcher(n,".LocalidadPlantaFueraProvincia", value);
                temp.add(value.toString());
                value.setLength(0);
                //CP de la planta fuera de la provincia
                formController.SimpleNodeSearcher(n,".CodigoPostalPlantaFueraProvincia", value);
                temp.add(value.toString());
                value.setLength(0);

                data.add(temp); 
            } catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
                if(ex.getMessage().equals("NO")) break;
                
            }
            
        }
        return data;
    }
    //Método para obtener los datos de los productos de la empresa
    public ArrayList<ArrayList<String>> getProductData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina4.P4P5.P4P5SP2.Table1.Row1");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        ArrayList<Element> tempNodes = this.formController.getComplexDataForm("Pagina5.P5P1.P5P1SP2.Table1.Row11");
        int index = 0;
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
               //Nombre
                formController.SimpleNodeSearcher(n,".NombreProducto", value);
                temp.add(value.toString());
                value.setLength(0);
                //Estado Fisico
                formController.SimpleNodeSearcher(n,".EstadoFisicoProducto", value);
                temp.add(value.toString());
                value.setLength(0);
                //Produccion Anual
                formController.SimpleNodeSearcher(n,".ProduccionAnualProducto", value);
                temp.add(value.toString());
                value.setLength(0);
                //Unidad de la produccion anual
                formController.SimpleNodeSearcher(n,".UnidadProducto", value);
                temp.add(value.toString());
                value.setLength(0);
                //Almacenamiento del producto
                formController.SimpleNodeSearcher(n,".AlmacenamientoProducto", value);
                temp.add(value.toString());
                value.setLength(0);
                //Clasificación de producto
                formController.SimpleNodeSearcher(tempNodes.get(index),".ClasificacionProducto", value);
                temp.add(value.toString());
                value.setLength(0);
                //Clasificación de producto
                formController.SimpleNodeSearcher(tempNodes.get(index),".OtraClasificacionProducto", value);
                temp.add(value.toString());
                value.setLength(0);
                
                data.add(temp); 
            } catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
            }
            index++;
            
        }
        return data;
    }
    //Método para obtener los datos de los subproductos de la empresa
    public ArrayList<ArrayList<String>> getSubProductData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina5.P5P3.P5P3SP2.Table1.Row1");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
               //Nombre
                formController.SimpleNodeSearcher(n,".NombreSubproducto", value);
                temp.add(value.toString());
                value.setLength(0);
                //Estado Fisico
                formController.SimpleNodeSearcher(n,".EstadoFisicoSubproducto", value);
                temp.add(value.toString());
                value.setLength(0);
                //Produccion Anual
                formController.SimpleNodeSearcher(n,".ProduccionAnualSubproducto", value);
                temp.add(value.toString());
                value.setLength(0);
                //Unidad de la produccion anual
                formController.SimpleNodeSearcher(n,".UnidadSubproducto", value);
                temp.add(value.toString());
                value.setLength(0);
                //Almacenamiento del subproducto
                formController.SimpleNodeSearcher(n,".AlmacenamientoSubproducto", value);
                temp.add(value.toString());
                value.setLength(0);
                
                data.add(temp); 
            } catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
            }
            
        }
        return data;
    }
    //Método para obtener los datos de las materias primas de la empresa
    public ArrayList<ArrayList<String>> getRawMaterialData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina5.P5P4.P5P4SP2.Table1.Row1");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
               //Nombre
                formController.SimpleNodeSearcher(n,".NombreMateriaPrima", value);
                temp.add(value.toString());
                value.setLength(0);
                //Estado Fisico
                formController.SimpleNodeSearcher(n,".EstadoFisicoMateriaPrima", value);
                temp.add(value.toString());
                value.setLength(0);
                //Consumo Anual
                formController.SimpleNodeSearcher(n,".ConsumoAnualMateriaPrima", value);
                temp.add(value.toString());
                value.setLength(0);
                //Unidad del consumo anual
                formController.SimpleNodeSearcher(n,".UnidadMateriaPrima", value);
                temp.add(value.toString());
                value.setLength(0);
                //Almacenamiento de la materia prima
                formController.SimpleNodeSearcher(n,".AlmacenamientoMateriaPrima", value);
                temp.add(value.toString());
                value.setLength(0);
                
                data.add(temp); 
            } catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
            }
            
        }
        return data;
    }
    //Método para obtener los datos de los insumos utilizados en la empresa empresa
    public ArrayList<ArrayList<String>> getInputData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina5.P5P5.P5P5SP2.Table1.Row1");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
               //Nombre
                formController.SimpleNodeSearcher(n,".NombreInsumo", value);
                temp.add(value.toString());
                value.setLength(0);
                //Estado Fisico
                formController.SimpleNodeSearcher(n,".EstadoFisicoInsumo", value);
                temp.add(value.toString());
                value.setLength(0);
                //Consumo Anual
                formController.SimpleNodeSearcher(n,".ConsumoAnualInsumo", value);
                temp.add(value.toString());
                value.setLength(0);
                //Unidad del consumo anual
                formController.SimpleNodeSearcher(n,".UnidadInsumo", value);
                temp.add(value.toString());
                value.setLength(0);
                //Almacenamiento del insumo
                formController.SimpleNodeSearcher(n,".AlmacenamientoInsumo", value);
                temp.add(value.toString());
                value.setLength(0);
                
                data.add(temp); 
            } catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
            }
            
        }
        return data;
    }
    //Método para obtener los datos de las sustancias auxiliares utilizados en la empresa empresa
    public ArrayList<ArrayList<String>> getAuxSubstanceData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina6.P6P3.P6P3SP2.TablaSustanciasAuxiliares.Row1");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
                String rbCombustibles = this.formController.getSimpleDataForm("Pagina6.P6P3.P6P3SP1.RBCombustiblesLiquidos");
                String rbGasNatural = this.formController.getSimpleDataForm("Pagina6.P6P3.P6P3SP1.RBGasNatural");
                String rbAceitesyLubricantes = this.formController.getSimpleDataForm("Pagina6.P6P3.P6P3SP1.RBAceitesYLubricantes");
                String rbAireComprimido = this.formController.getSimpleDataForm("Pagina6.P6P3.P6P3SP1.RBAireComprimido");
                if (rbCombustibles.equals("0") && rbGasNatural.equals("0") &&
                    rbAceitesyLubricantes.equals("0") && rbAireComprimido.equals("0")) throw new EmptyException("NO");
                //Nombre
                formController.SimpleNodeSearcher(n,".NombreSustanciasAuxiliaresYFluidos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Consumo Anual
                formController.SimpleNodeSearcher(n,".ConsumoAnualSustanciasAuxiliares", value);
                temp.add(value.toString());
                value.setLength(0);
                //Unidad del consumo anual
                formController.SimpleNodeSearcher(n,".UnidadSustanciasAuxiliares", value);
                temp.add(value.toString());
                value.setLength(0);
                //Almacenamiento de la sustancia auxiliar
                formController.SimpleNodeSearcher(n,".AlmacenamientoSustanciasAuxiliares", value);
                temp.add(value.toString());
                value.setLength(0);
                
                data.add(temp); 
            } catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
                if(ex.getMessage().equals("NO")) break;
            }
            
        }
        return data;
    }
    //Método para obtener los datos de los inmuebles anexos de la empresa empresa
    public ArrayList<ArrayList<String>> getAnnexPropertyData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina7.P7P2.P7P2SP2.T34.Row1");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
                String rbInmueblesAnexos = this.formController.getSimpleDataForm("Pagina7.P7P2.P7P2SP1.RBInmueblesAnexos");
                if (rbInmueblesAnexos.equals("0"))throw new EmptyException("NO");
                //Domicilio
                formController.SimpleNodeSearcher(n,".DomicilioInmueblesAnexos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Actividad
                formController.SimpleNodeSearcher(n,".ActividadInmueblesAnexos", value);
                temp.add(value.toString());
                value.setLength(0);
                
                data.add(temp); 
            } catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
                if(ex.getMessage().equals("NO")) break;
            }
            
        }
        return data;
    }
    //Método para obtener los datos de las emisiones de componentes naturales de la empresa empresa
    public ArrayList<ArrayList<String>> getEmissionsNCData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina8.P8P2.P8P2SP2.T41.Row1");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
                String rbEmissionsNC = this.formController.getSimpleDataForm("Pagina8.P8P2.P8P2SP1.RBEmisionesComponentesNaturalesAire");
                if (rbEmissionsNC.equals("0"))throw new EmptyException("NO");
                //Emision
                formController.SimpleNodeSearcher(n,".NombreEmisionesGaseosasNaturales", value);
                temp.add(value.toString());
                value.setLength(0);
                //Proceso que lo genera
                formController.SimpleNodeSearcher(n,".ProcesoEmisionesGaseosasNaturales", value);
                temp.add(value.toString());
                value.setLength(0);
                //Tratamiento
                formController.SimpleNodeSearcher(n,".TratamientoEmisionesGaseosasNaturales", value);
                temp.add(value.toString());
                value.setLength(0);
                
                data.add(temp); 
            } catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
                if(ex.getMessage().equals("NO")) break;
            }
            
        }
        return data;
    }
    //Método para obtener los datos de las emisiones provocadas por combustión de la empresa empresa
    public ArrayList<ArrayList<String>> getEmissionsCData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina8.P8P3.P8P3SP2.T42.Row1");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
                String rbEmissionsC = this.formController.getSimpleDataForm("Pagina8.P8P3.P8P3SP1.RBEmisionesGaseosaCombustion");
                if (rbEmissionsC.equals("0"))throw new EmptyException("NO");
                //Emision
                formController.SimpleNodeSearcher(n,".NombreEmisionesGaseosaCombustion", value);
                temp.add(value.toString());
                value.setLength(0);
                //Proceso que lo genera
                formController.SimpleNodeSearcher(n,".ProcesoEmisionesGaseosaCombustion", value);
                temp.add(value.toString());
                value.setLength(0);
                //Tratamiento
                formController.SimpleNodeSearcher(n,".TratamientoEmisionesGaseosaCombustion", value);
                temp.add(value.toString());
                value.setLength(0);
                
                data.add(temp); 
            } catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
                if(ex.getMessage().equals("NO")) break;
            }
            
        }
        return data;
    }
    //Método para obtener los datos de las emisiones de gases no contemplados de la empresa empresa
    public ArrayList<ArrayList<String>> getEmissionsNOData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina8.P8P4.P8P4SP2.T43.Row1");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
                String rbEmissionsNO = this.formController.getSimpleDataForm("Pagina8.P8P4.P8P4SP1.RBEmisionesGasesNoContemplados");
                if (rbEmissionsNO.equals("0"))throw new EmptyException("NO");
                //Emision
                formController.SimpleNodeSearcher(n,".ProcesoEmisionesGasesNoContemplados", value);
                temp.add(value.toString());
                value.setLength(0);
                //Proceso que lo genera
                formController.SimpleNodeSearcher(n,".ComponentesEmisionesGasesNoContemplados", value);
                temp.add(value.toString());
                value.setLength(0);
                //Tratamiento
                formController.SimpleNodeSearcher(n,".TratamientoEmisionesGasesNoContemplados", value);
                temp.add(value.toString());
                value.setLength(0);
                
                data.add(temp); 
            } catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
                if(ex.getMessage().equals("NO")) break;
            }
            
        }
        return data;
    }
    //Método para obtener los datos de los residuos liquidos no peligrosos de la empresa empresa
    public ArrayList<ArrayList<String>> getEffluentsNPData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina9.P9P2.P9P2SP2.Table60");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
                String rbEffluentsNP = this.formController.getSimpleDataForm("Pagina9.P9P2.P9P2SP1.RBResiduoLiquidoNoPeligroso");
                if (rbEffluentsNP.equals("0"))throw new EmptyException("NO");
                //Proceso que lo genera
                formController.SimpleNodeSearcher(n,".Fila2.ProcesoResiduoLiquidoNoPeligroso", value);
                temp.add(value.toString());
                value.setLength(0);
                //Componentes relevantes
                formController.SimpleNodeSearcher(n,".Fila3.ComponenteResiduoLiquidoNoPeligroso", value);
                temp.add(value.toString());
                value.setLength(0);
                //Volumen valor
                formController.SimpleNodeSearcher(n,".Fila4.Volumen.Row1.ValorVolumenResiduoLiquidoNoPeligroso", value);
                temp.add(value.toString());
                value.setLength(0);
                //Volumen unidad
                formController.SimpleNodeSearcher(n,".Fila4.Volumen.Row1.UnidadVolumenResiduoLiquidoNoPeligroso", value);
                temp.add(value.toString());
                value.setLength(0);
                //Volumen tiempo
                formController.SimpleNodeSearcher(n,".Fila4.Volumen.Row1.PeriodoVolumenResiduoLiquidoNoPeligroso", value);
                temp.add(value.toString());
                value.setLength(0);
                //Gestion del efluente
                while (true){
                    StringBuilder valueD = new StringBuilder();
                    StringBuilder valueT = new StringBuilder();
                    StringBuilder valueN = new StringBuilder();
                    StringBuilder valueO = new StringBuilder();
                    StringBuilder valueOtro = new StringBuilder();
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row1.Decantacion", valueD);
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row1.TratamientoBiologico", valueT);
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row1.Neutralizacion", valueN);
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row2.Oxidacion", valueO);
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row2.Otro", valueOtro);
                    
                    //Si la gestion es "Ninguno" sale del bucle while
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row2.Ninguno", value);
                    if (value.toString().equals("1")){
                        value.setLength(0);
                        value.append("Ninguno");
                        break;
                    }
                    //Sino 
                    
                    value.setLength(0);
                    
                    if (valueD.toString().equals("1")) {
                        if (valueT.toString().equals("0") && valueN.toString().equals("0") &&
                                valueO.toString().equals("0") && valueOtro.toString().equals("0")){
                            value.append("Decantación");
                            break;
                        }
                        else{
                            value.append("Decantación/");
                        }
                    }
                    if (valueT.toString().equals("1")){
                        if (valueN.toString().equals("0") && valueO.toString().equals("0") && 
                                valueOtro.toString().equals("0")){
                            value.append("Tratamiento biológico");
                            break;
                        }
                        else{
                            value.append("Tratamiento biológico/");
                        } 
                    } 
                    
                    if (valueN.toString().equals("1")) {
                        if (valueO.toString().equals("0") && valueOtro.toString().equals("0")){
                            value.append("Neutralización");
                            break;
                        }
                        else{
                            value.append("Neutralización/");
                        }
                    }
                    
                    if (valueO.toString().equals("1")){
                        if (valueOtro.toString().equals("0")){
                            value.append("Oxidación");
                            break;
                        }
                        else{
                            value.append("Oxidación/");
                        }
                    }
                    
                    if (valueOtro.toString().equals("1")){
                        value.append("Otro: ");
                        this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row3.DescripcionOtro", value); 
                    } 
                    break;
                }
                temp.add(value.toString());
                value.setLength(0);
                //Cuerpo receptor
                formController.SimpleNodeSearcher(n,".Fila6.CuerpoReceptorResiduoLiquidoNoPeligroso", value);
                temp.add(value.toString());
                value.setLength(0);
                data.add(temp); 
            } catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
                if(ex.getMessage().equals("NO")) break;
            }
            
        }
        return data;
    }
    //Método para obtener los datos de los residuos liquidos  peligrosos de la empresa empresa
    public ArrayList<ArrayList<String>> getEffluentsPData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina9.P9P3.P9P3SP2.Table60");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
                String rbEffluentsNP = this.formController.getSimpleDataForm("Pagina9.P9P3.P9P3SP1.RBResiduoLiquidoPeligroso");
                if (rbEffluentsNP.equals("0"))throw new EmptyException("NO");
                //Proceso que lo genera
                formController.SimpleNodeSearcher(n,".Fila2.ProcesoResiduoLiquidoPeligroso", value);
                temp.add(value.toString());
                value.setLength(0);
                //Componentes relevantes
                formController.SimpleNodeSearcher(n,".Fila3.ComponenteResiduoLiquidoPeligroso", value);
                temp.add(value.toString());
                value.setLength(0);
                //Volumen valor
                formController.SimpleNodeSearcher(n,".Fila4.Volumen.Row1.ValorResiduoLiquidoPeligroso", value);
                temp.add(value.toString());
                value.setLength(0);
                //Volumen unidad
                formController.SimpleNodeSearcher(n,".Fila4.Volumen.Row1.UnidadResiduoLiquidoPeligroso", value);
                temp.add(value.toString());
                value.setLength(0);
                //Volumen tiempo
                formController.SimpleNodeSearcher(n,".Fila4.Volumen.Row1.PeriodoResiduoLiquidoPeligroso", value);
                temp.add(value.toString());
                value.setLength(0);
                //Gestion del efluente
                while (true){
                    StringBuilder valueD = new StringBuilder();
                    StringBuilder valueT = new StringBuilder();
                    StringBuilder valueN = new StringBuilder();
                    StringBuilder valueO = new StringBuilder();
                    StringBuilder valueOtro = new StringBuilder();
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row1.Decantacion", valueD);
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row1.TratamientoBiologico", valueT);
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row1.Neutralizacion", valueN);
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row2.Oxidacion", valueO);
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row2.Otro", valueOtro);
                    
                    //Si la gestion es "Ninguno" sale del bucle while
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row2.Ninguno", value);
                    if (value.toString().equals("1")){
                        value.setLength(0);
                        value.append("Ninguno");
                        break;
                    }
                    //Sino 
                    
                    value.setLength(0);
                    
                    if (valueD.toString().equals("1")) {
                        if (valueT.toString().equals("0") && valueN.toString().equals("0") &&
                                valueO.toString().equals("0") && valueOtro.toString().equals("0")){
                            value.append("Decantación");
                            break;
                        }
                        else{
                            value.append("Decantación/");
                        }
                    }
                    if (valueT.toString().equals("1")){
                        if (valueN.toString().equals("0") && valueO.toString().equals("0") && 
                                valueOtro.toString().equals("0")){
                            value.append("Tratamiento biológico");
                            break;
                        }
                        else{
                            value.append("Tratamiento biológico/");
                        } 
                    } 
                    
                    if (valueN.toString().equals("1")) {
                        if (valueO.toString().equals("0") && valueOtro.toString().equals("0")){
                            value.append("Neutralización");
                            break;
                        }
                        else{
                            value.append("Neutralización/");
                        }
                    }
                    
                    if (valueO.toString().equals("1")){
                        if (valueOtro.toString().equals("0")){
                            value.append("Oxidación");
                            break;
                        }
                        else{
                            value.append("Oxidación/");
                        }
                    }
                    
                    if (valueOtro.toString().equals("1")){
                        value.append("Otro: ");
                        this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row3.DescripcionOtro", value); 
                    } 
                    break;
                }
                temp.add(value.toString());
                value.setLength(0);
                //Cuerpo receptor
                formController.SimpleNodeSearcher(n,".Fila6.CuerpoReceptorResiduoLiquidoPeligroso", value);
                temp.add(value.toString());
                value.setLength(0);
                data.add(temp); 
            } catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
                if(ex.getMessage().equals("NO")) break;
            }
            
        }
        return data;
    }
    //Método para obtener los datos de los residuos liquidos que requieren más de un tratamiento de la empresa empresa
    public ArrayList<ArrayList<String>> getEffluentsMTData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina9.P9P4.P9P4SP2.Table60");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
                String rbEffluentsNP = this.formController.getSimpleDataForm("Pagina9.P9P4.P9P4SP1.RBMasDeUnTratamientoEfluentesLiquidos");
                if (rbEffluentsNP.equals("0"))throw new EmptyException("NO");
                //Proceso que lo genera
                formController.SimpleNodeSearcher(n,".Fila2.ProcesoTratamientoLiquidos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Componentes relevantes
                formController.SimpleNodeSearcher(n,".Fila3.ComponenteTratamientoLiquidos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Volumen valor
                formController.SimpleNodeSearcher(n,".Fila4.Volumen.Row1.ValorTratamientoLiquidos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Volumen unidad
                formController.SimpleNodeSearcher(n,".Fila4.Volumen.Row1.UnidadTratamientoLiquidos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Volumen tiempo
                formController.SimpleNodeSearcher(n,".Fila4.Volumen.Row1.PeriodoTratamientoLiquidos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Gestion del efluente
                while (true){
                    StringBuilder valueD = new StringBuilder();
                    StringBuilder valueT = new StringBuilder();
                    StringBuilder valueN = new StringBuilder();
                    StringBuilder valueO = new StringBuilder();
                    StringBuilder valueOtro = new StringBuilder();
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row1.Decantacion", valueD);
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row1.TratamientoBiologico", valueT);
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row1.Neutralizacion", valueN);
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row2.Oxidacion", valueO);
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row2.Otro", valueOtro);
                    
                    //Si la gestion es "Ninguno" sale del bucle while
                    this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row2.Ninguno", value);
                    if (value.toString().equals("1")){
                        value.setLength(0);
                        value.append("Ninguno");
                        break;
                    }
                    //Sino 
                    
                    value.setLength(0);
                    
                    if (valueD.toString().equals("1")) {
                        if (valueT.toString().equals("0") && valueN.toString().equals("0") &&
                                valueO.toString().equals("0") && valueOtro.toString().equals("0")){
                            value.append("Decantación");
                            break;
                        }
                        else{
                            value.append("Decantación/");
                        }
                    }
                    if (valueT.toString().equals("1")){
                        if (valueN.toString().equals("0") && valueO.toString().equals("0") && 
                                valueOtro.toString().equals("0")){
                            value.append("Tratamiento biológico");
                            break;
                        }
                        else{
                            value.append("Tratamiento biológico/");
                        } 
                    } 
                    
                    if (valueN.toString().equals("1")) {
                        if (valueO.toString().equals("0") && valueOtro.toString().equals("0")){
                            value.append("Neutralización");
                            break;
                        }
                        else{
                            value.append("Neutralización/");
                        }
                    }
                    
                    if (valueO.toString().equals("1")){
                        if (valueOtro.toString().equals("0")){
                            value.append("Oxidación");
                            break;
                        }
                        else{
                            value.append("Oxidación/");
                        }
                    }
                    
                    if (valueOtro.toString().equals("1")){
                        value.append("Otro: ");
                        this.formController.SimpleNodeSearcher(n,".Fila5.Gestion.Row3.DescripcionOtro", value); 
                    } 
                    break;
                }
                temp.add(value.toString());
                value.setLength(0);
                //Cuerpo receptor
                formController.SimpleNodeSearcher(n,".Fila6.CuerpoReceptorTratamientoLiquidos", value);
                temp.add(value.toString());
                value.setLength(0);
                data.add(temp); 
            } catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
                if(ex.getMessage().equals("NO")) break;
            }
            
        }
        return data;
    }
    //Método para obtener los datos de los residuos semisólidos y/o sólidos no peligrosos de la empresa empresa
    public ArrayList<ArrayList<String>> getWasteNPData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina10.P10P1.P10P1SP2.Table61");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
                String rbEffluentsNP = this.formController.getSimpleDataForm("Pagina10.P10P1.P10P1SP1.RBSolidosNoPeligrosos");
                if (rbEffluentsNP.equals("0"))throw new EmptyException("NO");
                //Proceso que lo genera
                formController.SimpleNodeSearcher(n,".Fila2.ResiduoSolidosNoPeligrosos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Volumen valor
                formController.SimpleNodeSearcher(n,".Fila3.TablaCantidad.Row1.ValorSolidosNoPeligrosos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Volumen unidad
                formController.SimpleNodeSearcher(n,".Fila3.TablaCantidad.Row1.UnidadSolidosNoPeligrosos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Volumen tiempo
                formController.SimpleNodeSearcher(n,".Fila3.TablaCantidad.Row1.PeriodoSolidosNoPeligrosos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Proceso que lo genera
                formController.SimpleNodeSearcher(n,".Fila4.ProcesoSolidosNoPeligrosos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Gestion
                formController.SimpleNodeSearcher(n,".Fila5.GestionSolidosNoPeligrosos", value);
                temp.add(value.toString());
                value.setLength(0);
                data.add(temp); 
            } catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
                if(ex.getMessage().equals("NO")) break;
            }
            
        }
        return data;
    }
    //Método para obtener los datos de los residuos semisólidos y/o sólidos peligrosos de la empresa empresa
    public ArrayList<ArrayList<String>> getWastePData(){
        this.nodes.clear();
        this.nodes = this.formController.getComplexDataForm("Pagina10.P10P2.P10P2SP2.Table61");
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        //System.out.println(this.nodes);
        for(Element n: nodes){
            ArrayList <String> temp= new ArrayList<>();
            StringBuilder value = new StringBuilder();
            try{
                String rbEffluentsNP = this.formController.getSimpleDataForm("Pagina10.P10P2.P10P2SP1.RBSolidosPeligrosos");
                if (rbEffluentsNP.equals("0"))throw new EmptyException("NO");
                //Proceso que lo genera
                formController.SimpleNodeSearcher(n,".Fila2.ResiduoSolidosPeligrosos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Volumen valor
                formController.SimpleNodeSearcher(n,".Fila3.TablaCantidad.Row1.ValorSolidosPeligrosos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Volumen unidad
                formController.SimpleNodeSearcher(n,".Fila3.TablaCantidad.Row1.UnidadSolidosPeligrosos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Volumen tiempo
                formController.SimpleNodeSearcher(n,".Fila3.TablaCantidad.Row1.PeriodoSolidosPeligrosos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Proceso que lo genera
                formController.SimpleNodeSearcher(n,".Fila4.ProcesoSolidosPeligrosos", value);
                temp.add(value.toString());
                value.setLength(0);
                //Gestion
                formController.SimpleNodeSearcher(n,".Fila5.GestionSolidosPeligrosos", value);
                temp.add(value.toString());
                value.setLength(0);
                data.add(temp); 
            } catch(EmptyException ex){
                if(!temp.isEmpty()) data.add(temp);
                System.out.println(ex.getMessage());
                if(ex.getMessage().equals("NO")) break;
            }
            
        }
        return data;
    }
    
//End of class
}
