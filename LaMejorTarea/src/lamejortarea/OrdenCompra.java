package lamejortarea;
import java.util.Date;

class OrdenCompra {
    private Date fecha;
    private String estado;
    private DetalleOrden detalle;
    public Cliente cliente;
    
    public OrdenCompra(Cliente cliente_aux){
        DetalleOrden detalle = new DetalleOrden();
        fecha = new Date();
        cliente = cliente_aux;
    }
    
    public int calcPrecioSinIva(){
        return 0;
    }
    public int calcIVA(){
        return 19;
    }
    public int calcPrecio(){
        return 100;
    }
    public int Peso(){
        return 10;
    }
    public Date getFecha(){
        return fecha;
    }
    public String getEstado(){
        return estado;
    }
}

class DetalleOrden {
    private int cantidad;
    
    public int calcPrecio(){
        return 100;
    }
    public int calcPrecioSinIVA(){
        return 40;
    }
    public int calcIVA(){
        return 19;
    }
    public int calcPeso(){
        return 10;
    }
    public int getCantidad(){
        return cantidad;
    }
}

class Articulo {
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    
    public Articulo(){
    }
    public float getPeso(){
        return peso;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public float getPrecio(){
        return precio;
    }
}
