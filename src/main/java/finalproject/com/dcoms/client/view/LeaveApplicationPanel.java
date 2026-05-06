package finalproject.com.dcoms.client.view;

public class LeaveApplicationPanel extends javax.swing.JPanel {

    public interface SubmitHandler {

        void onSubmit(String leaveType, String startDate, String endDate);
    }

    private SubmitHandler submitHandler;
    private final String[] VALID_LEAVE_TYPES = {
        "Annual Leave", "Sick Leave", "Unpaid Leave", "Emergency Leave"
    };

    public LeaveApplicationPanel() {
        initComponents();
        setupPlaceholders();
    }

    private void setupPlaceholders() {
        final String dateHint = "DD-MM-YYYY";

        startDateField.setForeground(java.awt.Color.GRAY);
        startDateField.setText(dateHint);
        startDateField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (startDateField.getText().equals(dateHint)) {
                    startDateField.setText("");
                    startDateField.setForeground(java.awt.Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (startDateField.getText().trim().isEmpty()) {
                    startDateField.setText(dateHint);
                    startDateField.setForeground(java.awt.Color.GRAY);
                }
            }
        });

        endDateField.setForeground(java.awt.Color.GRAY);
        endDateField.setText(dateHint);
        endDateField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (endDateField.getText().equals(dateHint)) {
                    endDateField.setText("");
                    endDateField.setForeground(java.awt.Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (endDateField.getText().trim().isEmpty()) {
                    endDateField.setText(dateHint);
                    endDateField.setForeground(java.awt.Color.GRAY);
                }
            }
        });
    }

    public void setSubmitHandler(SubmitHandler handler) {
        this.submitHandler = handler;
    }

    public String getLeaveType() {
        Object selected = leaveTypeComboBox.getSelectedItem();
        return selected != null ? selected.toString() : "";
    }

    public String getStartDate() {
        String text = startDateField.getText().trim();
        return "DD-MM-YYYY".equals(text) ? "" : text;
    }

    public String getEndDate() {
        String text = endDateField.getText().trim();
        return "DD-MM-YYYY".equals(text) ? "" : text;
    }

    public void setLeaveType(String leaveType) {
        leaveTypeComboBox.setSelectedItem(leaveType);
    }

    public void setStartDate(String startDate) {
        startDateField.setText(startDate);
        startDateField.setForeground(java.awt.Color.BLACK);
    }

    public void setEndDate(String endDate) {
        endDateField.setText(endDate);
        endDateField.setForeground(java.awt.Color.BLACK);
    }

    public void clearFields() {
        leaveTypeComboBox.setSelectedIndex(-1);
        String dateHint = "DD-MM-YYYY";
        startDateField.setText(dateHint);
        startDateField.setForeground(java.awt.Color.GRAY);
        endDateField.setText(dateHint);
        endDateField.setForeground(java.awt.Color.GRAY);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        leaveTypeLabel = new javax.swing.JLabel();
        leaveTypeField = new javax.swing.JTextField();
        startDateField = new javax.swing.JFormattedTextField();
        startDateLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        endDateField = new javax.swing.JFormattedTextField();
        leaveTypeLabel3 = new javax.swing.JLabel();
        applyButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        leaveTypeComboBox = new javax.swing.JComboBox<>();

        leaveTypeLabel.setText("Leave Type");

        leaveTypeField.setEnabled(false);
        leaveTypeField.setVisible(false);
        leaveTypeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveTypeFieldActionPerformed(evt);
            }
        });

        startDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateFieldActionPerformed(evt);
            }
        });

        startDateLabel.setText("Start Date");

        endDateLabel.setText("End Date");

        endDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateFieldActionPerformed(evt);
            }
        });

        leaveTypeLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24));
        leaveTypeLabel3.setText("Leave Application");

        applyButton.setText("Apply");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        leaveTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Annual Leave", "Sick Leave", "Unpaid Leave", "Emergency Leave"}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(leaveTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(leaveTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(leaveTypeLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(startDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(27, 27, 27)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(endDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(0, 0, Short.MAX_VALUE))))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(resetButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(applyButton)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(leaveTypeLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(leaveTypeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(leaveTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(endDateLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(startDateLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(applyButton)
                                        .addComponent(resetButton))
                                .addContainerGap())
        );
    }

    private void leaveTypeFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void startDateFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void endDateFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (submitHandler != null) {
            String startDate = getStartDate();
            String endDate = getEndDate();

            // Validate date format
            if (isValidDateFormat(startDate) && isValidDateFormat(endDate)) {
                // Convert to YYYY-MM-DD for database
                String dbStartDate = convertToDatabaseFormat(startDate);
                String dbEndDate = convertToDatabaseFormat(endDate);
                submitHandler.onSubmit(getLeaveType(), dbStartDate, dbEndDate);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Please enter dates in DD-MM-YYYY format\nExample: 18-12-2026",
                        "Invalid Date Format",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String convertToDatabaseFormat(String date) {
        if (date == null || date.isEmpty()) {
            return date;
        }
        String[] parts = date.split("-");
        return parts[2] + "-" + parts[1] + "-" + parts[0];
    }

    private boolean isValidDateFormat(String date) {
        if (date == null || date.isEmpty()) {
            return false;
        }
        return date.matches("\\d{2}-\\d{2}-\\d{4}");
    }

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {
        clearFields();
    }

    private javax.swing.JButton applyButton;
    private javax.swing.JComboBox<String> leaveTypeComboBox;
    private javax.swing.JTextField leaveTypeField;
    private javax.swing.JLabel leaveTypeLabel;
    private javax.swing.JLabel leaveTypeLabel3;
    private javax.swing.JButton resetButton;
    private javax.swing.JFormattedTextField endDateField;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JFormattedTextField startDateField;
    private javax.swing.JLabel startDateLabel;
}
