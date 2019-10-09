/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equipo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import terminal.Terminal;

public class EquipoPC extends SistemaArchivos {

    private String hostname = "localhost";
    private String ip = "127.0.0.1";
    private boolean servicios = false;
    private SistemaArchivos fs;
   // private ShellTerminal shell;

    public EquipoPC() {
    }

    public EquipoPC(String hostname) {
        this.hostname = hostname;
    }

    public String boot() {
        System.out.println("Booting pc " + hostname + " ...");
        String estado = "";
        try {
            Properties p = new Properties();
         
            InputStream propertiesStream = ClassLoader.getSystemResourceAsStream(hostname+".properties");
            p.load(propertiesStream);
            //propertiesStream.close();
            //p.load(new FileReader(""+hostname+".properties"));   //propiedades en archivo en disco
            //p.store(propertiesStream,"un comentario");
            propertiesStream.close();
            this.setHostname(p.getProperty("hostname"));
            estado = hostname + ": Boot completo";
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EquipoPC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EquipoPC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return estado;
    }

    public Terminal connect() {
        Terminal terminal = new Terminal();
        
        return new Terminal();
    }

    private void setHostname(String hostname) {
        this.hostname = hostname;
    }
    public String getHostname() {
        return this.hostname;        
    }

}
