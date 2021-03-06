/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxycli;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author alexX
 */
public class Email extends javax.swing.JFrame {
     String correoOrig;
     String pass;
     String ipServer; 
     BufferedReader in;//Para leer del teclado con el método readLine()
     PrintWriter out;//Para poder mandar el string leido al servidor
    /**
     * Creates new form Email
     
     */
    public Email() throws IOException {
        initComponents();   
        setLocationRelativeTo(null);
        setVisible(true);
        leer1();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Principal = new javax.swing.JTabbedPane();
        Panel = new javax.swing.JPanel();
        lblConfigTitle = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblIPSP = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        txtIPSP = new javax.swing.JTextField();
        BtnConfigGmail = new javax.swing.JButton();
        btnAceptarConfig = new javax.swing.JButton();
        btnCancelarConfig = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblDest = new javax.swing.JLabel();
        txtDestinatario = new javax.swing.JTextField();
        lblAsunto = new javax.swing.JLabel();
        txtAsunto = new javax.swing.JTextField();
        lblMensaje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAMensaje = new javax.swing.JTextArea();
        btnEnviarCorreo = new javax.swing.JButton();
        btnCancelarCorreo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Enviar Correo");

        Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Panel.setPreferredSize(new java.awt.Dimension(292, 280));

        lblConfigTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblConfigTitle.setText("Configuración de Perfil - Proxy");

        lblMail.setText("Correo Electrónico");

        lblPass.setText("Contraseña");

        lblIPSP.setText("IP Servidor Proxy");

        txtEmail.setToolTipText("E-mail");
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtIPSP.setToolTipText("default: localhost");

        BtnConfigGmail.setText("Configurar Gmail");
        BtnConfigGmail.setToolTipText("Otorgar permisos en Gmail");
        BtnConfigGmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfigGmailActionPerformed(evt);
            }
        });

        btnAceptarConfig.setText("Aceptar");
        btnAceptarConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarConfigActionPerformed(evt);
            }
        });

        btnCancelarConfig.setText("Cancelar");
        btnCancelarConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarConfigActionPerformed(evt);
            }
        });

        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblConfigTitle)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(lblMail)
                                .addGap(27, 27, 27)
                                .addComponent(txtEmail))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPass)
                                    .addComponent(lblIPSP))
                                .addGap(31, 31, 31)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIPSP, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                    .addComponent(txtPass))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addGap(0, 58, Short.MAX_VALUE)
                        .addComponent(btnAceptarConfig)
                        .addGap(31, 31, 31)
                        .addComponent(Limpiar)
                        .addGap(31, 31, 31)
                        .addComponent(btnCancelarConfig)
                        .addGap(50, 50, 50))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnConfigGmail)
                .addGap(138, 138, 138))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConfigTitle)
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIPSP)
                    .addComponent(txtIPSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarConfig)
                    .addComponent(Limpiar)
                    .addComponent(btnCancelarConfig))
                .addGap(18, 18, 18)
                .addComponent(BtnConfigGmail)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        Principal.addTab("Config", Panel);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("");

        lblDest.setText("Destinatario");

        txtDestinatario.setToolTipText("Email Destino");

        lblAsunto.setText("Asunto");

        lblMensaje.setText("Mensaje");

        txtAMensaje.setColumns(20);
        txtAMensaje.setRows(5);
        jScrollPane1.setViewportView(txtAMensaje);

        btnEnviarCorreo.setText("Enviar");
        btnEnviarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCorreoActionPerformed(evt);
            }
        });

        btnCancelarCorreo.setText("Cancelar");
        btnCancelarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCorreoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDest)
                                    .addComponent(lblAsunto))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDestinatario)
                                    .addComponent(txtAsunto, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                            .addComponent(lblMensaje))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEnviarCorreo)
                        .addGap(63, 63, 63)
                        .addComponent(btnCancelarCorreo)
                        .addGap(85, 85, 85))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDest)
                    .addComponent(txtDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAsunto)
                    .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblMensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviarCorreo)
                    .addComponent(btnCancelarCorreo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Principal.addTab("Mensaje", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Principal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Principal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnConfigGmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfigGmailActionPerformed

        AbrirURLGmail();  // TODO add your handling code here:
    }//GEN-LAST:event_BtnConfigGmailActionPerformed

    private void btnAceptarConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarConfigActionPerformed

        String pwd= new String(txtPass.getPassword());
        if(EmailCheck()==true){
            if(txtEmail.getText()!="" && txtIPSP.getText()!=""&& pwd!=""){
                escribirArch(txtEmail.getText()+" "+pwd+" "+txtIPSP.getText());
                leer();
                Principal.setSelectedIndex(1);
            }
            else
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos");
        }else{
            JOptionPane.showMessageDialog(null, "El email es inválido");
        }
    }//GEN-LAST:event_btnAceptarConfigActionPerformed

    private void btnCancelarConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarConfigActionPerformed

        System.exit(0);
    }//GEN-LAST:event_btnCancelarConfigActionPerformed

    private void btnEnviarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCorreoActionPerformed
            String mensaje=correoOrig+"¬"+ pass+"¬"+txtDestinatario.getText()+"¬"+ txtAsunto.getText()+"¬"+txtAMensaje.getText();
            if(mensaje!="" && out!=null){
                out.println(mensaje);
            }else{
                System.out.println("Hay un error");
            }

            System.out.print("enviando mensaje");
            btnEnviarCorreo.setEnabled(false);
            limpiar1();
        
    }//GEN-LAST:event_btnEnviarCorreoActionPerformed

    private void btnCancelarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCorreoActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarCorreoActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_LimpiarActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {       
          
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold> 
        Email ventE= new Email();
        ventE.leer();
        ventE.run();
    } 
    public void limpiar(){
                txtEmail.setText("");
		txtPass.setText("");
		txtIPSP.setText("");
	}
    public void limpiar1(){
                txtDestinatario.setText("");
		txtAMensaje.setText("");
		txtAsunto.setText("");
	}

    public void run() throws IOException{
                String serverAddress = ipServer;
		Socket clientSocket = new Socket(ipServer,9000);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //lee el socket ingresado.
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		while (true) {
			String line = in.readLine();//lee los datos enviados de servidor
			if (line.startsWith("Error")) {//si hay palabras restringuidas es denegado 
				JOptionPane.showMessageDialog(null, line );
                                btnEnviarCorreo.setEnabled(true);
			} else if (line.startsWith("correcto")) {//s ino hay palabras restringuidas es aceptado 
				JOptionPane.showMessageDialog(null, line);
                                btnEnviarCorreo.setEnabled(true);
			} 
		}
    }

  public void leer(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
			archivo = new File ("User.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			String linea;
                        if((linea=br.readLine())!=null){
                        StringTokenizer token=new StringTokenizer(linea," ");
                        correoOrig=(token.nextToken());
                        pass=(token.nextToken());
                        ipServer=(token.nextToken());
                        }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           try{
              if( null != fr ){
                 fr.close();
              }
           }catch (Exception e2){
              e2.printStackTrace();
           }
        }

        
    }

      private void AbrirURLGmail(){

		String URL = "https://www.google.com/settings/security/lesssecureapps";
		
        try {
            Desktop.getDesktop().browse(new URI(URL));
            
            // TODO Auto-generated catch block
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
        

	}
    
    private boolean EmailCheck(){
    Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(txtEmail.getText());
       return mather.matches();
    }
    public void escribirArch(String linea){
       File f;
	f = new File("User.txt");
	try{
	FileWriter w = new FileWriter(f);
	BufferedWriter bw = new BufferedWriter(w);
	PrintWriter wr = new PrintWriter(bw);  
	wr.write(linea);
	wr.close();

	bw.close();
	}catch(IOException e){};
	 }
    public void leer1(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
			archivo = new File ("User.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			String linea;
                        if((linea=br.readLine())!=null){
                        StringTokenizer token=new StringTokenizer(linea," ");
                        txtEmail.setText(token.nextToken());
                        txtPass.setText(token.nextToken());
                        txtIPSP.setText(token.nextToken());
                        }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           try{
              if( null != fr ){
                 fr.close();
              }
           }catch (Exception e2){
              e2.printStackTrace();
           }
        }
    }
  
  
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConfigGmail;
    private javax.swing.JButton Limpiar;
    private javax.swing.JPanel Panel;
    private javax.swing.JTabbedPane Principal;
    private javax.swing.JButton btnAceptarConfig;
    private javax.swing.JButton btnCancelarConfig;
    private javax.swing.JButton btnCancelarCorreo;
    private javax.swing.JButton btnEnviarCorreo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAsunto;
    private javax.swing.JLabel lblConfigTitle;
    private javax.swing.JLabel lblDest;
    private javax.swing.JLabel lblIPSP;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblPass;
    private javax.swing.JTextArea txtAMensaje;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextField txtDestinatario;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIPSP;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
