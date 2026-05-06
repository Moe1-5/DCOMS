package finalproject.com.dcoms.client.view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManageLeavesPanel extends javax.swing.JPanel {

    public interface NavigationHandler {
        void onDashboardClicked();
        void onManageLeavesClicked();
        void onProfileClicked();
        void onApplyLeaveClicked();
    }
    
    public interface RefreshHandler {
        void onRefreshClicked();
    }

    private NavigationHandler navigationHandler;
    private RefreshHandler refreshHandler;

    public ManageLeavesPanel() {
        initComponents();
        setupListeners();
    }

    private void setupListeners() {
        dashboardLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (navigationHandler != null) {
                    navigationHandler.onDashboardClicked();
                }
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardLabel.setText("<html><u>Dashboard</u></html>");
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardLabel.setText("Dashboard");
            }
        });

        manageLeavesLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (navigationHandler != null) {
                    navigationHandler.onManageLeavesClicked();
                }
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                manageLeavesLabel.setText("<html><u>Manage Leaves</u></html>");
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                manageLeavesLabel.setText("Manage Leaves");
            }
        });

        profileLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (navigationHandler != null) {
                    navigationHandler.onProfileClicked();
                }
            }
        });

        applyLeaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (navigationHandler != null) {
                    navigationHandler.onApplyLeaveClicked();
                }
            }
        });
        
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (refreshHandler != null) {
                    refreshHandler.onRefreshClicked();
                }
            }
        });
    }

    public void setNavigationHandler(NavigationHandler handler) {
        this.navigationHandler = handler;
    }
    
    public void setRefreshHandler(RefreshHandler handler) {
        this.refreshHandler = handler;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        java.awt.Color primaryBlue = new java.awt.Color(52, 152, 219);
        java.awt.Color sidebarBlue = new java.awt.Color(44, 62, 80);
        java.awt.Color lightGray = new java.awt.Color(236, 240, 241);
        java.awt.Color white = new java.awt.Color(255, 255, 255);
        java.awt.Color textDark = new java.awt.Color(44, 62, 80);
        java.awt.Color textLight = new java.awt.Color(236, 240, 241);

        titleLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)))
        ;
        profileLabel = new javax.swing.JLabel(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatar.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)))
        ;
        employeeIdLabel = new javax.swing.JLabel();
        dashboardLabel = new javax.swing.JLabel();
        manageLeavesLabel = new javax.swing.JLabel();
        profileSectionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        leaveHistoryTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        applyLeaveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(550, 480));
        setBackground(lightGray);

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 28));
        titleLabel.setForeground(textDark);
        titleLabel.setText("Manage Leaves");

        refreshButton.setFont(new java.awt.Font("Segoe UI", 0, 13));
        refreshButton.setBackground(white);
        refreshButton.setForeground(textDark);
        refreshButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 195, 199), 1));
        refreshButton.setText("Refresh");
        refreshButton.setFocusPainted(false);
        refreshButton.setOpaque(true);

        jPanel1.setBackground(sidebarBlue);

        profileLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        employeeIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        employeeIdLabel.setForeground(textLight);
        employeeIdLabel.setText("employeeId");

        dashboardLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        dashboardLabel.setForeground(textLight);
        dashboardLabel.setText("Dashboard");
        dashboardLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        manageLeavesLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        manageLeavesLabel.setForeground(textLight);
        manageLeavesLabel.setText("Manage Leaves");
        manageLeavesLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        profileSectionLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        profileSectionLabel.setForeground(new java.awt.Color(127, 140, 141));
        profileSectionLabel.setText("PROFILE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(profileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(employeeIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageLeavesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashboardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profileSectionLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(dashboardLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageLeavesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(profileSectionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(profileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(employeeIdLabel)
                        .addGap(23, 23, 23))))
        );

        leaveHistoryTable.setFont(new java.awt.Font("Segoe UI", 0, 13));
        leaveHistoryTable.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Type", "Start Date", "End Date", "Duration", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        leaveHistoryTable.setRowHeight(28);
        leaveHistoryTable.setSelectionBackground(primaryBlue);
        leaveHistoryTable.setGridColor(new java.awt.Color(189, 195, 199));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 195, 199), 1));
        jScrollPane1.setViewportView(leaveHistoryTable);
        if (leaveHistoryTable.getColumnModel().getColumnCount() > 0) {
            leaveHistoryTable.getColumnModel().getColumn(0).setResizable(false);
            leaveHistoryTable.getColumnModel().getColumn(0).setHeaderValue("Type");
            leaveHistoryTable.getColumnModel().getColumn(1).setResizable(false);
            leaveHistoryTable.getColumnModel().getColumn(1).setHeaderValue("Start Date");
            leaveHistoryTable.getColumnModel().getColumn(2).setResizable(false);
            leaveHistoryTable.getColumnModel().getColumn(2).setHeaderValue("End Date");
            leaveHistoryTable.getColumnModel().getColumn(3).setResizable(false);
            leaveHistoryTable.getColumnModel().getColumn(3).setHeaderValue("Duration");
            leaveHistoryTable.getColumnModel().getColumn(4).setResizable(false);
            leaveHistoryTable.getColumnModel().getColumn(4).setHeaderValue("Status");
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel3.setForeground(textDark);
        jLabel3.setText("Leave History");

        applyLeaveButton.setFont(new java.awt.Font("Segoe UI", 1, 13));
        applyLeaveButton.setBackground(primaryBlue);
        applyLeaveButton.setForeground(white);
        applyLeaveButton.setText("Apply for Leave");
        applyLeaveButton.setFocusPainted(false);
        applyLeaveButton.setBorderPainted(false);
        applyLeaveButton.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(applyLeaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(titleLabel)
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyLeaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
    }

    private javax.swing.JButton applyLeaveButton;
    private javax.swing.JLabel dashboardLabel;
    private javax.swing.JLabel employeeIdLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable leaveHistoryTable;
    private javax.swing.JLabel manageLeavesLabel;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JLabel profileSectionLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton refreshButton;

    public void setTitle(String title) {
        titleLabel.setText(title);
    }
    
    public void setEmployeeIdLabel(String employeeId) {
        employeeIdLabel.setText(employeeId);
    }

    public JTable getLeaveHistoryTable() {
        return leaveHistoryTable;
    }
}
