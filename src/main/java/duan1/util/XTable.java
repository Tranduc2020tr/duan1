package duan1.util;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 * Utility class để style JTable đẹp hơn
 * @author hang
 */
public class XTable {
    
    /**
     * Style table với giao diện đẹp
     * @param table JTable cần style
     */
    public static void styleTable(JTable table) {
        // Style header
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(51, 190, 189)); // Màu xanh đẹp
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        // Style table
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setRowHeight(30); // Tăng chiều cao row
        table.setSelectionBackground(new Color(51, 190, 189, 100)); // Màu selection
        table.setSelectionForeground(Color.BLACK);
        table.setGridColor(new Color(200, 200, 200)); // Màu grid
        table.setShowGrid(true);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        
        // Alternating row colors
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, 
                    boolean hasFocus, int row, int column) {
                
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                if (!isSelected) {
                    if (row % 2 == 0) {
                        setBackground(new Color(248, 248, 248)); // Màu xám nhạt
                    } else {
                        setBackground(Color.WHITE);
                    }
                }
                
                setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
                return this;
            }
        });
        
        // Auto resize columns
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        // Style column headers
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setHeaderRenderer(new DefaultTableCellRenderer() {
                @Override
                public java.awt.Component getTableCellRendererComponent(
                        JTable table, Object value, boolean isSelected, 
                        boolean hasFocus, int row, int column) {
                    
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setBackground(new Color(51, 190, 189));
                    setForeground(Color.WHITE);
                    setFont(new Font("Segoe UI", Font.BOLD, 14));
                    setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    setBorder(javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE),
                        javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10)
                    ));
                    return this;
                }
            });
        }
    }
    
    /**
     * Style table với màu tùy chỉnh
     * @param table JTable cần style
     * @param headerColor Màu header
     * @param headerTextColor Màu chữ header
     */
    public static void styleTable(JTable table, Color headerColor, Color headerTextColor) {
        // Style header
        JTableHeader header = table.getTableHeader();
        header.setBackground(headerColor);
        header.setForeground(headerTextColor);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        // Style table
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setRowHeight(30);
        table.setSelectionBackground(new Color(headerColor.getRed(), headerColor.getGreen(), headerColor.getBlue(), 100));
        table.setSelectionForeground(Color.BLACK);
        table.setGridColor(new Color(200, 200, 200));
        table.setShowGrid(true);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        
        // Alternating row colors
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, 
                    boolean hasFocus, int row, int column) {
                
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                if (!isSelected) {
                    if (row % 2 == 0) {
                        setBackground(new Color(248, 248, 248));
                    } else {
                        setBackground(Color.WHITE);
                    }
                }
                
                setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
                return this;
            }
        });
        
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
    /**
     * Style table cho bảng lương với màu đặc biệt
     * @param table JTable bảng lương
     */
    public static void styleSalaryTable(JTable table) {
        styleTable(table, new Color(34, 139, 34), Color.WHITE); // Màu xanh lá
    }
    
    /**
     * Style table cho bảng nhân viên
     * @param table JTable bảng nhân viên
     */
    public static void styleEmployeeTable(JTable table) {
        styleTable(table, new Color(70, 130, 180), Color.WHITE); // Màu xanh dương
    }
    
    /**
     * Style table cho bảng hợp đồng
     * @param table JTable bảng hợp đồng
     */
    public static void styleContractTable(JTable table) {
        styleTable(table, new Color(255, 140, 0), Color.WHITE); // Màu cam
    }
}

