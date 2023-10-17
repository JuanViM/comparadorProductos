package com.comparador.DTO;

import com.comparador.Entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TiendaDTO {

    private Long id;
    private String nombre;

}
