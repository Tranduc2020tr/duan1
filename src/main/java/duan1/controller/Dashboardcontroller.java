/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1.controller;

import duan1.UI.ChangePasswordJDialog;
import duan1.UI.HopdongUI;
import duan1.UI.NgaynghileUI;

import duan1.UI.TangCaUI;
import duan1.UI.ThongTinCaNhan;

import duan1.UI.WelcomeJDialog;
import duan1.UI.XemBangLuongNhanVien;
import duan1.UI.chamcongui;
import duan1.UI.quanlychamcongui;
import duan1.UI.quanlyluongUI;
import duan1.UI.quanlynghiphep1UI;
import duan1.UI.quanlynghiphepUI;
import duan1.UI.quanlynhanvienui;
import duan1.UI.quanlytaikhoanUI;
import duan1.entity.QuanLyLuong;
import duan1.manager.dangkitangcaManager;
import duan1.manager.xemchamcongnhanvienmanager;
import duan1.manager.xemthongtincanhan;
import duan1.util.XDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author hang
 */
public interface Dashboardcontroller {

    void init();

    default void exit() {
        if (XDialog.confirm("Bạn muốn kết thúc?")) {
            System.exit(0);
        }
    }

    default void showJDialog(JDialog dialog) {
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    default void showXemBangLuongNhanVien(JFrame frame) {
        this.showJDialog(new XemBangLuongNhanVien(frame, true));
    }

    default void showChangePasswordJDialog(JFrame frame) {
        this.showJDialog(new ChangePasswordJDialog(frame, true));
    }

    default void showQuanlynhanvienJDialog(JFrame frame) {
        this.showJDialog(new quanlynhanvienui(frame, true));
    }

    default void showQuanlychamcong(JFrame frame) {
        this.showJDialog(new quanlychamcongui(frame, true));
    }

    default void showquanlytaikhoan(JFrame frame) {
        this.showJDialog(new quanlytaikhoanUI(frame, true));
    }

    default void showNgaynghileUI(JFrame frame) {
        this.showJDialog(new NgaynghileUI(frame, true));
    }

    default void showxemchamcongnhanvienmanager(JFrame frame) {
        this.showJDialog(new xemchamcongnhanvienmanager(frame, true));
    }

    default void showquanlynghiphepUI(JFrame frame) {
        this.showJDialog(new quanlynghiphepUI(frame, true));
    }

    default void showquanlynghiphep1UI(JFrame frame) {
        this.showJDialog(new quanlynghiphep1UI(frame, true));
    }

    default void showTangCaUI(JFrame frame) {
        this.showJDialog(new TangCaUI(frame, true));

    }
    
       default void showQuanLyLuong1(JFrame frame) {
        this.showJDialog(new quanlyluongUI(frame, true));

    }
       
        default void showdangkitangca(JFrame frame) {
        this.showJDialog(new dangkitangcaManager(frame, true));

    }
        
         default void showxemcanhan(JFrame frame) {
        this.showJDialog(new xemthongtincanhan(frame, true));

    }
         
          default void showHopdongUI(JFrame frame) {
        this.showJDialog(new HopdongUI(frame, true));

    }
         
         
    
}
