/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lamejortarea;

import java.util.Date;

/**
 *
 * @author anvillagran2021
 */
abstract class DocTributario {
    private String numero;
    private String rut;
    private Date fecha;
    
    public String getNumero(){
        return numero;
    }
    public String getRut(){
        return rut;
    }
    public Date getFecha(){
        return fecha;
    }
}

class Boleta extends DocTributario{
    public Boleta(){
        super();
    }
}

class Factura extends DocTributario{
    public Factura(){
        super();
    }
}