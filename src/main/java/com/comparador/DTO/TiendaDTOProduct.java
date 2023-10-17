package com.comparador.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TiendaDTOProduct {

    private Long id;
    private String nombre;
    private List<ProductoDTO> productos;

}
