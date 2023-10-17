package com.comparador.Entity;

import com.comparador.DTO.TiendaDTOProduct;
import com.comparador.Querys.QueryConstans;
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
@Table(name = "tiendas")
@NamedNativeQuery(
        name = "find_tiendas_product",
        query = QueryConstans.SQL_tienda_precio,
        resultSetMapping = "tiendas_productos"
)
@SqlResultSetMapping(
        name = "tiendas_productos",
        classes = @ConstructorResult(
                targetClass = TiendaDTOProduct.class,
                columns = {
                        @ColumnResult(name = "id_tienda" , type = Long.class),
                        @ColumnResult(name = "nombre", type = String.class),
                        @ColumnResult(name = "productos", type = List.class),
                }
        )
)
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tienda")
    private Long id;

    private String nombre;


    @ManyToMany
    @JoinTable(
            name = "Productos_Tiendas",
            joinColumns = @JoinColumn(name = "id_tienda"),
            inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private List<Producto> productos;


}
