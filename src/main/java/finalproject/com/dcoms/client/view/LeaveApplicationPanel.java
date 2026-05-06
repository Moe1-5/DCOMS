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

        java.awt.Color primaryBlue = new java.awt.Color(52, 152, 219);
        java.awt.Color sidebarBlue = new java.awt.Color(44, 62, 80);
        java.awt.Color lightGray = new java.awt.Color(236, 240, 241);
        java.awt.Color white = new java.awt.Color(255, 255, 255);
        java.awt.Color textDark = new java.awt.Color(44, 62, 80);
        java.awt.Color textLight = new java.awt.Color(236, 240, 241);
        java.awt.Color labelGray = new java.awt.Color(127, 140, 141);
        java.awt.Color borderGray = new java.awt.Color(189, 195, 199);

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

        setPreferredSize(new java.awt.Dimension(420, 450));
        setBackground(lightGray);

        leaveTypeLabel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        leaveTypeLabel.setForeground(labelGray);
        leaveTypeLabel.setText("Leave Type");

        leaveTypeField.setEnabled(false);
        leaveTypeField.setVisible(false);
        leaveTypeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveTypeFieldActionPerformed(evt);
            }
        });

        startDateField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        startDateField.setForeground(textDark);
        startDateField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(borderGray, 1),
                javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        startDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateFieldActionPerformed(evt);
            }
        });

        startDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        startDateLabel.setForeground(labelGray);
        startDateLabel.setText("Start Date");

        endDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        endDateLabel.setForeground(labelGray);
        endDateLabel.setText("End Date");

        endDateField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        endDateField.setForeground(textDark);
        endDateField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(borderGray, 1),
                javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));
        endDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateFieldActionPerformed(evt);
            }
        });

        leaveTypeLabel3.setFont(new java.awt.Font("Segoe UI", 1, 28));
        leaveTypeLabel3.setForeground(textDark);
        leaveTypeLabel3.setText("Leave Application");

        applyButton.setFont(new java.awt.Font("Segoe UI", 1, 13));
        applyButton.setBackground(primaryBlue);
        applyButton.setForeground(white);
        applyButton.setText("Apply");
        applyButton.setFocusPainted(false);
        applyButton.setBorderPainted(false);
        applyButton.setOpaque(true);
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        resetButton.setFont(new java.awt.Font("Segoe UI", 0, 13));
        resetButton.setBackground(white);
        resetButton.setForeground(textDark);
        resetButton.setText("Reset");
        resetButton.setFocusPainted(false);
        resetButton.setBorder(javax.swing.BorderFactory.createLineBorder(borderGray, 1));
        resetButton.setOpaque(true);
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        leaveTypeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14));
        leaveTypeComboBox.setForeground(textDark);
        leaveTypeComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(borderGray, 1));
        leaveTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Annual Leave", "Sick Leave", "Unpaid Leave", "Emergency Leave"}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(leaveTypeLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(startDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(endDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(leaveTypeLabel)
                                                        .addComponent(leaveTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(leaveTypeLabel3)
                                .addGap(30, 30, 30)
                                .addComponent(leaveTypeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(leaveTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(endDateLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(startDateLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
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

            // Validate and normalize date format (allows 1-2-2027 or 01-02-2027)
            String normalizedStart = normalizeDate(startDate);
            String normalizedEnd = normalizeDate(endDate);
            
            if (normalizedStart != null && normalizedEnd != null) {
                // Convert to YYYY-MM-DD for database
                String dbStartDate = convertToDatabaseFormat(normalizedStart);
                String dbEndDate = convertToDatabaseFormat(normalizedEnd);
                submitHandler.onSubmit(getLeaveType(), dbStartDate, dbEndDate);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Please enter dates in DD-MM-YYYY format\nExample: 18-12-2026 or 1-12-2026",
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

    private String normalizeDate(String date) {
        if (date == null || date.isEmpty()) {
            return null;
        }
        // Allow 1-2-2027, 01-2-2027, 1-02-2027, 01-02-2027
        if (!date.matches("\\d{1,2}-\\d{1,2}-\\d{4}")) {
            return null;
        }
        String[] parts = date.split("-");
        String day = String.format("%02d", Integer.parseInt(parts[0]));
        String month = String.format("%02d", Integer.parseInt(parts[1]));
        String year = parts[2];
        return day + "-" + month + "-" + year;
    }

    private boolean isValidDateFormat(String date) {
        if (date == null || date.isEmpty()) {
            return false;
        }
        // Allow flexible format: 1-2-2027 or 01-02-2027
        return date.matches("\\d{1,2}-\\d{1,2}-\\d{4}");
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
