/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package finalproject.com.dcoms.client.view;

import finalproject.com.dcoms.remote.HRMService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.rmi.Naming;
import java.util.List;
/**
 *
 * @author albad
 */
public class ReportUI extends javax.swing.JFrame {

    private HRMService service;

    // Input fields
    private JTextField txtEmployeeId;
    private JTextField txtYear;
    private JButton btnGenerate;
    private JButton btnClear;

    // Summary labels
    private JLabel lblNameValue;
    private JLabel lblIdValue;
    private JLabel lblBalanceValue;
    private JLabel lblTotalValue;

    // Table
    private JTable reportTable;
    private DefaultTableModel tableModel;

    // Status bar
    private JLabel lblStatus;

    public ReportUI() {
        connectToServer();
        buildUI();
    }
    
    public ReportUI(HRMService service) {
        this.service = service;
        buildUI();
    }
    
    
    // ── Connect to RMI Server ─────────────────────────────
    private void connectToServer() {
        try {
            service = (HRMService) Naming.lookup("rmi://localhost/HRMService");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Could not connect to server.\n" + e.getMessage(),
                "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ── Build UI ──────────────────────────────────────────
    private void buildUI() {
        setTitle("HRM System — Yearly Leave Report");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(buildTopPanel(),     BorderLayout.NORTH);
        add(buildSummaryPanel(), BorderLayout.CENTER);
        add(buildTablePanel(),   BorderLayout.SOUTH);

        setVisible(true);
    }

    // ── Top Panel (inputs) ────────────────────────────────
    private JPanel buildTopPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Generate Yearly Leave Report"));

        JPanel inputRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));

        inputRow.add(new JLabel("Employee ID:"));
        txtEmployeeId = new JTextField(8);
        txtEmployeeId.setFont(new Font("SansSerif", Font.PLAIN, 13));
        inputRow.add(txtEmployeeId);

        inputRow.add(new JLabel("Year:"));
        txtYear = new JTextField(6);
        txtYear.setFont(new Font("SansSerif", Font.PLAIN, 13));
        txtYear.setText(String.valueOf(java.time.Year.now().getValue()));
        inputRow.add(txtYear);

        btnGenerate = new JButton("Generate Report");
        btnGenerate.setBackground(new Color(59, 130, 246));
        btnGenerate.setForeground(Color.WHITE);
        btnGenerate.setFocusPainted(false);
        btnGenerate.addActionListener(e -> generateReport());
        inputRow.add(btnGenerate);

        btnClear = new JButton("Clear");
        btnClear.setFocusPainted(false);
        btnClear.addActionListener(e -> clearAll());
        inputRow.add(btnClear);

        // Status bar
        lblStatus = new JLabel("Ready.");
        lblStatus.setFont(new Font("SansSerif", Font.ITALIC, 11));
        lblStatus.setForeground(Color.GRAY);
        lblStatus.setBorder(BorderFactory.createEmptyBorder(0, 10, 4, 0));

