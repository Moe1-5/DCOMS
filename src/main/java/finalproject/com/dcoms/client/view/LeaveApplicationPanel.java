package finalproject.com.dcoms.client.view;

public class LeaveApplicationPanel extends javax.swing.JPanel {

    public interface SubmitHandler {
        void onSubmit(String leaveType, String startDate, String endDate);
    }

    private SubmitHandler submitHandler;

    public LeaveApplicationPanel() {
        initComponents();
        setupPlaceholders();
        applyDateFilter(startDateField);
        applyDateFilter(endDateField);
    }

    private void applyDateFilter(javax.swing.JFormattedTextField field) {
        ((javax.swing.text.AbstractDocument) field.getDocument())
            .setDocumentFilter(new javax.swing.text.DocumentFilter() {
                @Override
                public void insertString(FilterBypass fb, int offset, String text,
                        javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
                    replace(fb, offset, 0, text, attr);
                }

                @Override
                public void replace(FilterBypass fb, int offset, int length, String text,
                        javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
                    if (!text.matches("[0-9]*")) return;
                    String current = fb.getDocument().getText(0, fb.getDocument().getLength());
                    String digitsOnly = current.replace("-", "").substring(0, offset - countDashes(current, offset)) + text;
                    if (digitsOnly.replace("-", "").length() > 8) return;
                    super.replace(fb, offset, length, text, attr);
                    String doc = fb.getDocument().getText(0, fb.getDocument().getLength());
                    String digits = doc.replace("-", "");
                    if (digits.length() == 2 && doc.length() == 2) {
                        super.insertString(fb, fb.getDocument().getLength(), "-", attr);
                    } else if (digits.length() == 4 && doc.length() == 5) {
                        super.insertString(fb, fb.getDocument().getLength(), "-", attr);
                    }
                }

                private int countDashes(String s, int upTo) {
                    int count = 0;
                    for (int i = 0; i < Math.min(upTo, s.length()); i++) {
                        if (s.charAt(i) == '-') count++;
                    }
                    return count;
                }
            });
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
        leaveTypeComboBox.setSelectedIndex(0);
        String dateHint = "DD-MM-YYYY";
        startDateField.setText(dateHint);
        startDateField.setForeground(java.awt.Color.GRAY);
        endDateField.setText(dateHint);
        endDateField.setForeground(java.awt.Color.GRAY);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        java.awt.Color primaryBlue = new java.awt.Color(52, 152, 219);
        java.awt.Color lightGray = new java.awt.Color(236, 240, 241);
        java.awt.Color white = new java.awt.Color(255, 255, 255);
        java.awt.Color textDark = new java.awt.Color(44, 62, 80);
        java.awt.Color labelGray = new java.awt.Color(127, 140, 141);
        java.awt.Color borderGray = new java.awt.Color(189, 195, 199);

        titleLabel = new javax.swing.JLabel();
        leaveTypeLabel = new javax.swing.JLabel();
        leaveTypeComboBox = new javax.swing.JComboBox<>();
        startDateLabel = new javax.swing.JLabel();
        startDateField = new javax.swing.JFormattedTextField();
        endDateLabel = new javax.swing.JLabel();
        endDateField = new javax.swing.JFormattedTextField();
        applyButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(450, 450));
        setBackground(lightGray);

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 28));
        titleLabel.setForeground(textDark);
        titleLabel.setText("Leave Application");

        leaveTypeLabel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        leaveTypeLabel.setForeground(labelGray);
        leaveTypeLabel.setText("Leave Type");

        leaveTypeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14));
        leaveTypeComboBox.setForeground(textDark);
        leaveTypeComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(borderGray, 1));
        leaveTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"Annual Leave", "Sick Leave", "Unpaid Leave", "Emergency Leave"}
        ));

        startDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        startDateLabel.setForeground(labelGray);
        startDateLabel.setText("Start Date");

        startDateField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        startDateField.setForeground(textDark);
        startDateField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(borderGray, 1),
            javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));

        endDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        endDateLabel.setForeground(labelGray);
        endDateLabel.setText("End Date");

        endDateField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        endDateField.setForeground(textDark);
        endDateField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(borderGray, 1),
            javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)));

        applyButton.setFont(new java.awt.Font("Segoe UI", 1, 13));
        applyButton.setBackground(primaryBlue);
        applyButton.setForeground(white);
        applyButton.setText("Apply");
        applyButton.setFocusPainted(false);
        applyButton.setBorderPainted(false);
        applyButton.setOpaque(true);
        applyButton.addActionListener(e -> {
            if (submitHandler != null) {
                String startDate = getStartDate();
                String endDate = getEndDate();
                String normalizedStart = normalizeDate(startDate);
                String normalizedEnd = normalizeDate(endDate);
                if (normalizedStart != null && normalizedEnd != null) {
                    String dbStart = convertToDatabaseFormat(normalizedStart);
                    String dbEnd = convertToDatabaseFormat(normalizedEnd);
                    submitHandler.onSubmit(getLeaveType(), dbStart, dbEnd);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this,
                        "Please enter dates in DD-MM-YYYY format\nExample: 18-12-2026",
                        "Invalid Date Format",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addComponent(leaveTypeLabel)
                    .addComponent(leaveTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startDateLabel)
                            .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(endDateLabel)
                            .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(titleLabel)
                .addGap(25, 25, 25)
                .addComponent(leaveTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(leaveTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(endDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }

    private String convertToDatabaseFormat(String date) {
        if (date == null || date.isEmpty()) return date;
        String[] parts = date.split("-");
        return parts[2] + "-" + parts[1] + "-" + parts[0];
    }

    private String normalizeDate(String date) {
        if (date == null || date.isEmpty()) return null;
        if (!date.matches("\\d{1,2}-\\d{1,2}-\\d{4}")) return null;
        String[] parts = date.split("-");
        return String.format("%02d", Integer.parseInt(parts[0])) + "-"
             + String.format("%02d", Integer.parseInt(parts[1])) + "-"
             + parts[2];
    }

    private javax.swing.JButton applyButton;
    private javax.swing.JComboBox<String> leaveTypeComboBox;
    private javax.swing.JLabel leaveTypeLabel;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JFormattedTextField startDateField;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JFormattedTextField endDateField;
    private javax.swing.JLabel titleLabel;
}