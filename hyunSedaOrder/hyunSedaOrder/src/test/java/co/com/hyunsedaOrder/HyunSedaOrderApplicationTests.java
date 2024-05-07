package co.com.hyunsedaOrder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import co.com.hyunsedaOrder.access.IOrderRepository;
import co.com.hyunsedaOrder.domain.entity.Order;
import co.com.hyunsedaOrder.domain.entity.State;

@SpringBootTest
class HyunSedaOrderApplicationTests {
	@Autowired
	private IOrderRepository repo;

	@Test
	public void testCreateProduct() {
		long orderId = 1;

		State objState = new State();

		long clientId =1;

		double productsQuantity = 1;

		Order newOrd = new Order(orderId, objState, clientId, productsQuantity);

		Order savedProd = repo.save(newOrd);

		assertThat(savedProd).isNotNull();

		assertThat(savedProd.getOrderId()).isGreaterThan(0);
	}

}
