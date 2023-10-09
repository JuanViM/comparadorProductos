package com.comparador.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "productos")
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Producto {

    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(
            name = "productos_tiendas",joinColumns = @JoinColumn(name = "id_producto",referencedColumnName = "id_producto"),
    inverseJoinColumns = @JoinColumn(name = "id_tienda",referencedColumnName = "id_tienda"))
    private List<Tienda> tiendas;
}
