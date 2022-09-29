package lamejortarea;
import java.util.Date;
import java.util.ArrayList;

class OrdenCompra {
    private Date fecha;
    private String estado;
    private ArrayList<DetalleOrden> detalle;
    private Cliente cliente;
    private DocTributario docTributario;
    
    public OrdenCompra(){
        detalle = new ArrayList<DetalleOrden>(); // Crea el arreglo de detalles
        fecha = new Date();
    }
    
    public void agregarOrden(Articulo articulo, int numItem){ // Creamos la orden de un nuevo ítem
        DetalleOrden orden_aux = new DetalleOrden(articulo, numItem);
        detalle.add(orden_aux);
    }
    public void asignarCliente(Cliente cliente_aux){
        cliente = cliente_aux;
    }
    
    public float calcPrecioSinIVA(){
        float totalSinIVA = 0;
        for(int i=0; i<detalle.size(); i++){
            totalSinIVA = totalSinIVA + detalle.get(i).calcPrecioSinIVA();
        }
        return totalSinIVA;
    }
    public float calcIVA(){
        float totalIva = 0;
        for(int i=0; i<detalle.size(); i++){
            totalIva = totalIva + detalle.get(i).calcIVA();
        }
        return totalIva;
    }
    public float calcPrecio(){
        float totalPrecio = 0;
        for(int i=0; i<detalle.size(); i++){
            totalPrecio = totalPrecio + detalle.get(i).calcPrecio();
        }
        return totalPrecio;
    }
    public float calcPeso(){
        float totalPeso = 0;
        for(int i=0; i<detalle.size(); i++){
            totalPeso= totalPeso + detalle.get(i).calcPeso();
        }
        return totalPeso;
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
    public void cambiarPeso(float peso_aux){
        peso = peso_aux;
    }
    public String getNombre(){
        return nombre;
    }
    public void cambiarNombre(String nombre_aux){
        nombre = nombre_aux;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void cambiarDescripcion(String desc_aux){
        descripcion = desc_aux;
    }
    public float getPrecio(){
        return precio;
    }
    public void cambiarPrecio(float precio_aux){
        precio = precio_aux;
    }
}
