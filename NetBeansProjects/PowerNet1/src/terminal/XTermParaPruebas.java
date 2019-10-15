/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminal;

import Equipo.VariablesEntorno;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;

/**
 *
 * @author junta
 */
public class XTermParaPruebas extends javax.swing.JFrame {
   private VariablesEntorno variablesEntorno;
   
   public XTermParaPruebas() {
        variablesEntorno = new VariablesEntorno();
        inicializar();
    }

    public XTermParaPruebas(String hostname) {
        variablesEntorno = new VariablesEntorno(hostname);
        inicializar();
    }

    private void inicializar() {
        initComponents();
        jTextArea1.setText(this.getPrompt());
        jTextArea1.setCaretPosition(this.getPrompt().length());
        System.out.println("** Iniciando Terminal **");
    }

    public VariablesEntorno getVariablesEntorno() {
        return variablesEntorno;
    }

    public void setVariablesEntorno(VariablesEntorno varEntorno) {
        this.variablesEntorno = varEntorno;
    }

    private void salidaATerminal(String textoSalida) {
        jTextArea1.setText(jTextArea1.getText() + "\n" + textoSalida + "\n" + this.getPrompt());
        jTextArea1.repaint();
    }

    private String getPrompt() {
        return variablesEntorno.getPrompt();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
   if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                evt.consume();
                int longPrompt = this.getPrompt().length();
                int posCursor = jTextArea1.getCaretPosition();
                int lineaNro = jTextArea1.getLineOfOffset(posCursor);
                int posInicioLinea = jTextArea1.getLineStartOffset(lineaNro) + longPrompt;
                int posFinalLinea = jTextArea1.getLineEndOffset(lineaNro);
                String lineaTextoIngresada = jTextArea1.getText(posInicioLinea, posFinalLinea - posInicioLinea);
                System.out.println("* textoCLI -> [" + lineaTextoIngresada + "]");
                // *****************************************
                // se envia a procesar la linea se comandos
                // *****************************************                
                TerminalLogica procesarCLI = new TerminalLogica(lineaTextoIngresada, variablesEntorno);
                String salidaDelComando = procesarCLI.ejecutar();                
                salidaATerminal(salidaDelComando);
            } catch (BadLocationException ex) {
                Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextArea1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(XTermParaPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XTermParaPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XTermParaPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XTermParaPruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XTermParaPruebas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
