package co.com.hyunsedaItem;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import co.com.hyunsedaItem.entity.Category;
import co.com.hyunsedaItem.entity.Product;
import co.com.hyunsedaItem.service.IProductClientRest;

@SpringBootTest
class HyunSedaItemProductApplicationTests {
	@Autowired
	private IProductClientRest repo;

	@Test
	public void testDetailProduct() {
		long id = 1;
		Product getRepoProd = repo.detail(id);

		assertThat(getRepoProd).isNotNull();

		assertThat(getRepoProd.getProductId()).isGreaterThan(0);
	}


}
