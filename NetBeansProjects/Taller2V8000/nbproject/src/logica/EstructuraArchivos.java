package logica;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import persistencia.PEstructuraArchivo;
import persistencia.interfaces.IPEstructuraArchivo;

public class EstructuraArchivos {

    private ArrayList<DataArchivo> listaArchivos;
    DataArchivo archActual;//siempre tiene que ser tipo 1

    public EstructuraArchivos() {
        this.listaArchivos = new ArrayList<>();
        this.archActual = new DataArchivo();
    }

    //
    public ArrayList<DataArchivo> getListaArchivos() {
        return listaArchivos;
    }

    //
    public void setListaArchivos(ArrayList<DataArchivo> listaArchivos) {
        this.listaArchivos = listaArchivos;
    }

    //
    public DataArchivo getArchActual() {
        return archActual;
    }

    public void setArchActual(DataArchivo archActual) {
        this.archActual = archActual;
    }

    public DataArchivo buscarArchivo(String nombre) {

        boolean encontro = false;
        int i = 0;
        while ((i < listaArchivos.size()) && (!encontro)) {
            encontro = nombre.equals(listaArchivos.get(i).getNombre());
            i++;
        }
        if (encontro) {
            return listaArchivos.get(i - 1);
        } else {
            return null;
        }
    }

    //
    public String buscarUrl(String urlComando) {
        String[] url = urlComando.split("/");

        String nombre = url[url.length - 1];
        return this.buscarArchivo(nombre).getDireccion();
    }

    //
    public boolean existeUrl(String urlComando) {
        String[] url = urlComando.split("/");
        String nombre = url[url.length - 1];
        return existeArchivoConNombre(nombre);
    }

    public boolean existeArchivoConNombre(String nombre) {
        boolean encontro = false;
        int i = 0;
        while ((i < listaArchivos.size()) && (!encontro)) {
            encontro = nombre.equals(listaArchivos.get(i).getNombre());
            i++;
        }
        return encontro;
    }

    //
    public boolean existeArchivo(DataArchivo arch) {
        return listaArchivos.contains(arch);
    }

    public void insertarArchivo(DataArchivo arch) {
        listaArchivos.add(arch);
    }

    public void borrarArchivo(DataArchivo arch) {
        listaArchivos.remove(arch);
    }

    public void altaArchivo(String nombre, int tipo, String direccion, int permisos, String duenio, String grupo, int tamanio, String fechayhora, String contenido) {
        if (existeArchivoConNombre(nombre) == false) {
            //si no existe lo agrega a usuarios del juego
            DataArchivo a = new DataArchivo(nombre, tipo, direccion, permisos, duenio, grupo, tamanio, fechayhora, contenido);
            insertarArchivo(a);
            //escribirPersistenciaEstructuraArchivos(nombre, tipo,direccion,permisos,duenio, grupo,contenido);

        } else {
            System.out.println("Ya existe ese archivo con ese nombre");
        }
    }

    public void bajaArchivo(String nombre) throws IOException {
        if (!existeArchivoConNombre(nombre)) {
            System.out.println("Ese Archivo no existe");
        } else {
            borrarArchivo(buscarArchivo(nombre));
            //borrarArchivoDePersistenciaEstructuraArchivos(nombre);
        }
    }

    public void cargarPersistenciaEstructuraArchivos(String nombreArchivo) {
        IPEstructuraArchivo pEstructuraArchivos = new PEstructuraArchivo();
        pEstructuraArchivos.verPersistenciaEstructuraArchivos(this, nombreArchivo);
    }

    @Override
    public String toString() {
        return "EstructuraArchivos{" + "listaArchivos=" + listaArchivos + ", archActual=" + archActual + '}';
    }

    // Sandra
    public String getDirectorioActual() {
        return archActual.getDireccion() + archActual.getNombre();
    }

    // Sandra
    public ArrayList<DataArchivo> getArchivos(String url) {
        ArrayList<DataArchivo> ArchivosUrl = new ArrayList<DataArchivo>();

        if (url.lastIndexOf("/") != url.length() - 1) {
            url = url + "/";
        }
        for (DataArchivo arch : listaArchivos) {
            if (url.equals(arch.getDireccion())) {
                ArchivosUrl.add(arch);
            }
        }
        return ArchivosUrl;
    }

    public ArrayList<DataArchivo> getArchivos() {
        return listaArchivos;
    }

    public DataArchivo getArchivoDeUrl(String posibleUrl) {
        for (DataArchivo arch : listaArchivos) {
            if (posibleUrl.equals(arch.getDireccion() + arch.getNombre())) {
                return arch;
            }
        }
        return null;
    }

    public String getUrlAbsoluta(String urlEntrada) {
        String url = urlEntrada;
        if (url.length() == 0) {
            url = this.getDirectorioActual();
        }
        if (url.equals("..")) {
            String[] dirAnterior = this.getDirectorioActual().split("/");
            String directorioAnterior = "";
            if (dirAnterior.length > 0) {
                dirAnterior = Arrays.copyOf(dirAnterior, dirAnterior.length - 1);
                directorioAnterior = String.join("/", dirAnterior);
            }
            if (directorioAnterior.equals("")) {
                directorioAnterior = "/";
            }
            url = directorioAnterior;
        }
        if (!url.startsWith("/")) {
            if(this.getDirectorioActual().equals("/")) 
                url = "/" + urlEntrada;    
            else
                url = this.getDirectorioActual() + "/" + urlEntrada;
        }
        return url;
    }
}
