package com.comparador.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "productos")
public class Producto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;

    private String nombre;


    @ManyToMany(mappedBy = "productos")
    private List<Tienda> tiendas;


}
