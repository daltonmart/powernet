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
import terminal.ProcesadorDeComandos;
import terminal.Terminal;
import terminal.XTermParaPruebas;

public class EquipoPC {

    private String hostname = "localhost";
    private String ip = "127.0.0.1";
    private boolean servidor = false;
    private EstructuraArchivos fs = new EstructuraArchivos(); // faltaria indicar el nombre del PC a fin de cargar FS diferentes x PC
    private VariablesEntorno environment = new VariablesEntorno();

    public EquipoPC() {
        environment.setFileSytem(fs);
    }

    public EquipoPC(String hostname) {
        this();
        this.hostname = hostname;        
    }
 
    public XTermParaPruebas connect() {
        XTermParaPruebas terminal = new XTermParaPruebas();
        terminal.setVariablesEntorno(environment);
        return terminal; //new Terminal();
    }

    void ejecutarComando(String lineaComando) {
        ProcesadorDeComandos cmd = new ProcesadorDeComandos(lineaComando, environment);
        cmd.ejecutar();
        environment = cmd.getVariablesEntorno();
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

  public String boot() {
        System.out.println("Booting pc " + getHostname() + " ...");
        String estado = "";
        try {
            Properties p = new Properties();
            InputStream propertiesStream = ClassLoader.getSystemResourceAsStream(getHostname() + ".properties");
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

    /**
     * @return the environment
     */
    public VariablesEntorno getEnvironment() {
        return environment;
    }

    /**
     * @param environment the environment to set
     */
    public void setEnvironment(VariablesEntorno environment) {
        this.environment = environment;
    }

}
