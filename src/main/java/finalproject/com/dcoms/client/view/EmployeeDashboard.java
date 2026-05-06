package finalproject.com.dcoms.client.view;

import finalproject.com.dcoms.client.model.Employee;

public class EmployeeDashboard extends javax.swing.JPanel {

    public interface NavigationHandler {
        void onDashboardClicked();
        void onManageLeavesClicked();
        void onProfileClicked();
    }

    private NavigationHandler navigationHandler;

    public EmployeeDashboard() {
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
    }

    public void setNavigationHandler(NavigationHandler handler) {
        this.navigationHandler = handler;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        java.awt.Color primaryBlue = new java.awt.Color(52, 152, 219);
        java.awt.Color sidebarBlue = new java.awt.Color(44, 62, 80);
        java.awt.Color lightGray = new java.awt.Color(236, 240, 241);
        java.awt.Color white = new java.awt.Color(255, 255, 255);
        java.awt.Color textDark = new java.awt.Color(44, 62, 80);
        java.awt.Color textLight = new java.awt.Color(236, 240, 241);

        jPanel2 = new javax.swing.JPanel();
        leaveBalanceBar = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        leaveBalanceLabel = new javax.swing.JLabel();
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

        setPreferredSize(new java.awt.Dimension(800, 500));
        setBackground(lightGray);

        jPanel2.setBackground(white);
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 195, 199), 1),
            javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16));
        jLabel3.setForeground(textDark);
        jLabel3.setText("Leave Balance");

        leaveBalanceLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        leaveBalanceLabel.setForeground(primaryBlue);
        leaveBalanceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leaveBalanceLabel.setText("10 / 20");

        leaveBalanceBar.setFont(new java.awt.Font("Segoe UI", 0, 12));
        leaveBalanceBar.setForeground(primaryBlue);
        leaveBalanceBar.setBackground(new java.awt.Color(189, 195, 199));
        leaveBalanceBar.setStringPainted(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(leaveBalanceBar, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(leaveBalanceLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(leaveBalanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(leaveBalanceBar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 28));
        titleLabel.setForeground(textDark);
        titleLabel.setText("Welcome back,");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(titleLabel)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
    }

    private javax.swing.JLabel dashboardLabel;
    private javax.swing.JLabel employeeIdLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar leaveBalanceBar;
    private javax.swing.JLabel leaveBalanceLabel;
    private javax.swing.JLabel manageLeavesLabel;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JLabel profileSectionLabel;
    private javax.swing.JLabel titleLabel;

    public void setTitle(String title) {
        titleLabel.setText(title);
    }
    
    public void setLeaveBalanceLabel(String label) {
        leaveBalanceLabel.setText(label);
    }
    
    public void setEmployeeIdLabel(String employeeId) {
        employeeIdLabel.setText(employeeId);
    }
    
    public void setLeaveBalanceBar(int minimum, int maximum, int balance) {
        leaveBalanceBar.setMinimum(minimum);
        leaveBalanceBar.setMaximum(maximum);
        leaveBalanceBar.setValue(balance);
    }

    public String getTitle() {
        return titleLabel.getText();
    }

    public String getEmployeeId() {
        return employeeIdLabel.getText();
    }

    public void setFirstName(String firstName) {
        String title = titleLabel.getText();
        if (title.startsWith("Welcome back, ")) {
            this.currentFirstName = firstName;
        }
    }

    public String getFirstName() {
        String title = titleLabel.getText();
        if (title.startsWith("Welcome back, ")) {
            return title.substring("Welcome back, ".length());
        }
        return "";
    }

    public String getLastName() {
        return "";
    }

    public String getIcPassport() {
        return "";
    }

    public void setEmployeeData(Employee employee) {
        if (employee != null) {
            setTitle("Welcome back, " + employee.getFirstName());
            setLeaveBalanceLabel(employee.getLeaveBalance() + " / 20");
            setLeaveBalanceBar(0, 20, employee.getLeaveBalance());
            setEmployeeIdLabel(String.valueOf(employee.getEmployeeId()));
            this.currentEmployee = employee;
        }
    }

    private Employee currentEmployee;
    private String currentFirstName;
}
