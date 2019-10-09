

package logica;

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


public class UsuariosDelJuego {
    
    private ArrayList<UsuarioJuego> listaUsuarios;

   
    public UsuariosDelJuego( ) {
        
        this.listaUsuarios = new ArrayList<>();
    
    }
    
    
    public UsuarioJuego buscarUsuario(String nickname){
       
        Boolean encontro = false;
        int i=0;
        while ( (i<listaUsuarios.size()) && (!encontro)){
            encontro = nickname.equals(listaUsuarios.get(i).getNickname());
            i++;
        }
        return listaUsuarios.get(i-1);
    }
    
    public Boolean existeNickname(String nickname){
        Boolean encontro = false;
        int i=0;
        while ( (i<listaUsuarios.size()) && (!encontro) ){
            encontro = nickname.equals(listaUsuarios.get(i).getNickname());
            i++;
        }
        return encontro;
    }
    
    public Boolean existeUsuario(UsuarioJuego u){
        return listaUsuarios.contains(u);
    }
    
    public void insertarUsuario(UsuarioJuego u){
        listaUsuarios.add(u);
    }
    
    public void borrarUsuario(UsuarioJuego u){
        listaUsuarios.remove(u);
    }
    
    public void escribirPersistenciaUsuarioJuego(String nickname, String email, String contrasenia){
        String cadenaDatos= " ";
        cadenaDatos=nickname+" ; "+email+" ; "+contrasenia;
        
        //guardamos datos en el archivo
        FileWriter fichero;
        PrintWriter pw;
        try{
            fichero = new FileWriter ("UsuariosDelJuego.txt",true);
            pw = new PrintWriter(fichero);
            pw.println(cadenaDatos);
            pw.close();
            fichero.close();
            //mensaje de exito
            JOptionPane.showConfirmDialog(null,"Datos ingresados al archivo correspondiente",
                    "Información",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null,"No se pudo guardar",
                    "Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    public void verPersistenciaUsuarioJuego(){
        
        //Lectura de los datos del archivo
        File archivo=null;
        FileReader fr=null;
        BufferedReader br=null;
        
        try{
            //apertura del archivo
            archivo = new File ("UsuariosDelJuego.txt");
            fr = new FileReader(archivo);
            br= new BufferedReader(fr);
            String filaLeidaArchivo;
            String [] cadenaSeparada;
            
            while ((filaLeidaArchivo = br.readLine())!= null){
                cadenaSeparada = filaLeidaArchivo.split(" ; ");
                UsuarioJuego u=new UsuarioJuego(cadenaSeparada[0],cadenaSeparada[1],cadenaSeparada[2]);
                insertarUsuario(u);
            }
            
            br.close();
            fr.close();
            
        }
        catch (Exception e){
            JOptionPane.showConfirmDialog(null,"El Archivo no existe", "Información",
                    JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void borrarUsuarioDePersistenciaUsuarioJuego(String nickname) throws FileNotFoundException, IOException{
        File inputFile = new File("UsuariosDelJuego.txt");
        File tempFile = new File("myTempFile.txt");

        boolean successful = inputFile.renameTo(tempFile);
        
        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));

        String lineToRemove = nickname;
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
    
}
