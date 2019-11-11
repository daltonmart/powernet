
package persistencia.interfaces;

import logica.EstructuraArchivos;

public interface IPEstructuraArchivo {
    public void escribirPersistenciaEstructuraArchivos( String nombreArchivo,String nombre, int tipo, String direccion, int permiso, String duenio, String grupo, int tamanio, String fechayhora, String contenido) ;
    public void verPersistenciaEstructuraArchivos(EstructuraArchivos listaArchivos, String nombreArchivo);
    public void borrarArchivoDePersistenciaEstructuraArchivos( String nombre);
}
