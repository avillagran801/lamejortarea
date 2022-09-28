package lamejortarea;

import java.util.Date;

abstract class Pago{
    protected float monto; // A diferencia del UML, las variables monto y fecha
    protected Date fecha;  // son protected para poder ser heredables.
}

class Efectivo extends Pago{
    public Efectivo(){
        super();
    }
    
    public float calcDevolucion(){
        return 0; // Pa' que no webeee con errores
    }
}

class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    private OrdenCompra Orden;
    
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
    public void Pago(int cuotas){
        if (cuotas < 0){
            System.out.println ("Intentelo de nuevo");
            return;
        }
        monto = Orden.calcPrecio()/(float)cuotas;
        System.out.println("Usted pagará en " + cuotas + " cuota(s)");
        if (cuotas != 1 && cuotas !=0){
            System.out.println("Primera cuota a pagar: " + monto);
            System.out.println();
        }
        
    }
}

class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    
    public Tarjeta(){
        super();
    }
    public String getTipo(){
        return tipo;
    }
    public String getNumTransaccion(){
        return numTransaccion;
    }
}