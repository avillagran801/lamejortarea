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
        Cliente cliente = new Cliente();
        cliente.setNombre("Juanito");
        cliente.setRut("12345-k");
        
        OrdenCompra orden = new OrdenCompra(cliente);
        System.out.println(orden.getFecha());
        System.out.println(orden.cliente.getNombre());
    }
    
}
