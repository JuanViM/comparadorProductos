package com.comparador.Service;

import com.comparador.DTO.ProductoDTO;
import com.comparador.DTO.TiendaDTO;
import com.comparador.DTO.TiendaDTOProduct;
import com.comparador.Entity.Tienda;
import com.comparador.Repository.ITiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ITiendaServiceImpl implements ITiendaService{

    @Autowired
    ITiendaRepository tiendaRepo;
    @Override
    @Transactional(readOnly = true)
    public List<TiendaDTO> findAll() {
        List<Tienda> tiendas = (List<Tienda>) tiendaRepo.findAll();

        List<TiendaDTO> tiendaF = tiendas.stream().map(t->{
                    TiendaDTO tie = new TiendaDTO();
                    tie.setId(t.getId());
                    tie.setNombre(t.getNombre());
                    return tie;
                })
                .collect(Collectors.toList());
             return tiendaF;
    }

    @Override
    @Transactional(readOnly = true)
    public TiendaDTO findById(@PathVariable Long id) {
        return mapperDTO(tiendaRepo.findById(id).orElse(null));

    }

//    @Override
//    public List<Object[]> getTiendaWithProductos(@PathVariable Long id) {
//
//        return tiendaRepo.getTiendaWithProductos(id);
//    }

    @Override
    public TiendaDTOProduct getTiendaWithProductos(@PathVariable Long id) {

        List<Object[]> tiendasData = tiendaRepo.getTiendaWithProductos(id);

        // Crear una instancia de TiendaDTO
        TiendaDTOProduct tiendaDTOProduc = new TiendaDTOProduct();

        // Comprobar si hay datos en la lista
        if (!tiendasData.isEmpty()) {
            Object[] tiendaData = tiendasData.get(0); // Suponiendo que solo hay una tienda por ID

            // Mapear los datos de la lista a los atributos de TiendaDTO
            tiendaDTOProduc.setId(((Integer) tiendaData[0]).longValue());
            tiendaDTOProduc.setNombre((String) tiendaData[1]);

            // Crear una lista de ProductoDTO
            List<ProductoDTO> productosDTO = new ArrayList<>();

            // Iterar a través de los datos para mapear los productos
            for (Object[] rowData : tiendasData) {
                ProductoDTO productoDTO = new ProductoDTO();
                productoDTO.setId(((Integer) rowData[2]).longValue());
                productoDTO.setNombre((String) rowData[3]);
                productoDTO.setPrecio(BigDecimal.valueOf((Double) rowData[4]));
                // Agregar el ProductoDTO a la lista de productos
                productosDTO.add(productoDTO);
            }

            // Establecer la lista de productos en TiendaDTO
            tiendaDTOProduc.setProductos(productosDTO);
        }

        return tiendaDTOProduc;

    }

    @Override
    public TiendaDTO save(Tienda tienda) {
        return  mapperDTO(tiendaRepo.save(tienda));
    }

    public TiendaDTOProduct mapperDTOproduc(Tienda tienda){
        TiendaDTOProduct tiendaDTOproduct = new TiendaDTOProduct();
        tiendaDTOproduct.setId(tienda.getId());
        tiendaDTOproduct.setNombre(tienda.getNombre());
        tiendaDTOproduct.setProductos(tienda.getProductos()
                .stream()
                .map(producto -> {
                    ProductoDTO productoDTO = new ProductoDTO();
                    productoDTO.setId(producto.getId());
                    productoDTO.setNombre(producto.getNombre());
                    return productoDTO;
                })
                .collect(Collectors.toList())
        );
        return tiendaDTOproduct;
    }

    public TiendaDTO mapperDTO(Tienda tienda){
        TiendaDTO tiendaDTO = new TiendaDTO();
        tiendaDTO.setId(tienda.getId());
        tiendaDTO.setNombre(tienda.getNombre());

        return tiendaDTO;
    }
}
