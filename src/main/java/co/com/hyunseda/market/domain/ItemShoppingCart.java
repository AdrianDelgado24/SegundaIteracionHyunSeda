package co.com.hyunseda.market.domain;

/**
 * Representa un ítem en el carrito de compras.
 */
public class ItemShoppingCart {

    /** Producto del ítem. */
    private Product product;

    /** Cantidad del producto en el ítem. */
    private int amount;

    /**
     * Constructor por defecto de la clase ItemShoppingCart.
     * Inicializa un nuevo producto y la cantidad a cero.
     */
    public ItemShoppingCart() {
        this.product = new Product();
        this.amount = 0;
    }

    /**
     * Constructor de la clase ItemShoppingCart.
     * 
     * @param product Producto del ítem.
     * @param amount Cantidad del producto en el ítem.
     */
    public ItemShoppingCart(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    /**
     * Obtiene el producto del ítem.
     * 
     * @return El producto del ítem.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Establece el producto del ítem.
     * 
     * @param product El producto del ítem a establecer.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Obtiene la cantidad del producto en el ítem.
     * 
     * @return La cantidad del producto en el ítem.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Establece la cantidad del producto en el ítem.
     * 
     * @param amount La cantidad del producto en el ítem a establecer.
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
