
package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class UsuarioJuego {
    private String nickname;
    private String email;
    private String contrasenia;

    public UsuarioJuego(){
        
    }

    public UsuarioJuego(String nickname, String email, String contrasenia) {
        this.nickname = nickname;
        this.email = email;
        this.contrasenia = contrasenia;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    
}
