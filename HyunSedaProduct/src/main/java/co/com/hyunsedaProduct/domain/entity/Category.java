package co.com.hyunsedaProduct.domain.entity;
/**
 * Esta clase representa la entidad Category en el dominio del sistema.
 * Cada instancia de esta clase corresponde a una categoría en la base de datos.
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**Librerias de Lombok*/
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Categories") //JPA->Java persistense API->iverneit motor
public class Category implements Serializable {

    private static final long serialVersionUID = 1L; /* Se utiliza para garantizar la compatibilidad entre diferentes
                                                           versiones de la clase cuando se serializa y deserializa. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_Id")
    private long categoryId; /* Identificador único de la categoría en la base de datos. */
    @Column(name="category_Name")
    private String categoryName; /* Nombre de la categoría. */
    @JsonIgnore
   @ManyToMany(mappedBy = "categories") /* Indica que esta lista es mapeada por la relación 'categories' en la clase Product. */
   private List<Product> products = new ArrayList<>();

    /**
     * Constructor de la clase Category.
     */
    public Category(){
        this.products = new ArrayList<>();
    }
}
