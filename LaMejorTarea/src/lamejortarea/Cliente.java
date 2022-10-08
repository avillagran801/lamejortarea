package lamejortarea;
import java.util.ArrayList;


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
    public void cambiarDireccion(String direccion_aux){ 
        direccion.cambiarDireccion(direccion_aux);  // Usa el método del
                                                    // mismo nombre en la clase 
                                                    // Direccion
    }
    
    public String toString(){
        return "Nombre: " + nombre + "\nRut: " + rut +"\n" 
                + direccion.getDireccion() + "\n";
    }
}

class Direccion{
    private String direccion;
    private ArrayList<Cliente> clientes;
    private ArrayList<DocTributario> docTributarios;
    
    public Direccion(String direc_aux){
        direccion = direc_aux;
        clientes = new ArrayList<Cliente>();
        docTributarios = new ArrayList<DocTributario>();
    }
    
    public String getDireccion(){
        return direccion;
    }
    public void cambiarDireccion(String direccion_aux){
        direccion = direccion_aux;
    }
    public void addClientes(Cliente c_aux){
        clientes.add(c_aux);
    }
    public void addDocTriburarios(DocTributario doc_aux){
        docTributarios.add(doc_aux);
    }
    public String toString(){
        String clientes_aux = "";
        String docTributarios_aux = "";
        
        for(int i=0; i<clientes.size(); ++i){
            clientes_aux = clientes_aux + "\n" + clientes.get(i).getNombre();
        }
        for(int i=0; i<docTributarios.size(); ++i){
            docTributarios_aux = docTributarios_aux + "\n" + 
                    docTributarios.get(i).getNumero();
        }
        
        return "Direccion: " + direccion + "\n\nClientes asociados:" + 
                clientes_aux + "\n\nDocumentos tributarios asociados:" + 
                docTributarios_aux + "\n";
    }
}
