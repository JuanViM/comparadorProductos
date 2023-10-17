package com.comparador.Service;


import com.comparador.DTO.ProductoDTO;
import com.comparador.Entity.Producto;
import com.comparador.Repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
@Service
public class IProductoServiceImpl implements IProductoService{

    @Autowired
    IProductoRepository repoProducto;


    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> findAll() {
        List<Producto> productos1 = (List<Producto>) repoProducto.findAll();
        List<ProductoDTO> produF = new ArrayList<>();

        for (Producto p : productos1) {
            ProductoDTO pro = new ProductoDTO();
            pro.setId(p.getId());
            pro.setNombre(p.getNombre());
            produF.add(pro);
        }
        return produF;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoDTO findById(@PathVariable Long id) {
        return mapperDTO(repoProducto.findById(id).orElse(null));
    }

    public ProductoDTO mapperDTO(Producto producto){
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        return productoDTO;
    }
}


