package com.comparador.Repository;

import com.comparador.DTO.TiendaDTO;
import com.comparador.Entity.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITiendaRepository extends JpaRepository<Tienda, Long> {

    @Query(value = "SELECT t.id_tienda, t.nombre AS nombre_tienda, p.id_producto, p.nombre AS nombre_producto, pt.precio " +
            "FROM tiendas t " +
            "INNER JOIN productos_tiendas pt ON t.id_tienda = pt.id_tienda " +
            "INNER JOIN productos p ON pt.id_producto = p.id_producto " +
            "WHERE t.id_tienda = :id", nativeQuery = true)
    List<Object[]> getTiendaWithProductos(@Param("id") Long id);
}
