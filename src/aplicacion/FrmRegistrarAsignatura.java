/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import clases.Asignatura;
import clases.Docente;
import clases.Jornada;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author folke
 */
public class FrmRegistrarAsignatura extends javax.swing.JFrame {
    private ArrayList<Docente> docentes = new ArrayList();
    private ArrayList<Asignatura> asignaturas = new ArrayList();
    //private ArrayList<Asignatura> horarios = new ArrayList();
    
    
    /**
     * Creates new form FrmRegistrarAsignatura
     */
    public FrmRegistrarAsignatura() {
        initComponents();
        this.setSize(460, 500);
        this.setLocationRelativeTo(null);
        this.cboJornada.setModel(new DefaultComboBoxModel(Jornada.values()));
        generarDocentes("docentes.txt");
        generarAsignaturas("asignaturas.txt");
        generarComboHorario();
        generarComboDocente();
        generarComboSala();
    }
    
    public void generarDocentes(String archivo){
        try{
            FileReader f = new FileReader(archivo);
            Scanner sc = new Scanner(f);
            String linea;
            
            while(sc.hasNextLine()){
                linea = sc.nextLine();
                Docente d = new Docente(linea);
                docentes.add(d);
            }
            sc.close();
            f.close();
            
        } 
        catch (IOException ex) {
            
        }
    }
    
    public void generarAsignaturas(String archivo){
        try{
            FileReader f = new FileReader(archivo);
            Scanner sc = new Scanner(f);
            String linea;
            
            while(sc.hasNextLine()){
                linea = sc.nextLine();
                Asignatura a = new Asignatura(linea);
                asignaturas.add(a);
            }
            sc.close();
            f.close();
            
        } 
        catch (IOException ex) {
            
        }
    }
    
    public void generarComboDocente(){
        String docente;
        
        for (int i = 0; i < docentes.size(); i++){
            docente = docentes.get(i).getNombreDocente().toString();
            this.cboDocente.addItem(docente);
        }
    }
    
    public void generarComboSala(){
        try{
            FileReader f = new FileReader("salas.txt");
            Scanner sc = new Scanner(f);
            String linea;
            
            while(sc.hasNextLine()){
                linea = sc.nextLine(); 
                this.cboSala.addItem(linea);
                
            }
            sc.close();
            f.close();
        }
        catch(IOException ex){
            
        }
    }
    
    public void generarComboHorario(){
        try{
            FileReader f = new FileReader("horarios.txt");
            Scanner sc = new Scanner(f);
            String linea;
            
            while(sc.hasNextLine()){
                linea = sc.nextLine();
                this.cboHorario.addItem(linea);
                
            }
            sc.close();
            f.close();
        }
        catch(IOException ex){
            
        }
    }
    
    public boolean asignaturaExiste(){
        boolean existe = false;
        String txtCodigo = this.txtCodigo.getText();
        String codigo;
        for(int i = 0; i < asignaturas.size(); i++){
            codigo = asignaturas.get(i).getCodigo().toString();
            if (txtCodigo.compareTo(codigo) == 0){
                existe = true;
                JOptionPane.showMessageDialog(this, "Asignatura ya esta registrado");               
            }
        }
        return existe;
    }
    
    public boolean expresionesRegulares(){
        boolean valido = false;
        
        Pattern pCodigo = Pattern.compile("([A-Z0-9]{7})$");
        Matcher mCodigo = pCodigo.matcher(txtCodigo.getText());
        boolean codigoValido = mCodigo.matches();
        
        Pattern pNombre = Pattern.compile("([A-Za-z]+)$");
        Matcher mNombre = pNombre.matcher((txtNombre.getText()));
        boolean nombreValido = mNombre.matches();
        
        if (txtCodigo.getText() == null || codigoValido == false){
            JOptionPane.showMessageDialog(this, "Codigo invalido");
            txtCodigo.requestFocus();
            valido = false;
        }
        else if (txtNombre.getText() == null || nombreValido == false){
            JOptionPane.showMessageDialog(this, "Nombre invalido");
            txtNombre.requestFocus();
            valido = false;
        }
        else{
            valido = true;
        }
        return valido;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JButton();
        btnGuardar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        cboJornada = new javax.swing.JComboBox<>();
        cboHorario = new javax.swing.JComboBox<>();
        cboSala = new javax.swing.JComboBox<>();
        cboDocente = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRAR ASIGNATURA");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 440, 40);

        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 150, 60, 16);

        jLabel3.setText("Codigo:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 110, 50, 16);

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(180, 100, 130, 30);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(250, 370, 69, 25);

        btnGuardar1.setText("Guardar");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar1);
        btnGuardar1.setBounds(90, 370, 79, 25);

        jLabel4.setText("Jornada:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 230, 60, 16);

        jLabel5.setText("Horario:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 270, 60, 16);

        jLabel6.setText("Sala:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(90, 310, 60, 16);

        jLabel7.setText("Docente:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(90, 190, 60, 16);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre);
        txtNombre.setBounds(180, 140, 130, 30);

        cboJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboJornadaActionPerformed(evt);
            }
        });
        getContentPane().add(cboJornada);
        cboJornada.setBounds(180, 220, 130, 30);

        cboHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHorarioActionPerformed(evt);
            }
        });
        getContentPane().add(cboHorario);
        cboHorario.setBounds(180, 260, 130, 30);

        cboSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSalaActionPerformed(evt);
            }
        });
        getContentPane().add(cboSala);
        cboSala.setBounds(180, 300, 130, 30);

        getContentPane().add(cboDocente);
        cboDocente.setBounds(180, 180, 130, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cboHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboHorarioActionPerformed

    private void cboJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboJornadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboJornadaActionPerformed

    private void cboSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSalaActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        // TODO add your handling code here:
        if (expresionesRegulares() == true && asignaturaExiste() == false){
            Asignatura a = new Asignatura(txtCodigo.getText(), txtNombre.getText(), cboDocente.getSelectedItem().toString(), cboJornada.getSelectedItem().toString(),
            cboHorario.getSelectedItem().toString(), cboSala.getSelectedItem().toString());
            a.toSave("asignaturas.txt");
            JOptionPane.showMessageDialog(this, "Asignatura registrado");
            
            
            this.txtCodigo.setText(null);
            this.txtNombre.setText(null); 
        }
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRegistrarAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistrarAsignatura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JComboBox<String> cboDocente;
    private javax.swing.JComboBox<String> cboHorario;
    private javax.swing.JComboBox<String> cboJornada;
    private javax.swing.JComboBox<String> cboSala;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
