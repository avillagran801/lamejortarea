package lamejortarea;

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
        
    }
}

class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    
    public Transferencia(){
        super();
    }
}

class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    
    public Tarjeta(){
        super();
    }
}