/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thebar70
 */
public class Mundo {

    private CrudMysql sql = new CrudMysql();

    public DefaultTableModel todos_los_productos() {
        return sql.allProductos();
    }

    public void crear_nuevo_producto(String nombre, int stock, String empaque, boolean detallable, float precio_unidad,
            int unidades, float precio) throws SQLException 
    {
        Producto nuevo = new Producto(nombre, precio, stock, empaque, detallable, unidades, precio_unidad, getFechaActual(), true);
        System.out.println("->>" + getFechaActual());
        sql.insertar_producto(nuevo);

    }

    public Date getFechaActual() {
        Date ahora = new Date();
        return ahora;
    }
    public int elementos_bodega() {
        return sql.elementos_en_bodega();
    }

}
