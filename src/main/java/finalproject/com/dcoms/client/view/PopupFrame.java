package finalproject.com.dcoms.client.view;

import java.awt.CardLayout;
import java.awt.Frame;

public class PopupFrame extends javax.swing.JDialog {

    public PopupFrame(Frame parent) {
        super(parent, true);
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        parentPanel = new javax.swing.JPanel();
        employeePersonalDetails2 = new finalproject.com.dcoms.client.view.EmployeePersonalDetails();
        leaveApplicationPanel1 = new finalproject.com.dcoms.client.view.LeaveApplicationPanel();

        parentPanel.setLayout(new java.awt.CardLayout());
        parentPanel.add(employeePersonalDetails2, "personalDetails");
        parentPanel.add(leaveApplicationPanel1, "leaveApplication");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
    }

    public void showPersonalDetails() {
        CardLayout layout = (CardLayout) parentPanel.getLayout();
        layout.show(parentPanel, "personalDetails");
    }

    public void showLeaveApplication() {
        CardLayout layout = (CardLayout) parentPanel.getLayout();
        layout.show(parentPanel, "leaveApplication");
    }

    public EmployeePersonalDetails getEmployeePersonalDetails() {
        return employeePersonalDetails2;
    }

    public LeaveApplicationPanel getLeaveApplicationPanel() {
        return leaveApplicationPanel1;
    }

    private finalproject.com.dcoms.client.view.EmployeePersonalDetails employeePersonalDetails2;
    private finalproject.com.dcoms.client.view.LeaveApplicationPanel leaveApplicationPanel1;
    private javax.swing.JPanel parentPanel;
}