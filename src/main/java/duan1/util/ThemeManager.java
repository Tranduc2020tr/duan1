package duan1.util;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.logging.Logger;

/**
 * Quản lý theme và Look and Feel cho ứng dụng
 * Sử dụng FlatLaf để tạo giao diện hiện đại và đẹp mắt
 */
public class ThemeManager {
    
    private static final Logger logger = Logger.getLogger(ThemeManager.class.getName());
    
    /**
     * Thiết lập theme mặc định cho ứng dụng
     */
    public static void setupDefaultTheme() {
        try {
            // Sử dụng FlatMacLightLaf - theme sáng đẹp mắt
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            
            // Thiết lập một số thuộc tính tùy chỉnh
            customizeTheme();
            
            logger.info("FlatLaf theme đã được thiết lập thành công");
        } catch (UnsupportedLookAndFeelException e) {
            logger.severe("Không thể thiết lập FlatLaf theme: " + e.getMessage());
        }
    }
    
    /**
     * Thiết lập theme tối
     */
    public static void setupDarkTheme() {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
            customizeTheme();
            logger.info("Dark theme đã được thiết lập thành công");
        } catch (UnsupportedLookAndFeelException e) {
            logger.severe("Không thể thiết lập Dark theme: " + e.getMessage());
        }
    }
    
    /**
     * Chuyển đổi theme với hiệu ứng mượt mà
     */
    public static void switchTheme(boolean isDark) {
        try {
            if (isDark) {
                FlatAnimatedLafChange.showSnapshot();
                UIManager.setLookAndFeel(new FlatMacDarkLaf());
            } else {
                FlatAnimatedLafChange.showSnapshot();
                UIManager.setLookAndFeel(new FlatMacLightLaf());
            }
            customizeTheme();
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
        } catch (UnsupportedLookAndFeelException e) {
            logger.severe("Không thể chuyển đổi theme: " + e.getMessage());
        }
    }
    
    /**
     * Tùy chỉnh theme với các thuộc tính riêng
     */
    private static void customizeTheme() {
        // Tùy chỉnh màu sắc cho các component
        UIManager.put("Button.arc", 8);
        UIManager.put("TextComponent.arc", 8);
        UIManager.put("ProgressBar.arc", 8);
        UIManager.put("CheckBox.arc", 8);
        
        // Tùy chỉnh font
        UIManager.put("defaultFont", new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        UIManager.put("Button.font", new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        UIManager.put("Label.font", new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        
        // Tùy chỉnh màu sắc
        UIManager.put("Button.background", new java.awt.Color(0x0078D4));
        UIManager.put("Button.foreground", java.awt.Color.WHITE);
        UIManager.put("Button.hoverBackground", new java.awt.Color(0x106EBE));
        UIManager.put("Button.pressedBackground", new java.awt.Color(0x005A9E));
        
        // Tùy chỉnh TextField
        UIManager.put("TextField.background", new java.awt.Color(0xFFFFFF));
        UIManager.put("TextField.borderColor", new java.awt.Color(0xCCCCCC));
        UIManager.put("TextField.focusedBorderColor", new java.awt.Color(0x0078D4));
        
        // Tùy chỉnh PasswordField
        UIManager.put("PasswordField.background", new java.awt.Color(0xFFFFFF));
        UIManager.put("PasswordField.borderColor", new java.awt.Color(0xCCCCCC));
        UIManager.put("PasswordField.focusedBorderColor", new java.awt.Color(0x0078D4));
    }
    
    /**
     * Kiểm tra xem theme hiện tại có phải là dark theme không
     */
    public static boolean isDarkTheme() {
        return UIManager.getLookAndFeel() instanceof FlatDarkLaf || 
               UIManager.getLookAndFeel() instanceof FlatMacDarkLaf;
    }
}