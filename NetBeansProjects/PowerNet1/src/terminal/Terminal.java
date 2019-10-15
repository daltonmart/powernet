package terminal;

import Equipo.VariablesEntorno;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;

public class Terminal extends javax.swing.JPanel {

    private VariablesEntorno variablesEntorno;

    public VariablesEntorno getVariablesEntorno() {
        return variablesEntorno;
    }

    public void setVariablesEntorno(VariablesEntorno varEntorno) {
        this.variablesEntorno = varEntorno;
    }

    public Terminal() {
        variablesEntorno = new VariablesEntorno();
        inicializar();
    }

    public Terminal(String hostname) {
        variablesEntorno = new VariablesEntorno(hostname);
        inicializar();
    }

    public Terminal(String hostname, String usuario) {
        variablesEntorno = new VariablesEntorno(hostname, usuario);
        inicializar();
    }

    private void inicializar() {
        initComponents();
        jTextArea1.setText(this.getPrompt());
        jTextArea1.setCaretPosition(this.getPrompt().length());
        System.out.println("** Iniciando Terminal **");
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

        setLayout(new java.awt.BorderLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
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
                ProcesadorDeComandos procesarCLI = new ProcesadorDeComandos(lineaTextoIngresada, variablesEntorno);
                String salidaDelComando = procesarCLI.ejecutar();
                //String salidaDelComando = "prueba de salida";
                salidaATerminal(salidaDelComando);

            } catch (BadLocationException ex) {
                Logger.getLogger(Terminal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1KeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
