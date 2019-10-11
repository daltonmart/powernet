/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equipo;

import static Equipo.ControladorRed.agregarEquipo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.EstructuraArchivos;
import terminal.Terminal;

public class EquipoPC {

    private String hostname = "localhost";
    private String ip = "127.0.0.1";
    private boolean servidor = false;
    private EstructuraArchivos fs = new EstructuraArchivos(); // faltaria indicar el nombre del PC a fin de cargar FS diferentes x PC
    // private ShellTerminal shell;

    public EquipoPC() {
    }

    public EquipoPC(String hostname) {
        this.hostname = hostname;
    }

    public String boot() {
        System.out.println("Booting pc " + getHostname() + " ...");
        String estado = "";
        try {
            Properties p = new Properties();
            InputStream propertiesStream = ClassLoader.getSystemResourceAsStream(getHostname()+".properties");
            p.load(propertiesStream);
            //propertiesStream.close();
            //p.load(new FileReader(""+hostname+".properties"));   //propiedades en archivo en disco
            //p.store(propertiesStream,"un comentario");
            propertiesStream.close();
            this.setHostname(p.getProperty("hostname"));
            this.setIp(p.getProperty("ip"));
            this.setServidor(p.getProperty("servicios").equalsIgnoreCase("true"));
            ControladorRed.agregarEquipo(this);
            
            estado = getHostname() + ": Boot completo";
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EquipoPC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EquipoPC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return estado;
    }

    public Terminal connect() {
        Terminal terminal = new Terminal();
        return terminal; //new Terminal();
    }

    private void setHostname(String hostname) {
        this.hostname = hostname;
    }
    public String getHostname() {
        return this.hostname;        
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean isServidor() {
        return servidor;
    }

    public void setServidor(boolean servidor) {
        this.servidor = servidor;
    }

}
