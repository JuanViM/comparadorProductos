package com.comparador.Service;

import com.comparador.DTO.TiendaDTO;
import com.comparador.DTO.TiendaDTOProduct;
import com.comparador.Entity.Tienda;

import java.util.List;

public interface ITiendaService {

    public List<TiendaDTO> findAll();

    public TiendaDTO findById(Long id);

    TiendaDTOProduct getTiendaWithProductos(Long id);

    TiendaDTO save(Tienda tienda);
}
