package co.com.hyunsedaProduct;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.hyunsedaProduct.access.IProductRepository;
import co.com.hyunsedaProduct.domain.entity.Category;
import co.com.hyunsedaProduct.domain.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@SpringBootTest
class HyunSedaApplicationTests {
	@Autowired
	private IProductRepository repo;

	@Test
	public void testCreateProduct() {
		long productId = 1;

		String productName = "Bufanda turquesa"; /* Nombre del producto. */

		String productDescripcion = " Hecha a mano con hilos de seda devanados y burdo"; /* Descripción del producto. */

		double productPrice = 20000; /* Precio del producto. */

		long productStock = 1; /* Stock disponible del producto. */

		String keywords = ""; /* Palabras clave relacionadas con el producto. */

		String productCaracteristc = "Elaborada a mano"; /* Características del producto. */

		String productPhoto = "https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/thumbnail_product-10-image-2-053b771e-b32f-4ba1-8952-db0a5f10182d.jpg";

		int categoryId = 2;

		String categoryName = "Bufandas";

		List<Product> products = new ArrayList<Product>();

		Category category = new Category(categoryId,categoryName, products);

		List<Category> categories = new ArrayList<Category>();

		Product newProd = new Product(productId, productName, productDescripcion, productPrice, productStock, keywords, productCaracteristc, productPhoto, categories);

		products.add(newProd);

		category.setProducts(products);

		categories.add(category);

		newProd.setCategories(categories);

		Product savedProd = repo.save(newProd);

		assertThat(savedProd).isNotNull();

		assertThat(savedProd.getProductId()).isGreaterThan(0);
	}

}
