/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lamejortarea;
import java.util.*;

/**
 *
 * @author joscortes2021
 */
public class LaMejorTarea {

    public static void main(String[] args) {
        // CLIENTES
        
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Juanito");
        cliente1.setRut("12345-k");
        
        Cliente cliente2 = new Cliente();
        cliente2.setNombre("María del Carmen");
        cliente2.setRut("284626-4");
        
        // PRODUCTOS
        
        Articulo art1 = new Articulo(1, "Pan", "Hallulla delgada", 2100);
        Articulo art2 = new Articulo(0.25f, "Jamón", "Jamón Receta del Abuelo", 2600);
        Articulo art3 = new Articulo(1, "Plátano", "Plátano granel importado", 1350);
        Articulo art4 = new Articulo(0.5f, "Queso", "Queso mantequeso laminado", 4990);
        Articulo art5 = new Articulo(2.5f, "Torta", "Torta de frutos rojos", 13990);
        
        OrdenCompra orden = new OrdenCompra();
        System.out.println(orden.getFecha());
        orden.agregarOrden(art1, 3);
        
    }
    
}
