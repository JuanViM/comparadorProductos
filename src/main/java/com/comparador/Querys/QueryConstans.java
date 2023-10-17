package com.comparador.Querys;

public class QueryConstans {

    public static final String SQL_tienda_precio = "SELECT t.id_tienda, t.nombre AS nombre_tienda, p.id_producto, p.nombre AS nombre_producto, pt.precio " +
            "FROM tiendas t " +
            "INNER JOIN productos_tiendas pt ON t.id_tienda = pt.id_tienda " +
            "INNER JOIN productos p ON pt.id_producto = p.id_producto " +
            "WHERE t.id_tienda = :id";
}
