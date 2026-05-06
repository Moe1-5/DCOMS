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

        profilePictureLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        firstNameLabel.setText("First Name");
        firstNameField.setEnabled(false);
        firstNameField.addActionListener(evt -> firstNameFieldActionPerformed(evt));

        lastNameLabel.setText("Last Name");
        lastNameField.setEnabled(false);
        lastNameField.addActionListener(evt -> lastNameFieldActionPerformed(evt));

        passportLabel.setText("IC/Passport");
        passportField.setEnabled(false);
        passportField.addActionListener(evt -> passportFieldActionPerformed(evt));

        personalDetailsLabel.setText("Personal Details");
        familyDetailsLabel.setText("Family Details");

        spouseNameLabel.setText("Spouse Name");
        spouseNameField.setEnabled(false);
        spouseNameField.addActionListener(evt -> spouseNameFieldActionPerformed(evt));

        childrenLabel.setText("Children");

        confirmButton.setText("Confirm");
        confirmButton.addActionListener(evt -> confirmButtonActionPerformed(evt));

        editButton.setText("Edit");
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
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lastNameLabel)
                                        .addComponent(lastNameField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        // Row 4 – IC/Passport field (single column)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(passportLabel)
                                .addComponent(passportField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        // Row 5 – "Family Details" section label
                        .addComponent(familyDetailsLabel)
                        // Row 6 – Spouse Name field + Children spinner
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(spouseNameLabel)
                                        .addComponent(spouseNameField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(childrenLabel)
                                        .addComponent(childrenSpinner,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        // Row 7 – Confirm button (right-aligned)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup()
                                        .addComponent(confirmButton,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 90,
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
                                        .addComponent(editButton)))
                        .addGap(18)
                        // Row 2 – "Personal Details" label
                        .addComponent(personalDetailsLabel)
                        .addGap(10)
                        // Row 3 – First Name + Last Name labels then fields
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(firstNameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(firstNameField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(lastNameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lastNameField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10)
                        // Row 4 – IC/Passport label + field
                        .addComponent(passportLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passportField,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18)
                        // Row 5 – "Family Details" label
                        .addComponent(familyDetailsLabel)
                        .addGap(10)
                        // Row 6 – Spouse Name + Children labels then fields/spinner
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spouseNameLabel)
                                .addComponent(childrenLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spouseNameField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(childrenSpinner,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        // Row 7 – Confirm button
                        .addComponent(confirmButton)
                        .addContainerGap(18, Short.MAX_VALUE)
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
