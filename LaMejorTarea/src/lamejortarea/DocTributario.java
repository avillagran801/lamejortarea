package lamejortarea;

import java.util.Calendar;

abstract class DocTributario {
    protected String numero; // A diferencia del UML, las variables numero, rut,
    protected String rut;    // y fecha son protected en vez de private para que
    protected Calendar fecha;// sean heredables
    
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
}