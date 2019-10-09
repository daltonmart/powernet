
package logica;

public class Archivo {
    private String nombre;
    private int tipo;
    private String direccion;
    private int permiso;
    private String duenio;
    private String grupo;
    private String contenido;

    public Archivo(){
        
    }
    
    public Archivo(String nombre, int tipo, String direccion, int permiso, String duenio, String grupo, String contenido) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.direccion = direccion;
        this.permiso = permiso;
        this.duenio = duenio;
        this.grupo = grupo;
        this.contenido = contenido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPermiso() {
        return permiso;
    }

    public void setPermiso(int permiso) {
        this.permiso = permiso;
    }

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Archivo{" + "nombre=" + nombre + ", tipo=" + tipo + ", direccion=" + direccion + ", permiso=" + permiso + ", duenio=" + duenio + ", grupo=" + grupo + ", contenido=" + contenido + '}';
    }
        
    
}
