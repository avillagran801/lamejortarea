package lamejortarea;
import java.util.Calendar; //Se usa Calendar para "sumar" meses

public class LaMejorTarea {

    public static void main(String[] args) {
        // DIRECCIONES
        
        Direccion direccion1 = new Direccion("La batalla de los duendes, #11");
        Direccion direccion2 = new Direccion("Felipe Camiroaga, #420");
        
        // CLIENTES
        
        Cliente cliente1 = new Cliente("Juanito", "12345-k", direccion1);        
        Cliente cliente2 = new Cliente("María del Carmen", "284626-4", direccion2);
        
        // PRODUCTOS
        
        Articulo art1 = new Articulo(1, "Pan", "Hallulla delgada", 2100);
        Articulo art2 = new Articulo(0.25f, "Jamón", "Jamón Receta del Abuelo", 2600);
        Articulo art3 = new Articulo(1, "Plátano", "Plátano granel importado", 1350);
        Articulo art4 = new Articulo(0.5f, "Queso", "Queso mantequeso laminado", 4990);
        Articulo art5 = new Articulo(2.5f, "Torta", "Torta de frutos rojos", 13990);
        
        // CREACIÓN ORDEN DE COMPRA, DETALLE, ASIGNAR CLIENTE Y AGREGAR ÓRDENES
        
        OrdenCompra orden = new OrdenCompra();
        orden.asignarCliente(cliente2);
        
        DetalleOrden detalle1 = new DetalleOrden(orden);
        DetalleOrden detalle2 = new DetalleOrden(orden);
        
        detalle1.Pedido(art1, 3);
        detalle2.Pedido(art2, 5);
        orden.agregarPedido(detalle1);
        orden.agregarPedido(detalle2);
        
        // IMPRIMIR INFORMACIÓN RELACIONADA A LA COMPRA
        
        System.out.println("Sin IVA: $" + orden.calcPrecioSinIVA());
        System.out.println("IVA: $" + orden.calcIVA());
        System.out.println("Total: $" + orden.calcPrecio());
        System.out.println("Peso: " + orden.calcPeso() + " kilos");
        System.out.println(orden.toString());
        
        Boleta boleta1 = new Boleta("749365");
        Factura factura2 = new Factura("6495663");
        
        direccion1.addClientes(cliente2);
        direccion1.addClientes(cliente1);
        direccion1.addDocTriburarios(boleta1);
        System.out.println(direccion1.toString());
     
        Efectivo dinero1 = new Efectivo();
        System.out.println(dinero1.toString());
        dinero1.añadirMonto(50000);
        dinero1.Pago(orden, 5);
        System.out.println(dinero1.toString());
        
        System.out.println(orden.toString());
    }
    
}