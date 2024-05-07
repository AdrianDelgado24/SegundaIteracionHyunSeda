package co.com.hyunseda.market.domain;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Representa un producto en el dominio del mercado.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    
    @JsonProperty("productId")
    private int productId;
    
    @JsonProperty("productName")
    private String productName;
    
    @JsonProperty("productDescripcion")
    private String productDescripcion;
    
    @JsonProperty("productPrice")
    private double productPrice;
    
    @JsonProperty("productStock")
    private int productStock;
    
    @JsonProperty("keywords")
    private String keywords;
    
     @JsonProperty("productPhoto")
    private String productPhoto;
    
    @JsonProperty("productCaracteristc")
    private String productCaracteristc;
    
    Category category;
    
    @JsonProperty("categories")
    private List<Category> categoriasSecundarias;
    Location location;
    User user;

     /**
     * Constructor de Producto con parámetros básicos.
     *
     * @param productId          ID del producto.
     * @param productName        Nombre del producto.
     * @param productDescripcion Descripción del producto.
     */
    public Product(int productId, String productName, String productDescripcion) {
        this.productId = productId;
        this.productName = productName;
        this.productDescripcion = productDescripcion;
    }
    
        /**
     * Constructor de Producto con parámetros adicionales.
     *
     * @param productId          ID del producto.
     * @param productName        Nombre del producto.
     * @param productPrice       Precio del producto.
     * @param productDescripcion Descripción del producto.
     * @param productStock       Stock del producto.
     */
    public Product(int productId, String productName, double productPrice,String productDescripcion,int productStock,String productPhoto) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescripcion = productDescripcion;
        this.productStock = productStock;
    }
   
        /**
     * Constructor de Producto con parámetros adicionales.
     *
     * @param productId          ID del producto.
     * @param productName        Nombre del producto.
     * @param productPrice       Precio del producto.
     * @param productDescripcion Descripción del producto.
     * @param productStock       Stock del producto.
     * @param productPhoto       Foto del producto.
     * @param keywords            Palabras clave.
     * @param productCaracteristc Caracteristica del producto
     */
    public Product(int productId, String productName, String productDescripcion, double productPrice, int productStock, String keywords, String productCaracteristc) {
        this.productId = productId;
        this.productName = productName;
        this.productDescripcion = productDescripcion;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.keywords = keywords;
        this.productCaracteristc = productCaracteristc;
    }
    
     /**
     * Constructor de Producto con parámetros adicionales.
     *
     * @param productId          ID del producto.
     * @param productName        Nombre del producto.
     * @param productPrice       Precio del producto.
     * @param productDescripcion Descripción del producto.
     * @param productStock       Stock del producto.
     * @param productPhoto       Foto del producto.
     * @param keywords            Palabras clave.
     * @param productCaracteristc Caracteristica del producto
     * @param categoriasSecundarias Categorias auxiliares para pasarle la categoria
     */
    public Product(int productId, String productName, String productDescripcion, double productPrice, int productStock, String keywords, String productCaracteristc,String photo, ArrayList<Category> categoriasSecundarias) {
        this.productId = productId;
        this.productName = productName;
        this.productDescripcion = productDescripcion;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.keywords = keywords;
        this.productCaracteristc = productCaracteristc;
        this.productPhoto = photo;
        this.categoriasSecundarias = new ArrayList<>();
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

   public List<Category> getCategoriasSecundarias() {
        return categoriasSecundarias;
    }

    public void setCategoriasSecundarias(List<Category> categoriasSecundarias) {
        this.categoriasSecundarias = categoriasSecundarias;
    }
    

    public void addCategory(Category category) {
        categoriasSecundarias.add(category);
    }
    
    public String getProductDescripcion() {
        return productDescripcion;
    }

    public void setProductDescripcion(String productDescripcion) {
        this.productDescripcion = productDescripcion;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getProductCaracteristc() {
        return productCaracteristc;
    }

    public void setProductCaracteristc(String productCaracteristc) {
        this.productCaracteristc = productCaracteristc;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public User getUser() {
        return user;
    }

   public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto;
    }
    
    @Override
    public String toString() {
        return "Product{productId=" + productId 
                +", productName='" + productName 
                + "', productDescripcion='" + productDescripcion 
                + ", productPrice='" + productPrice
                + ", productStock='" + productStock
                + ", keywords='" + keywords
                + ", productCharacteristics='"
                + productCaracteristc 
                +", productPhoto='" + productPhoto
                + "'}";
    }
}

