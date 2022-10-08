package lamejortarea;
import java.util.Calendar; // Se usa calendar para "sumar" meses

abstract class Pago{
    protected float monto; // A diferencia del UML, las variables monto y fecha
    protected Calendar fecha;  // son protected para poder ser heredables.
}

class Efectivo extends Pago{
    
    public Efectivo(){
        super();
        fecha = Calendar.getInstance();
        monto = 0;
    }
    
    public void añadirMonto(float money){
        monto = monto + money;
    }
    
    public float calcDevolucion(OrdenCompra costo){
        return (float)monto-costo.getPago();
    }
    
    public void Pago(OrdenCompra order, int cuotas){
        fecha = Calendar.getInstance();
        if (cuotas < 0){
            System.out.println ("Intentelo de nuevo");
            return;
        }
        System.out.println("Usted pagará en " + cuotas + " cuota(s)");
        if (cuotas != 1 && cuotas !=0){
            float monto_aux; //El monto a pagar, en cuotas.
            monto_aux = order.getPago()/(float)cuotas;
            System.out.println("Primera cuota a pagar: " + monto_aux);
            System.out.println("Se le devolverá: $" + (monto - monto_aux));
            fecha.add(Calendar.MONTH, 1);
            System.out.println("Próxima cuota a pagar: $" + monto_aux + " en " + 
                    fecha.getTime()+ "\n");
            fecha.add(Calendar.MONTH, -1);
            order.setPago(monto_aux*(cuotas-1));
            monto = monto - monto_aux;
        } else {
            if (order.getPago() - monto > 0){
                order.setPago(order.getPago()-monto);
                System.out.println("Falta por pagar: $" + order.getPago()+ "\n");
                return;
            }
            System.out.println("Monto a pagar: $" + order.getPago());
            System.out.println("Se le devolverá: $" + calcDevolucion(order) + "\n");
            monto = calcDevolucion(order);
            order.setPago(0f);
        }
    }
    
    public String toString(){
        return "Dinero: $" + monto + "\nFecha: " + fecha.getTime() + "\n";
    }
}

class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    
    public Transferencia(String bank, String account){
        super();
        fecha = Calendar.getInstance();
        banco = bank;
        numCuenta = account;
    }
    
    public String getBanco(){
        return banco;
    }
    
    public String getNumCuenta(){
        return numCuenta;
    }
    
    public void añadirMonto(float money){
        monto = monto + money;
    }
    
    public String toString(){
        return "Banco: " + banco + "\nNúmero de cuenta: " + numCuenta +
                "\nDinero: $" + monto + "\nFecha: " + fecha.getTime() + "\n";
    }
    
    public void Pago(OrdenCompra order, int cuotas){
        if (cuotas < 0){
            System.out.println ("Intentelo de nuevo\n");
            return;
        }
        System.out.println("Usted pagará en " + cuotas + " cuota(s)");
        if (cuotas != 1 && cuotas !=0){
            float monto_aux; //El monto a pagar, en cuotas.
            monto_aux = order.getPago()/(float)cuotas;
            System.out.println("Primera cuota a pagar: $" + monto_aux);
            fecha.add(Calendar.MONTH, 1);
            System.out.println("Próxima cuota a pagar: $" + monto_aux + "en " + 
                    fecha.getTime() + "\n");
            fecha.add(Calendar.MONTH, -1);
            order.setPago(monto_aux*(cuotas-1));
            monto = monto - monto_aux;
        } else {
            if (order.getPago() - monto > 0){
                order.setPago(order.getPago()-monto);
                System.out.println("Falta por pagar: $" + order.getPago() + "\n");
                return;
            }
            System.out.println("Monto a pagar: $" + order.getPago() + "\n");
            monto = monto - order.getPago();
            order.setPago(0f);
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
        fecha = Calendar.getInstance();
    }
    
    public void añadirMonto(float dinero){
        monto = monto + dinero;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public String getNumTransaccion(){
        return numTransaccion;
    }
    
    public void Pago(OrdenCompra order, int cuotas){
        if (cuotas < 0){
            System.out.println ("Intentelo de nuevo\n");
            return;
        }
        System.out.println("Usted pagará en " + cuotas + " cuota(s)");
        if (cuotas != 1 && cuotas !=0){
            float monto_aux; //El monto a pagar, en cuotas.
            monto_aux = order.getPago()/(float)cuotas;
            System.out.println("Primera cuota a pagar: $" + monto_aux);
            fecha.add(Calendar.MONTH, 1);
            System.out.println("Próxima cuota a pagar: $" + monto_aux + "en " + 
                    fecha.getTime() + "\n");
            fecha.add(Calendar.MONTH, -1);
            order.setPago(monto_aux*(cuotas-1));
            monto = monto - monto_aux;
        } else {
            if (order.getPago() - monto > 0){
                order.setPago(order.getPago()-monto);
                System.out.println("Falta por pagar: $" + order.getPago() + "\n");
                return;
            }
            System.out.println("Monto a pagar: $" + order.getPago() + "\n");
            monto = monto - order.getPago();
            order.setPago(0f);
        }
    }
    
    public String toString(){
        return "Tipo: " + tipo + "\nNumero de Transaccion: " + numTransaccion +
                "\nDinero: $" + monto + "\nFecha: " + fecha.getTime() + "\n";
    }
}