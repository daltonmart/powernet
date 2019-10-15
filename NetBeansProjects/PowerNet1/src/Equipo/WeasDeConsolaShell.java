/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equipo;


import java.io.*; // <--------------
import java.util.Scanner;
public class WeasDeConsolaShell {
    public static void main(String[] args) {
        boolean op=true;
        int menu=-2;
        Runtime app = Runtime.getRuntime(); // <----------
        Scanner read=new Scanner (System.in);
        do
        {
            System.out.print("c:/");
            String com=read.next();
            if ("exit".equals(com)) menu=-1;       // Salir
            if ("help".equals(com)) menu=0;        // Monstar comandos
            if ("turnoff".equals(com)) menu=1;    // Apagar computadora  
            if ("browser".equals(com)) menu=2;     // Abrir navegador
            if ("files".equals(com)) menu=3;       // Abrir una carpeta
            if ("mypc".equals(com)) menu=4;        // Abrir Mi PC
            if ("".equals(com)) menu=5;          // Abrir consola de CMD
            if ("".equals(com)) menu=6;
            if ("".equals(com)) menu=7;
            if ("".equals(com)) menu=8;
            if ("".equals(com)) menu=9;
            if ("".equals(com)) menu=10;
            
            if (menu==-1) {op=false; System.out.println("Terminando ejecución");}
            System.out.println(""+menu);
            
            switch (menu)
            {
                case -2:
                    System.out.println("'"+com+"' No se reconoce como comando del sistema");
                case 0:
                    System.out.println("Esta es la sección de ayuda \nLista de comandos: \nexit - Terminar Programa \nhelp - Mostrar ayuda \nturnoff - Apagar el equipo \nbrowser - abrir el navegador web \nfiles - abrir directorio 'Mis Documentos' \nmypc- abrir directorio 'Mi PC' ");
                    break;
                case 1:
                /*    try {
                        String linea;
                        Process p = Runtime.getRuntime().exec("shutdown-r-c");
                        BufferedReader input = new BufferedReader (new InputStreamReader (p.getInputStream()));
                        while ((linea = input.readLine()) != null) {
             System.out.println(linea);
         }
           input.close();
    }catch (Exception err) {
           err.printStackTrace();
    } */
                    break;
                case 2:
                    try
                    {
                        app.exec("C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
                    }
                    catch(Exception e)
                    {
                        try
                        {
                            app.exec("C:/Program Files (x86)/Google/hrome/pplication/chrome.exe");
                        }catch (Exception f)
                        {
                            
                        }
                    }
                    break;
                case 3:
                    
                    break;
                case 4:
                    try
                    {
                        app.exec("C:/Windows/explorer.exe");
                    }
                    catch(Exception e)
                    {
                        
                    }
                    break;
                case 5:
                    
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
            }
        }while (op);
    }
    
}
