package com.comparador.Controller;

import com.comparador.DTO.ProductoDTO;
import com.comparador.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoRestController {

    @Autowired
    IProductoService productosSer;

    @GetMapping("/productos")
    public List<ProductoDTO> showAll(){
        return productosSer.findAll();
    }

    @GetMapping("/productos/{id}")
    public ProductoDTO showById(@PathVariable Long id){
        return productosSer.findById(id);
    }


}
