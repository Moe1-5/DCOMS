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

        profilePictureLabel = new javax.swing.JLabel(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avatar.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)))
        ;
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
        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });

        lastNameLabel.setText("Last Name");

        lastNameField.setEnabled(false);
        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });

        passportLabel.setText("IC/Passport");

        passportField.setEnabled(false);
        passportField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passportFieldActionPerformed(evt);
            }
        });

        personalDetailsLabel.setText("Personal Details");

        familyDetailsLabel.setText("Family Details");

        spouseNameLabel.setText("Spouse Name");

        spouseNameField.setEnabled(false);
        spouseNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spouseNameFieldActionPerformed(evt);
            }
        });

        childrenLabel.setText("Children");

        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(profilePictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passportField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(personalDetailsLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(familyDetailsLabel)
                                    .addComponent(spouseNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(90, 90, 90)
                                .addComponent(childrenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spouseNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(childrenSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(confirmButton))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(profilePictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editButton)))
                .addGap(17, 17, 17)
                .addComponent(personalDetailsLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lastNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passportLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passportField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(familyDetailsLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spouseNameLabel)
                    .addComponent(childrenLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spouseNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(childrenSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmButton))
                .addContainerGap(28, Short.MAX_VALUE))
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
