package lamejortarea;
import java.util.Date;
import java.util.ArrayList;

class OrdenCompra {
    private Date fecha;
    private String estado;
    private ArrayList<DetalleOrden> detalle;
    public Cliente cliente;
    
    public OrdenCompra(){
        detalle = new ArrayList<DetalleOrden>(); // Crea el arreglo de detalles
        fecha = new Date();
    }
    
    public void agregarOrden(Articulo articulo, int numItem){ // Creamos la orden de un nuevo ítem
        DetalleOrden orden_aux = new DetalleOrden(articulo, numItem);
        detalle.add(orden_aux);
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
    private Articulo articulo;
    
    public DetalleOrden(Articulo art_aux, int cant_aux){
        articulo = art_aux;
        cantidad = cant_aux;
    }
    
    public float calcPrecio(){
        return cantidad * articulo.getPrecio();
    }
    public float calcPrecioSinIVA(){
        return cantidad * articulo.getPrecio() * 0.81f;
    }
    public float calcIVA(){
        return cantidad * articulo.getPrecio() * 0.19f;
    }
    public float calcPeso(){
        return cantidad * articulo.getPeso();
    }
    public int getCantidad(){
        return cantidad;
    }
}

class Articulo {
    private float peso; // En kilos
    private String nombre;
    private String descripcion;
    private float precio;
    
    public Articulo(float peso_aux, String nombre_aux, String desc_aux, float precio_aux){
        peso = (float)peso_aux;
        nombre = nombre_aux;
        descripcion = desc_aux;
        precio = (float)precio_aux;
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
