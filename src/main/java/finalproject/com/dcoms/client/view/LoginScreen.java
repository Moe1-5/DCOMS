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
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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

        // fixed width wrapper panel so all fields are the same width
        int fieldWidth = 280;
        java.awt.Dimension fieldSize = new java.awt.Dimension(fieldWidth, 42);
        txtfieldUsername.setPreferredSize(fieldSize);
        txtfieldPassword.setPreferredSize(fieldSize);
        btnLogin.setPreferredSize(new java.awt.Dimension(fieldWidth, 42));

        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.anchor = java.awt.GridBagConstraints.CENTER;

        gbc.gridy = 0;
        gbc.insets = new java.awt.Insets(30, 0, 0, 0);
        add(lblLogo, gbc);

        gbc.gridy = 1;
        gbc.insets = new java.awt.Insets(15, 0, 0, 0);
        add(lblTitle, gbc);

        gbc.gridy = 2;
        gbc.insets = new java.awt.Insets(5, 0, 0, 0);
        add(lblSubtitle, gbc);

        gbc.gridy = 3;
        gbc.insets = new java.awt.Insets(30, 0, 0, 0);
        add(lblUsername, gbc);

        gbc.gridy = 4;
        gbc.insets = new java.awt.Insets(5, 0, 0, 0);
        add(txtfieldUsername, gbc);

        gbc.gridy = 5;
        gbc.insets = new java.awt.Insets(15, 0, 0, 0);
        add(lblPassword, gbc);

        gbc.gridy = 6;
        gbc.insets = new java.awt.Insets(5, 0, 0, 0);
        add(txtfieldPassword, gbc);

        gbc.gridy = 7;
        gbc.insets = new java.awt.Insets(25, 0, 30, 0);
        add(btnLogin, gbc);
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
