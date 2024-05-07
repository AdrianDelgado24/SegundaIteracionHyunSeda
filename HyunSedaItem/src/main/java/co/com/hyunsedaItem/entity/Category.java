package co.com.hyunsedaItem.entity;

public class Category {
    /**
     *Identificador único de la categoría
     */
    private long categoryId;
    /**
     * Nombre de la categoría
     */
    private String categoryName;

    /**
     * Obtiene el identificador de la categoría.
     * @return El identificador de la categoría.
     */
    public long getCategoryId() {
        return categoryId;
    }

    /**
     * Establece el identificador de la categoría.
     * @param categoryId El identificador de la categoría a establecer.
     */
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Obtiene el nombre de la categoría.
     * @return El nombre de la categoría.
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Establece el nombre de la categoría.
     * @param categoryName El nombre de la categoría a establecer.
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
