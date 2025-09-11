/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1.controller;

import duan1.UI.WelcomeJDialog;
import duan1.util.XDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**^
 *
 * @author hang
 */
public interface LoginController {
    void open();
    void login();
    default void exit(){
    if(XDialog.confirm("Bạn muốn kết thúc?")){
    System.exit(0);
        }
    }
    
    default void showJDialog(JDialog dialog) {
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
     default void showWelcomeJDialog(JFrame frame) {
        this.showJDialog(new WelcomeJDialog(frame, true));
    }
    
     default void Showchamcong(JFrame frame) {
        this.showJDialog(new duan1.UI.chamcongui(frame, true));
    }
     
     default void Showdoimatkhau(JFrame frame) {
        this.showJDialog(new duan1.UI.ChangePasswordJDialog(frame, true));
    }
    
}
