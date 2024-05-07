package co.com.hyunsedaProduct.domain.entity;
/**
 * Esta clase representa la entidad Product en el dominio del sistema.
 * Cada instancia de esta clase corresponde a un producto en la base de datos.
 */
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products") //JPA->Java persistense API->iverneit motor
public class Product implements Serializable //Para serializar lo objetos y mandarlos en Json
{
    private static final long serialVersionUID = 1L; /*se utiliza para garantizar la compatibilidad entre diferentes
                                                        versiones de la clase cuando se serializa y deserializa*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)/* Identity es que sea único y se debe ingresar manualmente */
    private long productId;

    @Column (name="product_name")
    private String productName; /* Nombre del producto. */

    @Column (name="product_Descripcion")
    private String productDescripcion; /* Descripción del producto. */

    @Column (name="product_price")
    private double productPrice; /* Precio del producto. */

    @Column (name="product_stock")
    private long productStock; /* Stock disponible del producto. */

    @Column (name="keywords")
    private String keywords; /* Palabras clave relacionadas con el producto. */
    @Column (name="product_caracteristc")
    private String productCaracteristc; /* Características del producto. */

    @Column (name="product_photo")
    private String productPhoto; /* URL de la foto del producto. */

    @ManyToMany()
    @JoinTable(name = "productCategory",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private List<Category> categories; /* Lista de categorías a las que pertenece el producto. */


}