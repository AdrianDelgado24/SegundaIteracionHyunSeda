package co.com.hyunseda.market.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un carrito de compras en el dominio del mercado.
 * 
 */
public class ShoppingCart {
    
    private Product product;
    private User user;
    private ArrayList<Product> carro;

    /**
     * Constructor por defecto de ShoppingCart.
     */
    public ShoppingCart() {
    }

    /**
     * Constructor de ShoppingCart con parámetros.
     * 
     * @param product Producto del carrito.
     * @param user Usuario propietario del carrito.
     * @param carro Lista de productos en el carrito.
     */
    public ShoppingCart(Product product, User user, ArrayList<Product> carro) {
        this.product = product;
        this.user = user;
        this.carro = carro;
    }

    // Getters y Setters

    /**
     * Obtiene el producto del carrito.
     * 
     * @return El producto del carrito.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Establece el producto del carrito.
     * 
     * @param product El producto del carrito a establecer.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Obtiene el usuario propietario del carrito.
     * 
     * @return El usuario propietario del carrito.
     */
    public User getUser() {
        return user;
    }

    /**
     * Establece el usuario propietario del carrito.
     * 
     * @param user El usuario propietario del carrito a establecer.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Obtiene la lista de productos en el carrito.
     * 
     * @return La lista de productos en el carrito.
     */
    public ArrayList<Product> getCarro() {
        return carro;
    }

    /**
     * Establece la lista de productos en el carrito.
     * 
     * @param carro La lista de productos en el carrito a establecer.
     */
    public void setCarro(ArrayList<Product> carro) {
        this.carro = carro;
    }
}