        panel.add(inputRow,   BorderLayout.CENTER);
        panel.add(lblStatus,  BorderLayout.SOUTH);
        return panel;
    }

    // ── Summary Panel (cards) ─────────────────────────────
    private JPanel buildSummaryPanel() {
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBorder(BorderFactory.createTitledBorder("Employee Summary"));

        JPanel cards = new JPanel(new GridLayout(1, 4, 10, 0));
        cards.setBorder(BorderFactory.createEmptyBorder(8, 4, 8, 4));

        lblNameValue    = new JLabel("—", SwingConstants.CENTER);
        lblIdValue      = new JLabel("—", SwingConstants.CENTER);
        lblTotalValue   = new JLabel("—", SwingConstants.CENTER);
        lblBalanceValue = new JLabel("—", SwingConstants.CENTER);

        cards.add(makeCard("Employee Name",    lblNameValue));
        cards.add(makeCard("Employee ID",      lblIdValue));
        cards.add(makeCard("Total Leaves",     lblTotalValue));
        cards.add(makeCard("Leave Balance",    lblBalanceValue));

        wrapper.add(cards, BorderLayout.CENTER);
        return wrapper;
    }

    // ── Table Panel ───────────────────────────────────────
    private JPanel buildTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Leave Records"));
        panel.setPreferredSize(new Dimension(880, 320));

        String[] columns = {"Leave ID", "Leave Type", "Start Date", "End Date"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        reportTable = new JTable(tableModel);
        reportTable.setRowHeight(30);
        reportTable.setFont(new Font("SansSerif", Font.PLAIN, 13));
        reportTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        reportTable.getTableHeader().setReorderingAllowed(false);
        reportTable.setSelectionBackground(new Color(219, 234, 254));
        reportTable.setGridColor(new Color(220, 220, 220));
        reportTable.setShowGrid(true);

        // Center align all columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < columns.length; i++) {
            reportTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Alternate row colors
        reportTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int col) {
                Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, col);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0
                            ? Color.WHITE
                            : new Color(241, 245, 249));
                }
                setHorizontalAlignment(SwingConstants.CENTER);
                return c;
            }
        });

        panel.add(new JScrollPane(reportTable), BorderLayout.CENTER);
        return panel;
    }

    // ── Generate Report ───────────────────────────────────
    private void generateReport() {
        String employeeId = txtEmployeeId.getText().trim().toUpperCase();
        String yearText   = txtYear.getText().trim();

        // Validate inputs
        if (employeeId.isEmpty() || yearText.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Please enter both Employee ID and Year.",
                "Missing Input", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int year;
        try {
            year = Integer.parseInt(yearText);
            if (year < 2000 || year > 2100) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Please enter a valid year (e.g. 2026).",
                "Invalid Year", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            lblStatus.setText("Fetching data...");

            // Fetch employee
            String[] employee = service.getEmployeeById(employeeId);
            if (employee == null) {
                lblStatus.setText("Employee not found.");
                JOptionPane.showMessageDialog(this,
                    "No employee found with ID: " + employeeId,
                    "Not Found", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Fetch leave balance
            int balance = service.getLeaveBalance(employeeId);

            // Fetch leaves for that year
            List<String[]> leaves = service.getLeavesByEmployeeAndYear(employeeId, year);

            // Update summary cards
            lblNameValue.setText(employee[1] + " " + employee[2]);
            lblIdValue.setText(employeeId);
            lblTotalValue.setText(leaves.size() + " leave(s)");
            lblBalanceValue.setText(balance + " day(s)");

            // Fill table
            tableModel.setRowCount(0);
            for (String[] leave : leaves) {
                tableModel.addRow(new Object[]{
                    leave[0],  // leaveId
                    leave[1],  // leaveType
                    leave[2],  // startDate
                    leave[3]   // endDate
                });
            }

            if (leaves.isEmpty()) {
                lblStatus.setText("No leave records found for " + year + ".");
            } else {
                lblStatus.setText("Report generated successfully — "
                        + leaves.size() + " record(s) found for " + year + ".");
            }

        } catch (Exception e) {
            lblStatus.setText("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                "Error generating report:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ── Clear ─────────────────────────────────────────────
    private void clearAll() {
        txtEmployeeId.setText("");
        txtYear.setText(String.valueOf(java.time.Year.now().getValue()));
        tableModel.setRowCount(0);
        lblNameValue.setText("—");
        lblIdValue.setText("—");
        lblTotalValue.setText("—");
        lblBalanceValue.setText("—");
        lblStatus.setText("Ready.");
    }

    // ── Card helper ───────────────────────────────────────
    private JPanel makeCard(String title, JLabel valueLabel) {
        JPanel card = new JPanel(new GridLayout(2, 1, 0, 4));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(203, 213, 225), 1, true),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        card.setBackground(new Color(248, 250, 252));

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
        titleLabel.setForeground(Color.GRAY);

        valueLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        valueLabel.setForeground(new Color(30, 41, 59));

        card.add(titleLabel);
        card.add(valueLabel);
        return card;
    }

    // ── Main ──────────────────────────────────────────────
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       try {
        for (javax.swing.UIManager.LookAndFeelInfo info : 
                javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception ex) {
    }

    // Then create the UI once
    SwingUtilities.invokeLater(() -> new ReportUI());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
