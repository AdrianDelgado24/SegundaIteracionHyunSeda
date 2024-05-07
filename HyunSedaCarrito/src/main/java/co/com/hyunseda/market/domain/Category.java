package co.com.hyunseda.market.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representa una categoría de productos.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

    /** Identificador de la categoría. */
    @JsonProperty("categoryId")
    private int categoryId;

    /** Nombre de la categoría. */
    @JsonProperty("categoryName")
    private String categoryName;

    /**
     * Constructor de la clase Category.
     * 
     * @param categoryId   El identificador de la categoría.
     * @param categoryName El nombre de la categoría.
     */
    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    /** Constructor por defecto de la clase Category. */
    public Category() {
    }

    /**
     * Obtiene el identificador de la categoría.
     * 
     * @return El identificador de la categoría.
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Establece el identificador de la categoría.
     * 
     * @param categoryId El identificador de la categoría a establecer.
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Obtiene el nombre de la categoría.
     * 
     * @return El nombre de la categoría.
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Establece el nombre de la categoría.
     * 
     * @param categoryName El nombre de la categoría a establecer.
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Retorna una representación en forma de cadena de la categoría.
     * 
     * @return Una cadena que representa la categoría.
     */
    @Override
    public String toString() {
        return "Category{categoryId=" + categoryId + ", categoryName='" + categoryName + "'}";
    }
}
