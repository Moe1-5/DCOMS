/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package finalproject.com.dcoms.client.view;

import finalproject.com.dcoms.remote.HRMService;
import java.rmi.Naming;
import javax.swing.JOptionPane;

/**
 *
 * @author zechn
 */
public class ClientIPPromptFrame extends javax.swing.JFrame {

    public interface ConnectCallback {
        void onConnectSuccess(HRMService service);
        void onConnectFailure(String error);
    }

    private ConnectCallback callback;
    private javax.swing.JTextField txtServerIP;
    private javax.swing.JTextField txtPort;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnCancel;

    /**
     * Creates new form ClientIPPrompt
     */
    public ClientIPPromptFrame() {
        initComponents();
        buildUI();
        txtServerIP.setText("localhost");
        txtPort.setText("1099");
    }

    private void buildUI() {
        setTitle("Server Connection");
        setSize(360, 250);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        java.awt.Color primaryBlue = new java.awt.Color(52, 152, 219);
        java.awt.Color textDark = new java.awt.Color(44, 62, 80);
        java.awt.Color labelGray = new java.awt.Color(127, 140, 141);
        java.awt.Color borderGray = new java.awt.Color(189, 195, 199);
        java.awt.Color white = new java.awt.Color(255, 255, 255);

        javax.swing.JLabel lblTitle = new javax.swing.JLabel("Connect to server");
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitle.setForeground(textDark);

        javax.swing.JLabel lblServerIP = new javax.swing.JLabel("Server IP:");
        lblServerIP.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblServerIP.setForeground(labelGray);

        txtServerIP = new javax.swing.JTextField(15);
        txtServerIP.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtServerIP.setBorder(javax.swing.BorderFactory.createLineBorder(borderGray, 1));

        javax.swing.JLabel lblPort = new javax.swing.JLabel("Port:");
        lblPort.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblPort.setForeground(labelGray);

        txtPort = new javax.swing.JTextField(8);
        txtPort.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtPort.setBorder(javax.swing.BorderFactory.createLineBorder(borderGray, 1));

        btnConnect = new javax.swing.JButton("Connect");
        btnConnect.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnConnect.setBackground(primaryBlue);
        btnConnect.setForeground(white);
        btnConnect.setFocusPainted(false);
        btnConnect.setBorderPainted(false);
        btnConnect.setOpaque(true);
        btnConnect.addActionListener(e -> attemptConnect());

        btnCancel = new javax.swing.JButton("Cancel");
        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnCancel.setFocusPainted(false);
        btnCancel.addActionListener(e -> System.exit(0));

        javax.swing.JPanel mainPanel = new javax.swing.JPanel();
        mainPanel.setBackground(white);
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblTitle)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblServerIP)
                        .addComponent(txtServerIP, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPort)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                    layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(lblTitle)
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblServerIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtServerIP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(mainPanel);
    }

    public void setConnectCallback(ConnectCallback callback) {
        this.callback = callback;
    }

    private void attemptConnect() {
        String host = txtServerIP.getText().trim();
        String portText = txtPort.getText().trim();

        if (host.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a server IP address.", "Missing Input", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int port;
        try {
            port = Integer.parseInt(portText);
            if (port <= 0 || port > 65535) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid port number (1-65535).", "Invalid Port", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String url = "rmi://" + host + ":" + port + "/HRMService";
            HRMService service = (HRMService) Naming.lookup(url);
            this.dispose();
            if (callback != null) {
                callback.onConnectSuccess(service);
            }
        } catch (Exception e) {
            if (callback != null) {
                callback.onConnectFailure(e.getMessage());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. Content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientIPPromptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientIPPromptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientIPPromptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientIPPromptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new ClientIPPromptFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}