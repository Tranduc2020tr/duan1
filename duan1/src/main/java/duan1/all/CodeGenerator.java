/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.all;

import java.util.Random;

/**
 *
 * @author hang
 */
public class CodeGenerator {
     public static String generateCode() {
        Random rand = new Random();
        return String.valueOf(100000 + rand.nextInt(900000));
    }
}
