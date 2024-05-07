package co.com.hyunseda.market.service;

import co.com.hyunseda.market.domain.Category;
import co.com.hyunseda.market.domain.acess.ICategoryRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para la gestión de categorías.
 * Encapsula la lógica de negocio relacionada con las categorías.
 * Utiliza una abstracción de repositorio para interactuar con la capa de acceso a datos.
 * 
 * @author Laura Sofia
 */
public class CategoryService {
    
    /** Repositorio de categorías. */
    private ICategoryRepository repository;

    /**
     * Constructor de la clase CategoryService.
     * Inyección de dependencias en el constructor.
     *
     * @param repository una instancia de una clase que implementa ICategoryRepository
     */
    public CategoryService(ICategoryRepository repository) {
        this.repository = repository;
    }

    /**
     * Guarda una nueva categoría.
     *
     * @param categoryId Identificador de la categoría.
     * @param categoryName Nombre de la categoría.
     * @return true si la categoría se guardó correctamente, false en caso contrario.
     */
    public boolean saveCategory(int categoryId, String categoryName) {
        // Crear una nueva instancia de Category
        Category newCategory = new Category();
        newCategory.setCategoryId(categoryId);
        newCategory.setCategoryName(categoryName);

        // Validar la categoría
        if (newCategory == null || newCategory.getCategoryId() < 0 || newCategory.getCategoryName().isBlank()) {
            return false;
        }

        // Guardar la categoría utilizando el repositorio
        repository.save(newCategory);
        return true;
    }

    /**
     * Obtiene una lista de todas las categorías.
     *
     * @return Lista de categorías.
     */
    public List<Category> listCategory() {
        return repository.findAll();
    }
    
    /**
     * Busca una categoría por su identificador.
     *
     * @param categoryId Identificador de la categoría a buscar.
     * @return La categoría encontrada, o null si no se encontró ninguna categoría con el identificador especificado.
     */
    public Category findCategoryById(int categoryId) {
        return repository.findById(categoryId);
    }

    /**
     * Busca todas las categorías que coincidan con el nombre especificado.
     *
     * @param categoryName Nombre de la categoría a buscar.
     * @return Lista de categorías que coinciden con el nombre especificado.
     */
    public List<Category> findAllCategoriesByName(String categoryName) {
        return repository.findAllByName(categoryName);
    }

    /**
     * Busca todas las categorías que tengan el identificador especificado.
     *
     * @param categoryId Identificador de la categoría a buscar.
     * @return Lista de categorías que tienen el identificador especificado.
     */
    public List<Category> findAllCategorysByCategoryId(int categoryId) {
        return repository.findAllByCategoryId(categoryId);
    }

    /**
     * Elimina una categoría por su identificador.
     *
     * @param categoryId Identificador de la categoría a eliminar.
     * @return true si la categoría se eliminó correctamente, false en caso contrario.
     */
    public boolean deleteCategory(int categoryId) {
        return repository.delete(categoryId);
    }

    /**
     * Edita una categoría existente.
     *
     * @param categoryId Identificador de la categoría a editar.
     * @param category Nueva información de la categoría.
     * @return true si la categoría se editó correctamente, false en caso contrario.
     */
    public boolean editCategory(int categoryId, Category category) {
        if (category == null || category.getCategoryName().isEmpty()) {
            return false;
        }
        return repository.edit(categoryId, category);
    }
}
