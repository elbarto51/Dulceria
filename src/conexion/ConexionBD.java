/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author elbarto51
 */
public class ConexionBD {

    Connection conect = null;

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/dulceria";
    private static final String username = "root";
    private static final String password = "mysql";

    public void conectar() {

        try {
            Class.forName(driver);
            conect = (Connection) DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a base de datos\n"
                    + "verifique inicio de BD" + e);
        }

    }

    public void cerrar() throws SQLException {
        conect.close();
    }

    public ResultSet ejecutarQuery(String consula) {
        try {
            Statement ps = conect.createStatement();

            ResultSet rs;
            rs = ps.executeQuery(consula);

            return rs;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public int ejecutarInsert(String insert) {
        int total = 0;
        try {

            Statement ps;

            ps = conect.createStatement();
            total = ps.executeUpdate(insert);

            return total;
        } catch (SQLException ex) {
            System.out.println(ex);
            return total;
        }
    }

    public int ejecutarDML(String comando) {
        int filasAfectadas = 0;
        try {

            Statement stmt = conect.createStatement();
            filasAfectadas = stmt.executeUpdate(comando);
            return filasAfectadas;
        } catch (Exception ex) {
            System.out.println(ex);
            return 0;
        }
    }

}
