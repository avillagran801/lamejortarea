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
    
    public Cliente(String nombre_aux, String rut_aux, Direccion direc_aux){
        nombre = nombre_aux;
        rut = rut_aux;
        direccion = direc_aux;
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getRut(){
        return rut;
    }
    public Direccion getDireccion(){
        return direccion;
    }
    public void cambiarNombre(String nombre_aux){
        nombre = nombre_aux;
    }
    public void cambiarRut(String rut_aux){
        rut = rut_aux;
    }
    public void cambiarDireccion(String direccion_aux){ // Usa el método del mismo nombre en la clase Direccion
        direccion.cambiarDireccion(direccion_aux);
    }
}

class Direccion{
    private String direccion;
    
    public Direccion(String direc_aux){
        direccion = direc_aux;
    }
    
    public String getDireccion(){
        return direccion;
    }
    public void cambiarDireccion(String direccion_aux){
        direccion = direccion_aux;
    }
}
