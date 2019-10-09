
package logica;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static presentacion.Principal.historia;

public class ControladorSesion {
    private UsuariosDelJuego usuariosDeJuego;
    private UsuarioJuego uEnSesion;
    private int nroCampania;
    private int progreso;


    public ControladorSesion() {
        if (usuariosDeJuego == null)
            this.usuariosDeJuego = new UsuariosDelJuego();
        progreso=0;
        nroCampania=1;
    }
    
    
    public UsuariosDelJuego getUsuariosDeJuego() {
        return usuariosDeJuego;
    }

    public void setUsuariosDeJuego(UsuariosDelJuego usuariosDeJuego) {
        this.usuariosDeJuego = usuariosDeJuego;
    }

    public UsuarioJuego getuEnSesion() {
        return uEnSesion;
    }

    public void setuEnSesion(UsuarioJuego uEnSesion) {
        this.uEnSesion = uEnSesion;
    }

    

    public int getNroCampania() {
        return nroCampania;
    }

    public void setNroCampania(int nroCampania) {
        this.nroCampania = nroCampania;
    }

    
    
    public int getProgreso() {
        return progreso;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }

    
    
    
    public void login(String nickname, String contrasenia){
        UsuarioJuego u;
        if (!usuariosDeJuego.existeNickname(nickname))
            JOptionPane.showConfirmDialog(null,"NO existe un usuario con ese nickname, vuelva a ingresar",
                    "Login",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        else{
                u=usuariosDeJuego.buscarUsuario(nickname);
                if (contrasenia.equals(u.getContrasenia())){
                    //coloca Usuario en uEnSesion
                    uEnSesion=u;
                    
                }
                else
                    JOptionPane.showConfirmDialog(null,"Contrasenia incorrecta",
                    "Login",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void logout(){
        uEnSesion=null;
    }
    
    public boolean jugadorGano(){
        return ( (nroCampania == historia.obtenerCantCampanias()) && (progreso == historia.obtenerCantidadMisionesDeCampania(historia.obtenerCantCampanias())) );
    }
    
    public boolean jugadorAlFinalDeCampania(int nroCampaniasDeHistoria){
        return ( progreso == historia.obtenerCantidadMisionesDeCampania(nroCampaniasDeHistoria) );
    }
}
