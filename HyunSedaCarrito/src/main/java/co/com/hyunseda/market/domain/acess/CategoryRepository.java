package co.com.hyunseda.market.domain.acess;

import co.com.hyunseda.market.domain.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Repositorio para la gestión de categorías.
 */
public class CategoryRepository implements ICategoryRepository {
    
    /** URL de la API REST. */
    private String apiUrl = "http://localhost:8001/categories";
    
    /** Constructor de la clase CategoryRepository. */
    public CategoryRepository() {
    }
   
    @Override
    public boolean save(Category newCategory) {
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Convertir el objeto Category a JSON
            String jsonCategory = mapper.writeValueAsString(newCategory);  
            
            // Crear una solicitud POST para guardar la categoría
            HttpPost request = new HttpPost(apiUrl);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonCategory));
            
            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);
            
            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            return (statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_CREATED);
        } catch (IOException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, "Error al realizar la solicitud HTTP", ex);
            return false;
        }
    }
  
    @Override
    public List<Category> findAll() {
        HttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        List<Category> list = new ArrayList<>();
        try {
            // Crear una solicitud GET para obtener todas las categorías
            HttpGet request = new HttpGet(apiUrl);
            
            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(request);
            
            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());
                // Mapear la respuesta JSON a objetos Category
                Category[] categories = mapper.readValue(jsonResponse, Category[].class);
                for (Category category : categories) {
                    list.add(category);
                }
            } else {
                // La solicitud falló, mostrar el código de estado
                Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, "Error al obtener categorías. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(CategoryRepository.class.getName()).log(Level.SEVERE, "Error al realizar la solicitud HTTP", ex);
        }
        return list;
    }

    @Override
    public boolean edit(int categoryId, Category category) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Category findById(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Category> findAllByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Category> findAllByCategoryId(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
