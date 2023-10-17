package com.comparador.Repository;

import com.comparador.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long> {
}
