
package logica;

import java.io.IOException;
import javax.swing.JOptionPane;

public class ControladorUsuario {
    
    private UsuariosDelJuego usuariosDelJuego;
    private Campania usaCapania;
    
    public ControladorUsuario(){
        if (usuariosDelJuego == null)
            this.usuariosDelJuego = new UsuariosDelJuego();
        if (usaCapania == null)
            this.usaCapania= new Campania();
    }

    
    public ControladorUsuario(UsuariosDelJuego usuariosDelJuego, Campania usaCapania) {
        this.usuariosDelJuego = usuariosDelJuego;
        this.usaCapania = usaCapania;
    }
    
    

    public UsuariosDelJuego getUsaUsuariosDelJuego() {
        return usuariosDelJuego;
    }

    public void setUsaUsuariosDelJuego(UsuariosDelJuego usaUsuariosDelJuego) {
        this.usuariosDelJuego = usaUsuariosDelJuego;
    }

    public Campania getUsaCapania() {
        return usaCapania;
    }

    public void setUsaCapania(Campania usaCapania) {
        this.usaCapania = usaCapania;
    }

    public void altaUsuario(String nickname, String email, String contrasenia){
        if ( usuariosDelJuego.existeNickname(nickname)==false ){
            //si no existe lo agrega a usuarios del juego
            UsuarioJuego u= new UsuarioJuego(nickname, email, contrasenia);
            usuariosDelJuego.insertarUsuario(u);
            usuariosDelJuego.escribirPersistenciaUsuarioJuego(nickname, email, contrasenia);
            JOptionPane.showConfirmDialog(null,"Usuario creado",
                    "Crear Usuario",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showConfirmDialog(null,"Ya existe un usuario con ese nickname",
                    "Crear Usuario",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void bajaUsuario(String nickname) throws IOException{
        if (! usuariosDelJuego.existeNickname(nickname) )
            JOptionPane.showConfirmDialog(null,"NO existe un usuario con ese nickname",
                    "Borrar Usuario",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        else{
            usuariosDelJuego.borrarUsuario(usuariosDelJuego.buscarUsuario(nickname));
            usuariosDelJuego.borrarUsuarioDePersistenciaUsuarioJuego(nickname);
            JOptionPane.showConfirmDialog(null,"Usuario Borrado",
                    "Borrar Usuario",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
    
    
}
