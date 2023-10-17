package com.comparador.Controller;

import com.comparador.DTO.ProductoDTO;
import com.comparador.DTO.TiendaDTO;
import com.comparador.DTO.TiendaDTOProduct;
import com.comparador.Entity.Tienda;
import com.comparador.Service.ITiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TiendaRestController {

    @Autowired
    ITiendaService tiendaServi;

    @RequestMapping("/tiendas")
    public List<TiendaDTO> showAll() {

        return tiendaServi.findAll();
    }

@GetMapping("/productos-tienda/{id}")
public TiendaDTOProduct getTienda(@PathVariable Long id) {
        return tiendaServi.getTiendaWithProductos(id);
}

    @RequestMapping("/tiendas/{id}")
    public TiendaDTO showById(@PathVariable Long id) {

        return tiendaServi.findById(id);
    }

    @PostMapping("/creartiendas")
    public TiendaDTO save(@RequestBody Tienda tienda){
        return tiendaServi.save(tienda);
    }
}



