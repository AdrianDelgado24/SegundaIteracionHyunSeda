package co.com.hyunseda.market.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un carrito de compras.
 * 
 * @author Laura Sofia
 */
public class Carrito {

    /** Lista de productos en el carrito. */
    List<Product> productos = new ArrayList<>();

    /** Total de artículos en el carrito. */
    int totalArticulos;

    /**
     * Constructor de la clase Carrito.
     * 
     * @param productos      Lista de productos en el carrito.
     * @param totalArticulos Total de artículos en el carrito.
     */
    public Carrito(List<Product> productos, int totalArticulos) {
        this.productos = productos;
        this.totalArticulos = totalArticulos;
    }

    /**
     * Obtiene la lista de productos en el carrito.
     * 
     * @return La lista de productos en el carrito.
     */
    public List<Product> getProductos() {
        return productos;
    }

    /**
     * Establece la lista de productos en el carrito.
     * 
     * @param productos La lista de productos a establecer.
     */
    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }

    /**
     * Obtiene el total de artículos en el carrito.
     * 
     * @return El total de artículos en el carrito.
     */
    public int getTotalArticulos() {
        return totalArticulos;
    }

    /**
     * Establece el total de artículos en el carrito.
     * 
     * @param totalArticulos El total de artículos a establecer.
     */
    public void setTotalArticulos(int totalArticulos) {
        this.totalArticulos = totalArticulos;
    }
}
