package co.com.hyunseda.market.domain.acess;

import co.com.hyunseda.market.domain.Category;
import co.com.hyunseda.market.domain.Product;
import co.com.hyunseda.market.service.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;


public class ProductRepository implements IProductRepository{
     
     private String apiUrl = "http://localhost:8001/products";
  
   
    public ProductRepository() {
       
    }

    @Override
    public List<Product> findAll() {
        
         HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        List<Product> list = new ArrayList<>();
        try {

            // Definir la URL de la API REST de productos
            String apiUrl = "http://localhost:8001/products";
            // Crear una solicitud GET para obtener todos los productos
            HttpGet request = new HttpGet(apiUrl);

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());

                // Mapear la respuesta JSON a objetos Product
                Product[] products = mapper.readValue(jsonResponse, Product[].class);

                for (Product product : products) {
                    list.add(product);
                }
            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;        
    }
    @Override
    public Product findById(int productId) {   
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Definir la URL de la API REST de productos
            HttpGet request = new HttpGet(apiUrl);

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());

                // Mapear la respuesta JSON a objetos Product
                Product[] productos = mapper.readValue(jsonResponse, Product[].class);

                // Iterar sobre los productos para encontrar el que coincida con el productId
                for (Product product : productos) {
                    if (product.getProductId() == productId) {
                        return product;
                    }
                }
            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     }
    
    @Override
    public List<Product> findAllByName(String productName) {
          
       HttpClient httpClient = HttpClients.createDefault();
       ObjectMapper mapper = new ObjectMapper();
       
       List<Product> list = new ArrayList<>();
       List<Category> categorias = new ArrayList<>();
       try {

           // Definir la URL de la API REST de productos
           String apiUrl = "http://localhost:8001/products";
           // Crear una solicitud GET para obtener todos los productos
           HttpGet request = new HttpGet(apiUrl);

           // Ejecutar la solicitud y obtener la respuesta
           HttpResponse response = httpClient.execute(request);

           // Verificar el código de estado de la respuesta
           int statusCode = response.getStatusLine().getStatusCode();
           if (statusCode == 200) {
               // La solicitud fue exitosa, procesar la respuesta
               String jsonResponse = EntityUtils.toString(response.getEntity());

               // Mapear la respuesta JSON a objetos Product
               Product[] productos = mapper.readValue(jsonResponse, Product[].class);
               
               for (Product product : productos) {
                   if(product.getProductName().equalsIgnoreCase(productName) )
                        list.add(product);
           } 
           } else {
               // La solicitud falló, mostrar el código de estado
               Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
           }
       } catch (IOException ex) {
           Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
       }
       return list;
    }
    
    @Override
    public Product findByName(String productName) {
        List<Category> categorias = new ArrayList<>();
        List<Product> products = new ArrayList<>();
    
        HttpClient httpClient = HttpClients.createDefault();
       ObjectMapper mapper = new ObjectMapper();
       List<Product> list = new ArrayList<>();
       try {

           // Definir la URL de la API REST de productos
           //String apiUrl = "http://localhost:8001/products";
           // Crear una solicitud GET para obtener todos los productos
           HttpGet request = new HttpGet(apiUrl);

           // Ejecutar la solicitud y obtener la respuesta
           HttpResponse response = httpClient.execute(request);

           // Verificar el código de estado de la respuesta
           int statusCode = response.getStatusLine().getStatusCode();
           if (statusCode == 200) {
               // La solicitud fue exitosa, procesar la respuesta
               String jsonResponse = EntityUtils.toString(response.getEntity());

               // Mapear la respuesta JSON a objetos Product
               Product[] productos = mapper.readValue(jsonResponse, Product[].class);
               //Category[] categories = mapper.readValue(jsonResponse,Category[].class);
               
               for (Product product : productos) {
                  // for(Category cate :categories){
                   if(product.getProductName().equalsIgnoreCase(productName) )
                    return product;
                   //}
           }
                   
           } else {
               // La solicitud falló, mostrar el código de estado
               Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
           }
       } catch (IOException ex) {
           Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
       }
        return null;
}
    
     @Override
    public boolean save(Product newProduct) {
         HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        //List<Category> list = new ArrayList<>();
        try {

            // Definir la URL de la API REST de categorias
            String apiUrl = "http://localhost:8001/products";
            
            // Convertir el objeto Category a JSON
            String jsonProduct= mapper.writeValueAsString(newProduct);  
            
            // Crear una solicitud POST para obtener todas las categorias
            HttpPost request = new HttpPost(apiUrl);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonProduct));
            
            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_CREATED) {
                return true;
            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, "Error al guardar el producto. Código de estado: " + statusCode);
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, "Error al realizar la solicitud HTTP", ex);
            return false;
        }
    }
     
    @Override
    public boolean saveProductCategory(Product producto,Category newCategory) {
       List<Category> categorias = producto.getCategoriasSecundarias();
       List<Product> product =new ArrayList<>();
        
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            // Definir la URL de la API REST de categorias
            String apiUrl = "http://localhost:8001/products";
            
            // Convertir el objeto Category a JSON
            String jsonProduct = mapper.writeValueAsString(producto);  
            
            // Crear una solicitud POST para obtener todas las categorias
            HttpPost request = new HttpPost(apiUrl);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonProduct));
            
            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_CREATED) {
                return true;
            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, "Error al guardar la categoría. Código de estado: " + statusCode);
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, "Error al realizar la solicitud HTTP", ex);
        }
        return false;
        
    }
    
    public List<Product> findByCategory(String category) throws Exception {
        
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        List<Product> list = new ArrayList<>();
        try {

            // Definir la URL de la API REST de productos
            String apiUrl = "http://localhost:8001/products";
            // Crear una solicitud GET para obtener todos los productos
            HttpGet request = new HttpGet(apiUrl);

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);

            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());

                // Mapear la respuesta JSON a objetos Product
                Product[] products = mapper.readValue(jsonResponse, Product[].class);

                for (Product product : products) {
                    for (Category categ : product.getCategoriasSecundarias()) {
                        if (categ.toString().equals(category))
                            list.add(product);
                    } 
                }
            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;   
    }

    @Override
    public boolean edit(int productId, Product product) {
         throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int productId) {
        List<Product> products = new ArrayList<>();
    
        HttpClient httpClient = HttpClients.createDefault();
       ObjectMapper mapper = new ObjectMapper();
       List<Product> list = new ArrayList<>();
       try {

           // Definir la URL de la API REST de productos
           //String apiUrl = "http://localhost:8001/products";
           // Crear una solicitud GET para obtener todos los productos
           HttpGet request = new HttpGet(apiUrl);

           // Ejecutar la solicitud y obtener la respuesta
           HttpResponse response = httpClient.execute(request);

           // Verificar el código de estado de la respuesta
           int statusCode = response.getStatusLine().getStatusCode();
           if (statusCode == 200) {
               // La solicitud fue exitosa, procesar la respuesta
               String jsonResponse = EntityUtils.toString(response.getEntity());

               // Mapear la respuesta JSON a objetos Product
               Product[] productos = mapper.readValue(jsonResponse, Product[].class);
               //Category[] categories = mapper.readValue(jsonResponse,Category[].class);
               
               for (Product product : productos) {
                  // for(Category cate :categories){
                   if(product.getProductId()==productId )
                    return true;
                   //}
           }
                   
           } else {
               // La solicitud falló, mostrar el código de estado
               Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
           }
       } catch (IOException ex) {
           Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
    
    
    }
   
    @Override
    public Category findByCategoryId(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }  
    @Override
    public List<Product> findAllByCategoryId(int categoryId) {
        List<Product> products = new ArrayList<>();

        HttpClient httpClient = HttpClients.createDefault();
       ObjectMapper mapper = new ObjectMapper();
       List<Product> list = new ArrayList<>();
       try {

           // Definir la URL de la API REST de productos
           //String apiUrl = "http://localhost:8001/products";
           // Crear una solicitud GET para obtener todos los productos
           HttpGet request = new HttpGet(apiUrl);

           // Ejecutar la solicitud y obtener la respuesta
           HttpResponse response = httpClient.execute(request);

           // Verificar el código de estado de la respuesta
           int statusCode = response.getStatusLine().getStatusCode();
           if (statusCode == 200) {
               // La solicitud fue exitosa, procesar la respuesta
               String jsonResponse = EntityUtils.toString(response.getEntity());

               // Mapear la respuesta JSON a objetos Product
               Product[] productos = mapper.readValue(jsonResponse, Product[].class);

               for (Product product : productos) {
                   for (Category categ : product.getCategoriasSecundarias()) {
                   if(categ.toString().equals(categoryId)){
                   list.add(product);
                   }
               }
               }
           } else {
               // La solicitud falló, mostrar el código de estado
               Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, "Error al obtener productos. Código de estado: " + statusCode);
           }
       } catch (IOException ex) {
           Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
       }
       return list;
    }
    }
