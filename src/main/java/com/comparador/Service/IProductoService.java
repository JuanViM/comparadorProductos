package com.comparador.Service;

import com.comparador.DTO.ProductoDTO;
import com.comparador.Entity.Producto;
import java.util.List;

public interface IProductoService {

    public List<ProductoDTO> findAll();

    public ProductoDTO findById(Long id);
}
