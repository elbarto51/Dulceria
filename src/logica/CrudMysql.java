/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import conexion.ConexionBD;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thebar70
 */
public class CrudMysql {
   
    private ConexionBD base_datos=new ConexionBD();
    

    public DefaultTableModel allProductos() {
        
        try {
            ResultSet rs;
            DefaultTableModel modelo_tabla = null;

            // TODO add your handling code here:
            base_datos.conectar();
            rs = base_datos.ejecutarQuery("select * from producto");
           
            modelo_tabla = construirModeloDeDatos(rs);
            base_datos.cerrar();
           
            return modelo_tabla;
        
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

    public void insertar_producto(Producto nuevo) throws SQLException {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String comando = "insert into producto values(null,'"
                + nuevo.getNombre() + "',"
                + nuevo.getPrecio() + ","
                + nuevo.getStock() + ",'"
                + nuevo.getEmpaque() + "',"
                + nuevo.getUnidadesPorPaquete() + ","
                + nuevo.getPrecioUnidad() + ",'"
                + formateador.format(nuevo.getFecha_ingreso()) + "',"
                + nuevo.isEstado() + ",100)";
        System.out.println("--" + comando);
        base_datos.conectar();
        base_datos.ejecutarInsert(comando);
        base_datos.cerrar();
    }

    private DefaultTableModel construirModeloDeDatos(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return (new DefaultTableModel(data, columnNames));

    }

    public int elementos_en_bodega() {
        int total = 0;
        String consulta = "select count(producto_id) from producto where estado=true";
        ResultSet rs;
        Object obj;
        try {
            base_datos.conectar();
            rs = base_datos.ejecutarQuery(consulta);
            base_datos.cerrar();
            obj = rs.getObject(total);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return total;
    }

}
