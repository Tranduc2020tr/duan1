/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.util;

import duan1.entity.User;



/**
 *
 * @author hang
 */
public class XAuth {
    // Biến lưu user hiện tại (đăng nhập thành công)
   public static User user = null;


    // Kiểm tra đã đăng nhập chưa
    public static boolean isLogin() {
        return user != null;
    }

    // Kiểm tra có phải là quản lý không
    public static boolean isTrangThai() {
        return isLogin() && user.isVaiTro();
    }

    // Đăng xuất tài khoản
    public static void logoff() {
        user = null;
    }
   
}


