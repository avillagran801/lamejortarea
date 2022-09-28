/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lamejortarea;

/**
 *
 * @author anvillagran2021
 */
class Cliente{
    private String nombre;
    private String rut;
    private Direccion direccion;
    
    public Cliente(){
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getRut(){
        return rut;
    }
    public void setNombre(String nombre_aux){
        nombre = nombre_aux;
    }
    public void setRut(String rut_aux){
        rut = rut_aux;
    }
}

class Direccion{
    private String direccion;
    
    public Direccion(){
    }
    
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion_aux){
        direccion = direccion_aux;
    }
}
