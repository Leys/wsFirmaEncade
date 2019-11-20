/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import clases.clsFirma;
import clases.clsUsuario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class jpnlRegistro extends javax.swing.JPanel {

    /**
     * Creates new form jpnlRegistro
     */
    public jpnlRegistro() {
        initComponents();
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
        jtxtUsuario = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jtxtConfContra = new javax.swing.JTextField();
        jtxtContra = new javax.swing.JTextField();
        jtxtApellido = new javax.swing.JTextField();
        jtbnRegistrar = new javax.swing.JButton();
        jlblError = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(320, 300));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Registro");

        jtxtUsuario.setText("dig");

        jtxtNombre.setText("Nombre");

        jtxtConfContra.setText("dig");

        jtxtContra.setText("dig");

        jtxtApellido.setText("Apellido");
        jtxtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtApellidoActionPerformed(evt);
            }
        });

        jtbnRegistrar.setText("Registrar");
        jtbnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnRegistrarActionPerformed(evt);
            }
        });

        jlblError.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblError)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jtbnRegistrar)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtxtConfContra, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtUsuario)
                            .addComponent(jtxtNombre)
                            .addComponent(jtxtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblError)
                .addGap(13, 13, 13)
                .addComponent(jtxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtxtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxtConfContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtbnRegistrar)
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtApellidoActionPerformed

    private void jtbnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnRegistrarActionPerformed
        try {
            // TODO add your handling code here:

            double inicio = System.currentTimeMillis();

            clsFirma obj = new clsFirma();
            obj.iniciarNuevo();

            String usuario = jtxtUsuario.getText();
            String nombre = jtxtNombre.getText();
            String ap = jtxtApellido.getText();
            String pwd = jtxtContra.getText();
            String confpwd = jtxtConfContra.getText();
            String foto = "";
            String firma = "";
            String h = "";
            //decargar semillas, guardar llave publica y h

            if (usuario == "" || nombre == "" || ap == "" || pwd == "" || confpwd == "") {
                jlblError.setText("Llenar todos los campos");
            } else if (!pwd.equals(confpwd)) {
                jlblError.setText("Las contraseñas no coinciden");

            } else {
                firma = obj.getUltFirmaHex();

                for (int uh : obj.getUltH()) {
                    h += String.valueOf(uh) + ",";
                }
                h = h.substring(0, h.length() - 1);

                clsUsuario us = new clsUsuario();
                us.conexion();
                String res = us.registrarUsuI(nombre, confpwd, usuario, foto, h, firma);

                if (res.equals("0")) {
                    jlblError.setText("El usuario ya existe");
                } else {
                    String[] aux = obj.getUltSeedHex();
                    String semilla = aux[0] + "\n" + aux[1];
                    
                    File archivo = new File("./seed.key");
                    BufferedWriter bw;
                    bw = new BufferedWriter(new FileWriter(archivo));
                    if (archivo.exists()) {
                        //Se sobreescribio la semilla
                    }
                    bw.write(semilla);
                    bw.close();
                    jlblError.setText("Usuario creado la semilla se ha almacenado en su computadora");
//            request.getSession().setAttribute("semilla", semilla);
//            request.setAttribute("edo", "Exito, por favor almacene su token en un lugar seguro");
//            request.setAttribute("ban", "1");
                }

                System.out.println("Tiempo registro: " + (System.currentTimeMillis() - inicio));

            }

        } catch (IOException ex) {
            Logger.getLogger(jpnlRegistro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jpnlRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtbnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlblError;
    private javax.swing.JButton jtbnRegistrar;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JTextField jtxtConfContra;
    private javax.swing.JTextField jtxtContra;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtUsuario;
    // End of variables declaration//GEN-END:variables
}
