/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package finalproject.com.dcoms.server;

import javax.swing.JOptionPane;

/**
 *
 * @author zechn
 */
public class ServerIPPromptFrame extends javax.swing.JFrame {

    public interface StartCallback {
        void onStart(String rmiHostname, int rmiPort, String dbHost, int dbPort);
        void onCancel();
        void onStop();
    }

    private StartCallback callback;
    private boolean isRunning = false;
    private javax.swing.JTextField txtRmiHostname;
    private javax.swing.JTextField txtRmiPort;
    private javax.swing.JTextField txtDbHost;
    private javax.swing.JTextField txtDbPort;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel lblStatus;

    /**
     * Creates new form ServerIPPrompt
     */
    public ServerIPPromptFrame() {
        initComponents();
        buildUI();
        txtRmiHostname.setText("localhost");
        txtRmiPort.setText("1099");
        txtDbHost.setText("localhost");
        txtDbPort.setText("1527");
    }

    public void setStartCallback(StartCallback callback) {
        this.callback = callback;
    }

    private void buildUI() {
        setTitle("Server Setup");
        setSize(340, 340);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        java.awt.Color primaryBlue = new java.awt.Color(52, 152, 219);
        java.awt.Color dangerRed = new java.awt.Color(231, 76, 60);
        java.awt.Color textDark = new java.awt.Color(44, 62, 80);
        java.awt.Color labelGray = new java.awt.Color(127, 140, 141);
        java.awt.Color borderGray = new java.awt.Color(189, 195, 199);
        java.awt.Color white = new java.awt.Color(255, 255, 255);

        javax.swing.JLabel lblTitle = new javax.swing.JLabel("Start Server");
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitle.setForeground(textDark);

        javax.swing.JLabel lblRmiHostname = new javax.swing.JLabel("Configure Server IP:");
        lblRmiHostname.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblRmiHostname.setForeground(labelGray);

        txtRmiHostname = new javax.swing.JTextField(15);
        txtRmiHostname.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtRmiHostname.setBorder(javax.swing.BorderFactory.createLineBorder(borderGray, 1));

        javax.swing.JLabel lblRmiPort = new javax.swing.JLabel("Server Port:");
        lblRmiPort.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblRmiPort.setForeground(labelGray);

        txtRmiPort = new javax.swing.JTextField(8);
        txtRmiPort.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtRmiPort.setBorder(javax.swing.BorderFactory.createLineBorder(borderGray, 1));

        javax.swing.JLabel lblDbHost = new javax.swing.JLabel("Database IP:");
        lblDbHost.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblDbHost.setForeground(labelGray);

        txtDbHost = new javax.swing.JTextField(15);
        txtDbHost.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtDbHost.setBorder(javax.swing.BorderFactory.createLineBorder(borderGray, 1));

        javax.swing.JLabel lblDbPort = new javax.swing.JLabel("Database Port:");
        lblDbPort.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblDbPort.setForeground(labelGray);

        txtDbPort = new javax.swing.JTextField(8);
        txtDbPort.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtDbPort.setBorder(javax.swing.BorderFactory.createLineBorder(borderGray, 1));

        lblStatus = new javax.swing.JLabel("Ready to start server...");
        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblStatus.setForeground(labelGray);

        btnStart = new javax.swing.JButton("Start Server");
        btnStart.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnStart.setBackground(primaryBlue);
        btnStart.setForeground(white);
        btnStart.setFocusPainted(false);
        btnStart.setBorderPainted(false);
        btnStart.setOpaque(true);
        btnStart.addActionListener(e -> {
            if (isRunning) {
                attemptStop();
            } else {
                attemptStart();
            }
        });

        btnCancel = new javax.swing.JButton("Cancel");
        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnCancel.setFocusPainted(false);
        btnCancel.addActionListener(e -> {
            if (callback != null) {
                callback.onCancel();
            }
            System.exit(0);
        });

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
                        .addComponent(lblRmiHostname)
                        .addComponent(txtRmiHostname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblRmiPort)
                        .addComponent(txtRmiPort, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblDbHost)
                        .addComponent(txtDbHost, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblDbPort)
                        .addComponent(txtDbPort, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(lblStatus)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                    layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(lblTitle)
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRmiHostname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRmiHostname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRmiPort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRmiPort, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDbHost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDbHost, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDbPort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDbPort, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15)
                .addComponent(lblStatus)
                .addGap(15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(mainPanel);
    }

    private void attemptStart() {
        String rmiHostname = txtRmiHostname.getText().trim();
        String rmiPortText = txtRmiPort.getText().trim();
        String dbHost = txtDbHost.getText().trim();
        String dbPortText = txtDbPort.getText().trim();

        if (rmiHostname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Configure Server IP.", "Missing Input", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int rmiPort;
        int dbPort;

        try {
            rmiPort = Integer.parseInt(rmiPortText);
            if (rmiPort <= 0 || rmiPort > 65535) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Server Port (1-65535).", "Invalid Port", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            dbPort = Integer.parseInt(dbPortText);
            if (dbPort <= 0 || dbPort > 65535) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Database Port (1-65535).", "Invalid Port", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (callback != null) {
            callback.onStart(rmiHostname, rmiPort, dbHost, dbPort);
        }
    }

    private void attemptStop() {
        int result = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to stop the server?",
            "Confirm Stop",
            JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            if (callback != null) {
                callback.onStop();
            }
        }
    }

    public void setServerRunning(boolean running) {
        this.isRunning = running;

        java.awt.Color primaryBlue = new java.awt.Color(52, 152, 219);
        java.awt.Color dangerRed = new java.awt.Color(231, 76, 60);
        java.awt.Color white = new java.awt.Color(255, 255, 255);

        if (running) {
            btnStart.setText("Close Server");
            btnStart.setBackground(dangerRed);
            btnCancel.setVisible(false);
            lblStatus.setText("Server is running...");
            lblStatus.setForeground(new java.awt.Color(39, 174, 96));

            txtRmiHostname.setEnabled(false);
            txtRmiPort.setEnabled(false);
            txtDbHost.setEnabled(false);
            txtDbPort.setEnabled(false);
        } else {
            btnStart.setText("Start Server");
            btnStart.setBackground(primaryBlue);
            btnCancel.setVisible(true);
            lblStatus.setText("Ready to start server...");
            lblStatus.setForeground(new java.awt.Color(127, 140, 141));

            txtRmiHostname.setEnabled(true);
            txtRmiPort.setEnabled(true);
            txtDbHost.setEnabled(true);
            txtDbPort.setEnabled(true);
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
        setSize(400, 280);
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
            java.util.logging.Logger.getLogger(ServerIPPromptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerIPPromptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerIPPromptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerIPPromptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new ServerIPPromptFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}