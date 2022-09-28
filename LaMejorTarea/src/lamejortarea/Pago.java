package lamejortarea;

import java.util.Date;

abstract class Pago{
    private float monto;
    private Date fecha;
    
    public Pago(){
    }
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
    
    public Transferencia(){
        super();
    }
    public String getBanco(){
        return banco;
    }
    public String getNumCuenta(){
        return numCuenta;
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