package co.com.hyunsedaItem.entity;

/**
 * Clase que representa un producto.
 */
public class Product {

    /** Identificador único del producto. */
    private long productId;

    /** Nombre del producto. */
    private String productName;

    /** Descripción del producto. */
    private String productDescripcion;

    /** Precio del producto. */
    private double productPrice;

    /** Stock disponible del producto. */
    private long productStock;

    /** Palabras clave del producto. */
    private String keywords;

    /** Características del producto. */
    private String productCaracteristc;

    /** Categoría a la que pertenece el producto. */
    private Category category;

    /**
     * Obtiene el identificador único del producto.
     * @return El identificador único del producto.
     */
    public long getProductId() {
        return productId;
    }

    /**
     * Establece el identificador único del producto.
     * @param productId El identificador único del producto a establecer.
     */
    public void setProductId(long productId) {
        this.productId = productId;
    }

    /**
     * Obtiene el nombre del producto.
     * @return El nombre del producto.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Establece el nombre del producto.
     * @param productName El nombre del producto a establecer.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Obtiene la descripción del producto.
     * @return La descripción del producto.
     */
    public String getProductDescripcion() {
        return productDescripcion;
    }

    /**
     * Establece la descripción del producto.
     * @param productDescripcion La descripción del producto a establecer.
     */
    public void setProductDescripcion(String productDescripcion) {
        this.productDescripcion = productDescripcion;
    }

    /**
     * Obtiene el precio del producto.
     * @return El precio del producto.
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     * Establece el precio del producto.
     * @param productPrice El precio del producto a establecer.
     */
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * Obtiene el stock disponible del producto.
     * @return El stock disponible del producto.
     */
    public long getProductStock() {
        return productStock;
    }

    /**
     * Establece el stock disponible del producto.
     * @param productStock El stock disponible del producto a establecer.
     */
    public void setProductStock(long productStock) {
        this.productStock = productStock;
    }

    /**
     * Obtiene las palabras clave del producto.
     * @return Las palabras clave del producto.
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * Establece las palabras clave del producto.
     * @param keywords Las palabras clave del producto a establecer.
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * Obtiene las características del producto.
     * @return Las características del producto.
     */
    public String getProductCaracteristc() {
        return productCaracteristc;
    }

    /**
     * Establece las características del producto.
     * @param productCaracteristc Las características del producto a establecer.
     */
    public void setProductCaracteristc(String productCaracteristc) {
        this.productCaracteristc = productCaracteristc;
    }

    /**
     * Obtiene la categoría a la que pertenece el producto.
     * @return La categoría a la que pertenece el producto.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Establece la categoría a la que pertenece el producto.
     * @param category La categoría a establecer.
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}
