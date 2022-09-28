package lamejortarea;

import java.util.Date;
import java.util.Calendar; // Se usa calendar para "sumar" meses

abstract class Pago{
    protected float monto; // A diferencia del UML, las variables monto y fecha
    protected Date fecha;  // son protected para poder ser heredables.
}

//Se asume que con transferencia y tarjeta se pagará el monto justo.
//Solo dinero tiene la opción de ingresar el monto al momento de pagar.

class Efectivo extends Pago{
    private OrdenCompra orden;
    public Efectivo(){
        super();
    }
    
    public float calcDevolucion(OrdenCompra costo, int dinero){
        return (float)dinero-costo.calcPrecio();
    }
    
    public void Pago(int dinero, OrdenCompra order, int cuotas){
        orden = order;
        if (cuotas < 0){
            System.out.println ("Intentelo de nuevo");
            return;
        }
        System.out.println("Usted pagará en " + cuotas + " cuota(s)");
        if (cuotas != 1 && cuotas !=0){
            monto = orden.calcPrecio()/(float)cuotas;
            if (monto - dinero > 0){
                System.out.println("Dinero insuficiente.");
                return;
            }
            System.out.println("Primera cuota a pagar: " + monto);
            System.out.println("Se le devolverá: " + calcDevolucion(orden, dinero));
            System.out.println("Próxima cuota a pagar: " + monto + "en " + fecha);
            // ARREGLAR TEMA DE FECHA
        } else {
            System.out.println("Monto a pagar: " + monto);
            System.out.println("Se le devolverá: " + calcDevolucion(orden, dinero));
        }
    }
}

class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    private OrdenCompra orden;
    
    public Transferencia(String bank, String num){
        super();
        banco = bank;
        numCuenta = num;
    }
    public String getBanco(){
        return banco;
    }
    public String getNumCuenta(){
        return numCuenta;
    }
    public void Pago(OrdenCompra order, int cuotas){
        orden = order;
        if (cuotas < 0){
            System.out.println ("Intentelo de nuevo");
            return;
        }
        System.out.println("Usted pagará en " + cuotas + " cuota(s)");
        if (cuotas != 1 && cuotas !=0){
            monto = orden.calcPrecio()/(float)cuotas;
            System.out.println("Primera cuota a pagar: " + monto);
            System.out.println("Próxima cuota a pagar: " + monto + "en " + fecha);
            // ARREGLAR TEMA DE FECHA
        } else {
            System.out.println("Monto a pagar: " + monto);
        }
    }
}

class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    private OrdenCompra orden;
    
    public Tarjeta(String type, String tran){
        super();
        tipo = type;
        numTransaccion = tran;
    }
    public String getTipo(){
        return tipo;
    }
    public String getNumTransaccion(){
        return numTransaccion;
    }
    public void Pago(OrdenCompra order, int cuotas){
        orden = order;
        if (cuotas < 0){
            System.out.println ("Intentelo de nuevo");
            return;
        }
        System.out.println("Usted pagará en " + cuotas + " cuota(s)");
        if (cuotas != 1 && cuotas !=0){
            monto = orden.calcPrecio()/(float)cuotas;
            System.out.println("Primera cuota a pagar: " + monto);
            System.out.println("Próxima cuota a pagar: " + monto + "en " + fecha);
            // ARREGLAR TEMA DE FECHA
        } else {
            System.out.println("Monto a pagar: " + monto);
        }
    }
}