package finalproject.com.dcoms.client.view;

public class EmployeePersonalDetails extends javax.swing.JPanel {

    public interface SaveHandler {

        void onSave(String firstName, String lastName, String icPassport, String spouseName, int children);
    }

    private SaveHandler saveHandler;
    private boolean editMode = false;

    public EmployeePersonalDetails() {
        initComponents();
        confirmButton.setVisible(false);
        childrenSpinner.setEnabled(false);
    }

    public void setSaveHandler(SaveHandler handler) {
        this.saveHandler = handler;
    }

    private void setFieldsEditable(boolean editable) {
        firstNameField.setEnabled(editable);
        lastNameField.setEnabled(editable);
        passportField.setEnabled(editable);
        spouseNameField.setEnabled(editable);
        childrenSpinner.setEnabled(editable);
    }

    private void enterEditMode() {
        editMode = true;
        setFieldsEditable(true);
        confirmButton.setVisible(true);
        editButton.setText("Cancel");
    }

    public void exitEditMode() {
        editMode = false;
        setFieldsEditable(false);
        confirmButton.setVisible(false);
        editButton.setText("Edit");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        java.awt.Color primaryBlue = new java.awt.Color(52, 152, 219);
        java.awt.Color sidebarBlue = new java.awt.Color(44, 62, 80);
        java.awt.Color lightGray = new java.awt.Color(236, 240, 241);
        java.awt.Color white = new java.awt.Color(255, 255, 255);
        java.awt.Color textDark = new java.awt.Color(44, 62, 80);
        java.awt.Color textLight = new java.awt.Color(236, 240, 241);
        java.awt.Color labelGray = new java.awt.Color(127, 140, 141);
        java.awt.Color borderGray = new java.awt.Color(189, 195, 199);

        profilePictureLabel = new javax.swing.JLabel(
                new javax.swing.ImageIcon(
                        new javax.swing.ImageIcon(getClass().getResource("/images/avatar.png"))
                                .getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)
                )
        );
        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        passportLabel = new javax.swing.JLabel();
        passportField = new javax.swing.JTextField();
        personalDetailsLabel = new javax.swing.JLabel();
        familyDetailsLabel = new javax.swing.JLabel();
        spouseNameLabel = new javax.swing.JLabel();
        spouseNameField = new javax.swing.JTextField();
        childrenSpinner = new javax.swing.JSpinner();
        childrenLabel = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(420, 480));
        setBackground(lightGray);

        profilePictureLabel.setBorder(javax.swing.BorderFactory.createLineBorder(white, 3));
        profilePictureLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        firstNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        firstNameLabel.setForeground(labelGray);
        firstNameLabel.setText("First Name");
        firstNameField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        firstNameField.setForeground(textDark);
        firstNameField.setEnabled(false);
        firstNameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(borderGray, 1),
                javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        firstNameField.addActionListener(evt -> firstNameFieldActionPerformed(evt));

        lastNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lastNameLabel.setForeground(labelGray);
        lastNameLabel.setText("Last Name");
        lastNameField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lastNameField.setForeground(textDark);
        lastNameField.setEnabled(false);
        lastNameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(borderGray, 1),
                javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        lastNameField.addActionListener(evt -> lastNameFieldActionPerformed(evt));

        passportLabel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        passportLabel.setForeground(labelGray);
        passportLabel.setText("IC / Passport");
        passportField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        passportField.setForeground(textDark);
        passportField.setEnabled(false);
        passportField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(borderGray, 1),
                javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        passportField.addActionListener(evt -> passportFieldActionPerformed(evt));

        personalDetailsLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        personalDetailsLabel.setForeground(primaryBlue);
        personalDetailsLabel.setText("Personal Details");

        familyDetailsLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        familyDetailsLabel.setForeground(primaryBlue);
        familyDetailsLabel.setText("Family Details");

        spouseNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        spouseNameLabel.setForeground(labelGray);
        spouseNameLabel.setText("Spouse Name");
        spouseNameField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        spouseNameField.setForeground(textDark);
        spouseNameField.setEnabled(false);
        spouseNameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(borderGray, 1),
                javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        spouseNameField.addActionListener(evt -> spouseNameFieldActionPerformed(evt));

        childrenLabel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        childrenLabel.setForeground(labelGray);
        childrenLabel.setText("Children");

        confirmButton.setFont(new java.awt.Font("Segoe UI", 1, 13));
        confirmButton.setBackground(primaryBlue);
        confirmButton.setForeground(white);
        confirmButton.setText("Confirm");
        confirmButton.setFocusPainted(false);
        confirmButton.setBorderPainted(false);
        confirmButton.setOpaque(true);
        confirmButton.addActionListener(evt -> confirmButtonActionPerformed(evt));

        editButton.setFont(new java.awt.Font("Segoe UI", 0, 13));
        editButton.setBackground(white);
        editButton.setForeground(textDark);
        editButton.setText("Edit");
        editButton.setFocusPainted(false);
        editButton.setBorder(javax.swing.BorderFactory.createLineBorder(borderGray, 1));
        editButton.setOpaque(true);
        editButton.addActionListener(evt -> editButtonActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // ── Horizontal ──────────────────────────────────────────────────────
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        // Row 1 – avatar (left) + Edit button (right)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(profilePictureLabel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editButton,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        // Row 2 – "Personal Details" section label
                        .addComponent(personalDetailsLabel)
                        // Row 3 – First Name field + Last Name field
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(firstNameLabel)
                                        .addComponent(firstNameField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 180,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lastNameLabel)
                                        .addComponent(lastNameField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 180,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        // Row 4 – IC/Passport field (single column)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(passportLabel)
                                .addComponent(passportField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 180,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        // Row 5 – "Family Details" section label
                        .addComponent(familyDetailsLabel)
                        // Row 6 – Spouse Name field + Children spinner
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(spouseNameLabel)
                                        .addComponent(spouseNameField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 180,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(childrenLabel)
                                        .addComponent(childrenSpinner,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                80,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        // Row 7 – Confirm button (right-aligned)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup()
                                        .addComponent(confirmButton,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        // ── Vertical ────────────────────────────────────────────────────────
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        // Row 1 – avatar + Edit button (baseline-aligned)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(profilePictureLabel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(35)
                                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25)
                        // Row 2 – "Personal Details" label
                        .addComponent(personalDetailsLabel)
                        .addGap(12)
                        // Row 3 – First Name + Last Name labels then fields
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(firstNameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(firstNameField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(lastNameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lastNameField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12)
                        // Row 4 – IC/Passport label + field
                        .addComponent(passportLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passportField,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25)
                        // Row 5 – "Family Details" label
                        .addComponent(familyDetailsLabel)
                        .addGap(12)
                        // Row 6 – Spouse Name + Children labels then fields/spinner
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spouseNameLabel)
                                .addComponent(childrenLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spouseNameField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(childrenSpinner,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        32,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        // Row 7 – Confirm button
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE)
        );
    }

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void passportFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void spouseNameFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (saveHandler != null) {
            int children = (int) childrenSpinner.getValue();
            saveHandler.onSave(
                    firstNameField.getText().trim(),
                    lastNameField.getText().trim(),
                    passportField.getText().trim(),
                    spouseNameField.getText().trim(),
                    children
            );
        }
    }

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (editMode) {
            exitEditMode();
        } else {
            enterEditMode();
        }
    }

    // ── Component declarations ───────────────────────────────────────────────
    private javax.swing.JLabel childrenLabel;
    private javax.swing.JSpinner childrenSpinner;
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel familyDetailsLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField passportField;
    private javax.swing.JLabel passportLabel;
    private javax.swing.JLabel personalDetailsLabel;
    private javax.swing.JLabel profilePictureLabel;
    private javax.swing.JTextField spouseNameField;
    private javax.swing.JLabel spouseNameLabel;

    // ── Public setters / getters ─────────────────────────────────────────────
    public void setFirstNameField(String firstName) {
        firstNameField.setText(firstName);
    }

    public void setLastNameField(String lastName) {
        lastNameField.setText(lastName);
    }

    public void setPassportField(String passport) {
        passportField.setText(passport);
    }

    public void setSpouseNameField(String spouseName) {
        spouseNameField.setText(spouseName);
    }

    public void setChildrenSpinner(int children) {
        childrenSpinner.setValue(children);
    }

    public String getFirstName() {
        return firstNameField.getText().trim();
    }

    public String getLastName() {
        return lastNameField.getText().trim();
    }

    public String getIcPassport() {
        return passportField.getText().trim();
    }
}
