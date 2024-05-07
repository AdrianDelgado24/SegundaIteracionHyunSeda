package co.com.hyunsedaItem.entity;

/**
 * Clase que representa un ítem de producto.
 */
public class ItemProduct {

    /** Producto asociado al ítem. */
    private Product product;

    /** Cantidad del producto en el ítem. */
    private Integer productAmount;

    /**
     * Constructor por defecto de la clase ItemProduct.
     */
    public ItemProduct() {
    }

    /**
     * Constructor con parámetros de la clase ItemProduct.
     * @param producto El producto asociado al ítem.
     * @param cantidad La cantidad del producto en el ítem.
     */
    public ItemProduct(Product producto, Integer cantidad) {
        this.product = producto;
        this.productAmount = cantidad;
    }

    /**
     * Obtiene el producto asociado al ítem.
     * @return El producto asociado al ítem.
     */
    public Product getProducto() {
        return product;
    }

    /**
     * Establece el producto asociado al ítem.
     * @param producto El producto a establecer.
     */
    public void setProducto(Product producto) {
        this.product = producto;
    }

    /**
     * Obtiene la cantidad del producto en el ítem.
     * @return La cantidad del producto en el ítem.
     */
    public Integer getCantidad() {
        return productAmount;
    }

    /**
     * Establece la cantidad del producto en el ítem.
     * @param cantidad La cantidad a establecer.
     */
    public void setCantidad(Integer cantidad) {
        this.productAmount = cantidad;
    }

    /**
     * Calcula el total del ítem multiplicando el precio del producto por la cantidad.
     * @return El total del ítem.
     */
    public Double getTotal() {
        return product.getProductPrice() * productAmount.doubleValue();
    }
}
