
package logica;

import java.util.ArrayList;

public class Campania {
    //private int progreso;
    private ArrayList<Mision> listaMisiones;
    
    public Campania(){
        listaMisiones = new ArrayList<>();
    }

    public Campania(ArrayList<Mision> listaMisiones, int cantMisiones) {
        this.listaMisiones = listaMisiones;
    }
   

    public int obtenerCantMisiones() {
        return listaMisiones.size()-1;
    }

    
    
    public ArrayList<Mision> getlistaMisiones() {
        return listaMisiones;
    }

    public void setlistaMisiones(ArrayList<Mision> compuestoPorMision) {
        this.listaMisiones = compuestoPorMision;
    }
    
    
    public void insertarMision(Mision u){
        listaMisiones.add(u);
    }
    
    public void borrarMision(Mision u){
        listaMisiones.remove(u);
    }

    public Mision obtenerMision(int progreso){
        return listaMisiones.get(progreso);
    }
    
    public boolean esFinalCampania(){
        return listaMisiones.isEmpty();
    }

    @Override
    public String toString() {
        return "Campania{" + "listaMisiones=" + listaMisiones + '}';
    }
    
    
}
