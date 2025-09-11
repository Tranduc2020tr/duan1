package duan1.UI;

import duan1.util.XTable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

/**
 * Demo class để hiển thị các style table khác nhau
 * @author hang
 */
public class TableStyleDemo extends JFrame {
    
    public TableStyleDemo() {
        setTitle("Demo Table Styles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);
        setLocationRelativeTo(null);
        
        // Tạo panel chính
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        mainPanel.setBackground(new Color(240, 240, 240));
        
        // Tạo table mặc định
        JTable defaultTable = createSampleTable();
        XTable.styleTable(defaultTable);
        JPanel defaultPanel = createTablePanel("Table Mặc Định", defaultTable);
        
        // Tạo table bảng lương
        JTable salaryTable = createSampleTable();
        XTable.styleSalaryTable(salaryTable);
        JPanel salaryPanel = createTablePanel("Bảng Lương", salaryTable);
        
        // Tạo table nhân viên
        JTable employeeTable = createSampleTable();
        XTable.styleEmployeeTable(employeeTable);
        JPanel employeePanel = createTablePanel("Bảng Nhân Viên", employeeTable);
        
        // Tạo table hợp đồng
        JTable contractTable = createSampleTable();
        XTable.styleContractTable(contractTable);
        JPanel contractPanel = createTablePanel("Bảng Hợp Đồng", contractTable);
        
        // Tạo table với màu tùy chỉnh
        JTable customTable = createSampleTable();
        XTable.styleTable(customTable, new Color(128, 0, 128), Color.WHITE); // Màu tím
        JPanel customPanel = createTablePanel("Table Tùy Chỉnh", customTable);
        
        // Thêm các panel vào main panel
        mainPanel.add(defaultPanel);
        mainPanel.add(salaryPanel);
        mainPanel.add(employeePanel);
        mainPanel.add(contractPanel);
        mainPanel.add(customPanel);
        
        add(mainPanel, BorderLayout.CENTER);
    }
    
    private JTable createSampleTable() {
        String[] columns = {"Mã", "Tên", "Mô tả", "Trạng thái"};
        Object[][] data = {
            {"001", "Nguyễn Văn A", "Nhân viên", "Hoạt động"},
            {"002", "Trần Thị B", "Quản lý", "Hoạt động"},
            {"003", "Lê Văn C", "Nhân viên", "Tạm dừng"},
            {"004", "Phạm Thị D", "Nhân viên", "Hoạt động"},
            {"005", "Hoàng Văn E", "Quản lý", "Hoạt động"}
        };
        
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép edit
            }
        };
        
        return new JTable(model);
    }
    
    private JPanel createTablePanel(String title, JTable table) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(220, 300));
        panel.setBackground(Color.WHITE);
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(
            javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200)),
            title,
            javax.swing.border.TitledBorder.CENTER,
            javax.swing.border.TitledBorder.TOP,
            new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12),
            new Color(51, 51, 51)
        ));
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(200, 250));
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    public static void main(String[] args) {
        // Set look and feel
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new TableStyleDemo().setVisible(true);
        });
    }
}

