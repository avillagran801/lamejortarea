package lamejortarea;

import java.util.Calendar;

abstract class DocTributario {
    protected String numero; // A diferencia del UML, las variables numero, rut,
    protected String rut;    // y fecha son protected en vez de private para que
    protected Calendar fecha;// sean heredables
    
    protected String direccion; // Le agregamos dirección para que haya una
                                   // relación, como lo pide UML
    
    public String getNumero(){
        return numero;
    }
    public String getRut(){
        return rut;
    }
    public Calendar getFecha(){
        return fecha;
    }
}

class Boleta extends DocTributario{
    
    public Boleta(){
        super();
    }
    
    public void AsociarBoleta(OrdenCompra order_aux){
        rut = order_aux.getCliente().getRut();
        fecha = order_aux.getFecha();
        direccion = order_aux.getCliente().getDireccion();
    }
    
    public String toString(){
        return "DETALLES BOLETA\nRut: " + rut + "\nDireccion: " + direccion +
                "\nFecha: " + fecha.getTime();
    }
}

class Factura extends DocTributario{
    public Factura(){
        super();
    }
    
    public void AsociarFactura(OrdenCompra order_aux){
        rut = order_aux.getCliente().getRut();
        fecha = order_aux.getFecha();
    }
    
    public String toString(){
        return "DETALLES FACTURA\nRut: " + rut + "\nDireccion: " + direccion +
                "\nFecha: " + fecha.getTime();
    }
}