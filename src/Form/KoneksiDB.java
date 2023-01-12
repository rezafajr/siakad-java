/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
/**
 *
 * @author Reza Fajri
 */
public class KoneksiDB {
    static Connection koneksi;
    //membuat metot getConnetion
    public static Connection getConnection(){
        try{
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/siakad_ti2","root","");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Koneksi Gagal");
        }
        return koneksi;
    }
}
