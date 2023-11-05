/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan4pbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lmao
 */
public class Select {static final String DB_URL = "jdbc:postgresql://localhost:5432/mahasiswa";
    static final String USER = "postgres";
    static final String PASS = "123";
    static final String QUERY = "SELECT * FROM mata_kuliah";

    public static void main(String[] args) {
        // Open a connection
        try ( Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);  
                Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(QUERY);) {
            while (rs.next()) {
                //Display values
                System.out.println("kode_mata_kuliah: " + String.valueOf(rs.getObject(1)));
                System.out.println("nama_mata_kuliah: " + String.valueOf(rs.getObject(2)));
                System.out.println("sks: " + String.valueOf(rs.getObject(3)));
                System.out.println("semester: " + String.valueOf(rs.getObject(4)));
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
}
