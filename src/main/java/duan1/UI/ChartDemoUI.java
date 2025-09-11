package duan1.UI;

import duan1.util.ThemeManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Demo UI để hiển thị các tính năng của JFreeChart với FlatLaf theme
 */
public class ChartDemoUI extends JFrame {
    
    private JTabbedPane tabbedPane;
    private ChartPanel pieChartPanel;
    private ChartPanel barChartPanel;
    private ChartPanel lineChartPanel;
    
    public ChartDemoUI() {
        // Thiết lập FlatLaf theme
        ThemeManager.setupDefaultTheme();
        
        initComponents();
        createCharts();
        setupLayout();
        
        setTitle("JFreeChart Demo với FlatLaf Theme");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        tabbedPane = new JTabbedPane();
        
        // Tạo button để chuyển đổi theme
        JButton themeToggleButton = new JButton("Chuyển Dark/Light Theme");
        themeToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isDark = ThemeManager.isDarkTheme();
                ThemeManager.switchTheme(!isDark);
                SwingUtilities.updateComponentTreeUI(ChartDemoUI.this);
            }
        });
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(themeToggleButton);
        
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
    }
    
    private void createCharts() {
        // Tạo Pie Chart
        DefaultPieDataset<String> pieDataset = new DefaultPieDataset<>();
        pieDataset.setValue("Java", 35);
        pieDataset.setValue("Python", 25);
        pieDataset.setValue("C++", 20);
        pieDataset.setValue("JavaScript", 15);
        pieDataset.setValue("Other", 5);
        
        JFreeChart pieChart = ChartFactory.createPieChart(
            "Ngôn ngữ lập trình phổ biến",
            pieDataset,
            true, true, false
        );
        pieChartPanel = new ChartPanel(pieChart);
        
        // Tạo Bar Chart
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
        barDataset.addValue(100, "Q1", "Tháng 1");
        barDataset.addValue(120, "Q1", "Tháng 2");
        barDataset.addValue(110, "Q1", "Tháng 3");
        barDataset.addValue(130, "Q2", "Tháng 4");
        barDataset.addValue(140, "Q2", "Tháng 5");
        barDataset.addValue(135, "Q2", "Tháng 6");
        
        JFreeChart barChart = ChartFactory.createBarChart(
            "Doanh thu theo quý",
            "Tháng",
            "Doanh thu (triệu VNĐ)",
            barDataset,
            PlotOrientation.VERTICAL,
            true, true, false
        );
        barChartPanel = new ChartPanel(barChart);
        
        // Tạo Line Chart
        DefaultCategoryDataset lineDataset = new DefaultCategoryDataset();
        lineDataset.addValue(50, "Sản phẩm A", "2019");
        lineDataset.addValue(65, "Sản phẩm A", "2020");
        lineDataset.addValue(80, "Sản phẩm A", "2021");
        lineDataset.addValue(90, "Sản phẩm A", "2022");
        lineDataset.addValue(95, "Sản phẩm A", "2023");
        
        lineDataset.addValue(30, "Sản phẩm B", "2019");
        lineDataset.addValue(45, "Sản phẩm B", "2020");
        lineDataset.addValue(60, "Sản phẩm B", "2021");
        lineDataset.addValue(70, "Sản phẩm B", "2022");
        lineDataset.addValue(85, "Sản phẩm B", "2023");
        
        JFreeChart lineChart = ChartFactory.createLineChart(
            "Tăng trưởng sản phẩm theo năm",
            "Năm",
            "Số lượng bán (nghìn)",
            lineDataset,
            PlotOrientation.VERTICAL,
            true, true, false
        );
        lineChartPanel = new ChartPanel(lineChart);
    }
    
    private void setupLayout() {
        tabbedPane.addTab("Pie Chart", pieChartPanel);
        tabbedPane.addTab("Bar Chart", barChartPanel);
        tabbedPane.addTab("Line Chart", lineChartPanel);
        
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        // Thiết lập FlatLaf theme
        ThemeManager.setupDefaultTheme();
        
        SwingUtilities.invokeLater(() -> {
            new ChartDemoUI().setVisible(true);
        });
    }
}
