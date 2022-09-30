package lamejortarea;

// Pepancho: Falta implementar método tal que el monto a pagar en OrdenCompra
// es afectado por cada Pago que se haga

//Se asume que con transferencia y tarjeta se pagará el monto justo.
//Solo dinero tiene la opción de agregar dinero.

import java.util.Calendar; // Se usa calendar para "sumar" meses

abstract class Pago{
    protected float monto; // A diferencia del UML, las variables monto y fecha
    protected Calendar fecha;  // son protected para poder ser heredables.
}

class Efectivo extends Pago{
    private int dinero;
    
    public Efectivo(){
        super();
        dinero = 0;
    }
    
    public void añadirDinero(int money){
        dinero = dinero + money;
    }
    
    public float calcDevolucion(OrdenCompra costo){
        return (float)dinero-costo.calcPrecio();
    }
    
    public void Pago(OrdenCompra order, int cuotas){
        fecha = Calendar.getInstance();
        if (cuotas < 0){
            System.out.println ("Intentelo de nuevo");
            return;
        }
        System.out.println("Usted pagará en " + cuotas + " cuota(s)");
        if (cuotas != 1 && cuotas !=0){
            monto = order.calcPrecio()/(float)cuotas;
            if (monto - dinero > 0){
                System.out.println("Dinero insuficiente.");
                return;
            }
            System.out.println("Primera cuota a pagar: " + monto);
            System.out.println("Se le devolverá: " + calcDevolucion(order));
            fecha.add(Calendar.MONTH, 1);
            System.out.println("Próxima cuota a pagar: " + monto + "en " + 
                    fecha.getTime());
            fecha.add(Calendar.MONTH, -1);
        } else {
            if (monto - dinero > 0){
                System.out.println("Dinero insuficiente.");
                return;
            }
            System.out.println("Monto a pagar: " + monto);
            System.out.println("Se le devolverá: " + calcDevolucion(order));
        }
    }
    
    public String toString(){
        return "Dinero: " + dinero;
    }
}

class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    
    public Transferencia(String bank, String account){
        super();
        banco = bank;
        numCuenta = account;
    }
    public String getBanco(){
        return banco;
    }
    public String getNumCuenta(){
        return numCuenta;
    }
    
    public String toString(){
        return "Banco: " + banco + "\nNúmero de cuenta: " + numCuenta;
    }
    
    public void Pago(OrdenCompra order, int cuotas){
        if (cuotas < 0){
            System.out.println ("Intentelo de nuevo");
            return;
        }
        System.out.println("Usted pagará en " + cuotas + " cuota(s)");
        if (cuotas != 1 && cuotas !=0){
            monto = order.calcPrecio()/(float)cuotas;
            System.out.println("Primera cuota a pagar: " + monto);
            fecha.add(Calendar.MONTH, 1);
            System.out.println("Próxima cuota a pagar: " + monto + "en " + 
                    fecha.getTime());
            fecha.add(Calendar.MONTH, -1);
        } else {
            System.out.println("Monto a pagar: " + monto);
        }
    }
}

class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    
    public Tarjeta(String type, String number){
        super();
        tipo = type;
        numTransaccion = number;
    }
    public String getTipo(){
        return tipo;
    }
    public String getNumTransaccion(){
        return numTransaccion;
    }
    public void Pago(OrdenCompra order, int cuotas){
        if (cuotas < 0){
            System.out.println ("Intentelo de nuevo");
            return;
        }
        System.out.println("Usted pagará en " + cuotas + " cuota(s)");
        if (cuotas != 1 && cuotas !=0){
            monto = order.calcPrecio()/(float)cuotas;
            System.out.println("Primera cuota a pagar: " + monto);
            fecha.add(Calendar.MONTH, 1);
            System.out.println("Próxima cuota a pagar: " + monto + "en " + 
                    fecha.getTime());
            fecha.add(Calendar.MONTH, -1);
        } else {
            System.out.println("Monto a pagar: " + monto);
        }
    }
    
    public String toString(){
        return "Tipo: " + tipo + "\nNumero de Transaccion: " + numTransaccion;
    }
}