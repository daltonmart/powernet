
package logica;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class EstructuraArchivos {
    
    private ArrayList<Archivo> listaArchivos;
    Archivo archActual;

   
    public EstructuraArchivos( ) {
        this.listaArchivos = new ArrayList<>();
        this.archActual = new Archivo();
    }

    public ArrayList<Archivo> getListaArchivos() {
        return listaArchivos;
    }

    public void setListaArchivos(ArrayList<Archivo> listaArchivos) {
        this.listaArchivos = listaArchivos;
    }

    public Archivo getArchActual() {
        return archActual;
    }

    public void setArchActual(Archivo archActual) {
        this.archActual = archActual;
    }
    
    public Archivo buscarArchivo(String nombre){
       
        Boolean encontro = false;
        int i=0;
        while ( (i<listaArchivos.size()) && (!encontro) ){
            encontro = nombre.equals(listaArchivos.get(i).getNombre());
            i++;
        }
        return listaArchivos.get(i-1);
    }
    
    public Boolean existeArchivoConNombre(String nombre){
        Boolean encontro = false;
        int i=0;
        while ( (i<listaArchivos.size()) && (!encontro) ){
            encontro = nombre.equals(listaArchivos.get(i).getNombre());
            i++;
        }
        return encontro;
    }
    
    public Boolean existeArchivo(Archivo arch){
        return listaArchivos.contains(arch);
    }
    
    public void insertarArchivo(Archivo arch){
        listaArchivos.add(arch);
    }
    
    public void borrarArchivo(Archivo arch){
        listaArchivos.remove(arch);
    }
    
    public void escribirPersistenciaEstructuraArchivos(String nombre, int tipo, String direccion, int permiso, String duenio, String grupo, String contenido){ 
        
        String cadenaDatos= " ";
        String stipo = String.valueOf(tipo);
        String spermiso = String.valueOf(permiso);
        cadenaDatos=nombre+" ; "+stipo+" ; "+direccion+" ; "+spermiso+" ; "+duenio+" ; "+grupo+" ; "+contenido;
        
        //guardamos datos en el archivo
        FileWriter fichero;
        PrintWriter pw;
        try{
            fichero = new FileWriter ("EstructuraArchivos.txt",true);
            pw = new PrintWriter(fichero);
            pw.println(cadenaDatos);
            pw.close();
            fichero.close();
            //mensaje de exito
            JOptionPane.showConfirmDialog(null,"Datos ingresados al archivo EstructuraArchivos",
                    "Información",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null,"No se pudo guardar",
                    "Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    
    public void verPersistenciaEstructuraArchivos(){
        int tipo,permiso;
        File archivo=null;
        FileReader frEA=null;
        BufferedReader brEA=null;
        
        try{
            //apertura del archivo
            archivo = new File ("EstructuraArchivos.txt");
            frEA = new FileReader(archivo);
            brEA= new BufferedReader(frEA);
            String filaLeidaArchivo;
            String [] cadenaSeparada;
            
            while ((filaLeidaArchivo = brEA.readLine())!= null){
                cadenaSeparada = filaLeidaArchivo.split(" ; ");
                tipo=Integer.valueOf(cadenaSeparada[1]);
                permiso=Integer.valueOf(cadenaSeparada[3]);
                Archivo a= new Archivo(cadenaSeparada[0],tipo,cadenaSeparada[2],permiso,cadenaSeparada[4],cadenaSeparada[5], cadenaSeparada[6]);
                System.out.println(a);
                insertarArchivo(a);        
            }
            
            brEA.close();
            frEA.close();
            
        }
        catch (Exception e){
            JOptionPane.showConfirmDialog(null,"El Archivo EstructuraArchivos no existe", "Información",
                    JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void borrarArchivoDePersistenciaEstructuraArchivos(String nombre) throws FileNotFoundException, IOException{
        
        File inputFile = new File("EstructuraArchivos.txt");
        File tempFile = new File("myTempFileEA.txt");

        boolean successful = inputFile.renameTo(tempFile);
        System.out.println(successful);
        
        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));

        String lineToRemove = nombre;
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            String [] trimmedLine = currentLine.trim().split(" ; ");;
            if(trimmedLine[0].equals(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close(); 
        reader.close(); 
        tempFile.delete();
    
    }
    
    public void altaArchivo(String nombre, int tipo, String direccion, int permisos, String duenio, String grupo, String contenido){
        if ( existeArchivoConNombre(nombre)==false ){
            //si no existe lo agrega a usuarios del juego
            Archivo a= new Archivo(nombre, tipo,direccion,permisos,duenio, grupo,contenido);
            insertarArchivo(a);
            escribirPersistenciaEstructuraArchivos(nombre, tipo,direccion,permisos,duenio, grupo,contenido);
        }
        else
            System.out.println("Ya existe ese archivo con ese nombre");
    }
    
    public void bajaArchivo(String nombre) throws IOException{
        if ( !existeArchivoConNombre(nombre) )
            System.out.println("Ese Archivo no existe");
        else{
            borrarArchivoDePersistenciaEstructuraArchivos(nombre);
        }
    }
    
}
