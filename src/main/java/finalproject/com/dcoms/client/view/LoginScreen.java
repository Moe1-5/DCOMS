/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package finalproject.com.dcoms.client.view;

import finalproject.com.dcoms.client.controller.LoginController;

/**
 *
 * @author ysssh
 */
public class LoginScreen extends javax.swing.JPanel {

    private LoginController loginController;

    public void setController(LoginController loginController) {
        this.loginController = loginController;
    }

    public LoginScreen() {
        initComponents();
        buildUI();
    }

    public String getUsername() {
        return txtfieldUsername.getText().trim();
    }

    public String getPassword() {
        return txtfieldPassword.getText();
    }

    private void buildUI() {
        setPreferredSize(new java.awt.Dimension(350, 400));
        setBackground(new java.awt.Color(236, 240, 241));

        java.awt.Color primaryBlue = new java.awt.Color(52, 152, 219);
        java.awt.Color textDark = new java.awt.Color(44, 62, 80);
        java.awt.Color labelGray = new java.awt.Color(127, 140, 141);
        java.awt.Color borderGray = new java.awt.Color(189, 195, 199);
        java.awt.Color white = new java.awt.Color(255, 255, 255);

        javax.swing.JLabel lblLogo = new javax.swing.JLabel(
            new javax.swing.ImageIcon(
                new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))
                    .getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH)
            )
        );

        javax.swing.JLabel lblTitle = new javax.swing.JLabel("HRM System");
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24));
        lblTitle.setForeground(textDark);
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.JLabel lblSubtitle = new javax.swing.JLabel("Sign in to continue");
        lblSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblSubtitle.setForeground(labelGray);
        lblSubtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.JLabel lblUsername = new javax.swing.JLabel("Username");
        lblUsername.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblUsername.setForeground(labelGray);

        txtfieldUsername.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtfieldUsername.setForeground(textDark);
        txtfieldUsername.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(borderGray, 1),
            javax.swing.BorderFactory.createEmptyBorder(10, 12, 10, 12)));

        javax.swing.JLabel lblPassword = new javax.swing.JLabel("Password");
        lblPassword.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblPassword.setForeground(labelGray);

        txtfieldPassword.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtfieldPassword.setForeground(textDark);
        txtfieldPassword.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(borderGray, 1),
            javax.swing.BorderFactory.createEmptyBorder(10, 12, 10, 12)));
        txtfieldPassword.setEchoChar('*');

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnLogin.setBackground(primaryBlue);
        btnLogin.setForeground(white);
        btnLogin.setText("Login");
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setOpaque(true);
        btnLogin.setPreferredSize(new java.awt.Dimension(0, 42));
        btnLogin.addActionListener(e -> {
            if (loginController != null) {
                loginController.login(getUsername(), getPassword());
            }
        });

        txtfieldUsername.addActionListener(e -> txtfieldPassword.requestFocus());
        txtfieldPassword.addActionListener(e -> {
            if (loginController != null) {
                loginController.login(getUsername(), getPassword());
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(lblLogo)
                .addComponent(lblTitle)
                .addComponent(lblSubtitle)
                .addGap(20)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblUsername)
                        .addComponent(txtfieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPassword)
                        .addComponent(txtfieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(30)
                .addComponent(lblLogo)
                .addGap(15)
                .addComponent(lblTitle)
                .addGap(5)
                .addComponent(lblSubtitle)
                .addGap(30)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25)
                .addComponent(btnLogin)
                .addGap(30)
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. Content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtfieldUsername = new javax.swing.JTextField();
        txtfieldPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(350, 400));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JPasswordField txtfieldPassword;
    private javax.swing.JTextField txtfieldUsername;
    // End of variables declaration//GEN-END:variables
}