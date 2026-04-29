package finalproject.com.dcoms.client.view;

public class PopupFrame extends javax.swing.JFrame {

    public PopupFrame() {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        parentPanel = new javax.swing.JPanel();
        employeePersonalDetails2 = new finalproject.com.dcoms.client.view.EmployeePersonalDetails();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        parentPanel.setLayout(new java.awt.CardLayout());
        parentPanel.add(employeePersonalDetails2, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public EmployeePersonalDetails getEmployeePersonalDetails() {
        return employeePersonalDetails2;
    }

    private finalproject.com.dcoms.client.view.EmployeePersonalDetails employeePersonalDetails2;
    private javax.swing.JPanel parentPanel;
}
