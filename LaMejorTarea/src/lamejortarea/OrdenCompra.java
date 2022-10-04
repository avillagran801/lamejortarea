package lamejortarea;
import java.util.Calendar;
import java.util.ArrayList;

class OrdenCompra {
    private Calendar fecha;
    private String estado;
    private ArrayList<DetalleOrden> detalle;
    private Cliente cliente;
    private float pago; // Para jugar con el pago. Cuánto falta para pagar la
                        // orden completa.
    
    public OrdenCompra(){
        detalle = new ArrayList<DetalleOrden>(); // Crea el arreglo de detalles
        fecha = Calendar.getInstance();
        estado = "En proceso de pago.";
        pago = 0f;
    }
    
    public void agregarPedido(DetalleOrden detail){ // Creamos la orden de un nuevo ítem
        detalle.add(detail);
        pago = calcPrecio();
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
    
    public Calendar getFecha(){
        return fecha;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public float getPago(){
        return pago;
    }
    
    public void setEstado(String status){
        estado = status;
    }
    
    public void setPago(float dinero){
        pago = pago - dinero;
        if(pago == 0){
            setEstado("Completado!");
        }
    }
    
    public String toString(){
        String result;
        result = "DETALLES DE ORDEN\nFecha: " + fecha.getTime() + "\nEstado: "
                + estado + "\n\nCLIENTE\n" + cliente.toString() + "\n";
        for (int i = 0; i < detalle.size(); i++){
            result = result + "\nDetalle " + (i+1) + ":\n" + 
                    detalle.get(i).toString() + "\n";
        }
        result = result + "\nTotal a pagar: " + calcPrecio() +"\n";
        return result;
    }
}

class DetalleOrden {
    private int cantidad;
    private Articulo articulo;
    private OrdenCompra orden;
    
    public DetalleOrden(OrdenCompra order){
        orden = order;
    }
    
    public void Pedido(Articulo art_aux, int cant_aux){
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
    public Articulo getArticulo(){
        return articulo;
    }
    
    public String toString(){
        return "Articulo: " + articulo.toString() + "\nCantidad: " + cantidad;
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
    public String toString(){
        return "Nombre: " + nombre + "\nDescripcion: " + descripcion +
                "\nPeso (en kg): " + peso + "\nPrecio: " + precio;
    }
}
