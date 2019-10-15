/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equipo;

import logica.EstructuraArchivos;

/**
 *
 * @author root
 */
public class VariablesEntorno {
    private String hostname = "localhost";
    private String ip = "127.0.0.1";
    private boolean servidor = false;
    private EstructuraArchivos fs ;
    //private ShellTerminal shell;    
    private String chroot = "~";
    private String pwd = "~";
    private String usuario = "root";
    private String promptSep = " # ";
    private String prompt;

    public VariablesEntorno(String hostname) {
        this.hostname = hostname;
        this.fs = new EstructuraArchivos(hostname);
    }

    public VariablesEntorno(String hostname, String usuario) {
        this.hostname = hostname;
        this.usuario = usuario;
        this.pwd = "/home/" + usuario;

    }

    public VariablesEntorno() {        
    }

    void setFileSytem(EstructuraArchivos fs) {
        this.setFs(fs);
    }
    
    public String getChroot() {
        return chroot;
    }

    public void setChroot(String chroot) {
        this.chroot = chroot;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPromptSep() {
        return promptSep;
    }

    public void setPromptSep(String promptSep) {
        this.promptSep = promptSep;
    }

    public String getPrompt() {
        this.prompt = this.usuario + "@" + this.hostname + ":" + this.pwd + this.promptSep;
        return this.prompt;

    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public EstructuraArchivos getFs() {
        return fs;
    }

    public void setFs(EstructuraArchivos fs) {
        this.fs = fs;
    }
  
}
