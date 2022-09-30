package lamejortarea;


class Cliente{
    private String nombre;
    private String rut;
    private Direccion direccion;
    
    public Cliente(String nombre_aux, String rut_aux, Direccion direc_aux){
        nombre = nombre_aux;
        rut = rut_aux;
        direccion = direc_aux;
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getRut(){
        return rut;
    }
    public String getDireccion(){
        return direccion.getDireccion();
    }
    public void cambiarNombre(String nombre_aux){
        nombre = nombre_aux;
    }
    public void cambiarRut(String rut_aux){
        rut = rut_aux;
    }
    public void cambiarDireccion(String direccion_aux){ // Usa el método del
        direccion.cambiarDireccion(direccion_aux);   // mismo nombre en la clase Direccion
    }
    
    public String toString(){
        return "Nombre: " + nombre + "\nRut: " + rut +"\n" + direccion.toString();
    }
}

class Direccion{
    private String direccion;
    
    public Direccion(String direc_aux){
        direccion = direc_aux;
    }
    
    public String getDireccion(){
        return direccion;
    }
    public void cambiarDireccion(String direccion_aux){
        direccion = direccion_aux;
    }
    public String toString(){
        return "Direccion: " + direccion;
    }
}
