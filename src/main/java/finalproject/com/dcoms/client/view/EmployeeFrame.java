package finalproject.com.dcoms.client.view;

import finalproject.com.dcoms.client.controller.EmployeeController;
import finalproject.com.dcoms.client.model.Employee;

import java.awt.CardLayout;
import java.util.List;

public class EmployeeFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EmployeeFrame.class.getName());

    private EmployeeController controller;
    private String currentEmployeeId;
    private PopupFrame popupFrame;
    private Employee currentEmployee;
    
    public EmployeeFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        popupFrame = new PopupFrame();
        popupFrame.setLocationRelativeTo(this);
    }
    
    public void setController(EmployeeController controller) {
        this.controller = controller;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        parentPanel = new javax.swing.JPanel();
        loadingPanel = new finalproject.com.dcoms.client.view.LoadingPanel();
        employeeDashboardPanel = new finalproject.com.dcoms.client.view.EmployeeDashboard();
        manageLeavesPanel = new finalproject.com.dcoms.client.view.ManageLeavesPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);

        parentPanel.setLayout(new java.awt.CardLayout());
        parentPanel.add(loadingPanel, "loading");
        parentPanel.add(employeeDashboardPanel, "dashboard");
        parentPanel.add(manageLeavesPanel, "manageLeaves");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parentPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public void showDashboard() {
        CardLayout layout = (CardLayout) parentPanel.getLayout();
        layout.show(parentPanel, "dashboard");
        employeeDashboardPanel.requestFocusInWindow();
    }

    public void showManageLeaves() {
        CardLayout layout = (CardLayout) parentPanel.getLayout();
        layout.show(parentPanel, "manageLeaves");
        if (currentEmployeeId != null) {
            controller.loadLeaveHistory(currentEmployeeId);
        }
        manageLeavesPanel.requestFocusInWindow();
    }

    public void showProfilePopup() {
        popupFrame.showPersonalDetails();
        EmployeePersonalDetails panel = popupFrame.getEmployeePersonalDetails();
        panel.setSaveHandler(new EmployeePersonalDetails.SaveHandler() {
            @Override
            public void onSave(String firstName, String lastName, String icPassport, String spouseName, int children) {
                controller.updateEmployeeDetails(currentEmployeeId, firstName, lastName, icPassport, spouseName, children);
                panel.exitEditMode();
            }
        });
        if (currentEmployeeId != null) {
            controller.loadFamilyDetails(currentEmployeeId);
        }
        popupFrame.setVisible(true);
        popupFrame.toFront();
    }

    public void showLeaveApplicationPopup() {
        popupFrame.showLeaveApplication();
        popupFrame.getLeaveApplicationPanel().clearFields();
        popupFrame.getLeaveApplicationPanel().setSubmitHandler(new LeaveApplicationPanel.SubmitHandler() {
            @Override
            public void onSubmit(String leaveType, String startDate, String endDate) {
                // Dates are already in YYYY-MM-DD format from LeaveApplicationPanel
                if (startDate == null || startDate.isEmpty() || endDate == null || endDate.isEmpty()) {
                    System.out.println("Invalid date format. Please use DD-MM-YYYY");
                    return;
                }
                if (leaveType == null || leaveType.isEmpty()) {
                    System.out.println("Leave type cannot be empty");
                    return;
                }
                String leaveId = generateLeaveId();
                System.out.println("Applying leave: " + leaveId + " for " + currentEmployeeId + " type=" + leaveType + " from=" + startDate + " to=" + endDate);
                controller.applyLeave(leaveId, currentEmployeeId, leaveType, startDate, endDate);
                popupFrame.setVisible(false);
            }
        });
        popupFrame.setVisible(true);
        popupFrame.toFront();
    }

    private int leaveIdCounter = 0;
    private String generateLeaveId() {
        leaveIdCounter++;
        long timestamp = System.currentTimeMillis() % 10000;
        return String.format("L%03d%d", leaveIdCounter, timestamp);
    }

    private String convertDateToISO(String date) {
        if (date == null || date.isEmpty()) return null;
        try {
            String[] parts = date.split("-");
            if (parts.length == 3) {
                String day = parts[0];
                String month = parts[1];
                String year = parts[2];
                return year + "-" + month + "-" + day;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void onLeaveApplied() {
        if (currentEmployeeId != null) {
            controller.loadLeaveHistory(currentEmployeeId);
        }
    }

    public void onEmployeeDetailsUpdated() {
        controller.loadEmployee(currentEmployeeId);
    }

    public void setDashboardDetails(Employee employee) {
        if (employee == null) return;
        
        currentEmployee = employee;
        currentEmployeeId = employee.getEmployeeId();
        
        employeeDashboardPanel.setTitle("Welcome back, " + employee.getFirstName());
        employeeDashboardPanel.setLeaveBalanceLabel(employee.getLeaveBalance() + " / 20");
        employeeDashboardPanel.setLeaveBalanceBar(0, 20, employee.getLeaveBalance());
        employeeDashboardPanel.setEmployeeIdLabel(String.valueOf(employee.getEmployeeId()));
        
        manageLeavesPanel.setEmployeeIdLabel(String.valueOf(employee.getEmployeeId()));
        
        employeeDashboardPanel.setNavigationHandler(new EmployeeDashboard.NavigationHandler() {
            @Override
            public void onDashboardClicked() {
                showDashboard();
            }

            @Override
            public void onManageLeavesClicked() {
                showManageLeaves();
            }

            @Override
            public void onProfileClicked() {
                showProfilePopup();
            }
        });
        
        manageLeavesPanel.setNavigationHandler(new ManageLeavesPanel.NavigationHandler() {
            @Override
            public void onDashboardClicked() {
                showDashboard();
            }

            @Override
            public void onManageLeavesClicked() {
                showManageLeaves();
            }

            @Override
            public void onProfileClicked() {
                showProfilePopup();
            }

            @Override
            public void onApplyLeaveClicked() {
                showLeaveApplicationPopup();
            }
        });
        
        loadingPanel.setVisible(false);
        employeeDashboardPanel.setVisible(true);
        manageLeavesPanel.setVisible(false);
    }

    public void setPersonalDetails(String[] familyDetails) {
        EmployeePersonalDetails panel = popupFrame.getEmployeePersonalDetails();
        panel.setFirstNameField(currentEmployee.getFirstName());
        panel.setLastNameField(currentEmployee.getLastName());
        panel.setPassportField(currentEmployee.getIcPassport());
        
        if (familyDetails != null && familyDetails.length >= 2) {
            panel.setSpouseNameField(familyDetails[0]);
            panel.setChildrenSpinner(Integer.parseInt(familyDetails[1]));
        } else {
            panel.setSpouseNameField("");
            panel.setChildrenSpinner(0);
        }
    }

    public void setLeaveHistory(List<String[]> history) {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) manageLeavesPanel.getLeaveHistoryTable().getModel();
        model.setRowCount(0);
        
        if (history != null) {
            for (String[] row : history) {
                if (row != null && row.length >= 5) {
                    String leaveType = row[1];
                    String startDate = row[2];
                    String endDate = row[3];
                    String status = row[4];
                    
                    int duration = 0;
                    try {
                        java.time.LocalDate start = java.time.LocalDate.parse(startDate);
                        java.time.LocalDate end = java.time.LocalDate.parse(endDate);
                        duration = (int) java.time.temporal.ChronoUnit.DAYS.between(start, end) + 1;
                    } catch (Exception e) {
                        duration = 0;
                    }
                    
                    model.addRow(new Object[]{leaveType, startDate, endDate, duration, status});
                }
            }
        }
    }

    private finalproject.com.dcoms.client.view.LoadingPanel loadingPanel;
    private finalproject.com.dcoms.client.view.EmployeeDashboard employeeDashboardPanel;
    private finalproject.com.dcoms.client.view.ManageLeavesPanel manageLeavesPanel;
    private javax.swing.JPanel parentPanel;
}
