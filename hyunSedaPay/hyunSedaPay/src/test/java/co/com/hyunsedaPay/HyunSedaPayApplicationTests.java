package co.com.hyunsedaPay;

import co.com.hyunsedaPay.access.IPayRepository;
import co.com.hyunsedaPay.domain.entity.Pay;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HyunSedaPayApplicationTests {
	@Autowired
	private IPayRepository repo;

	@Test
	public void testCreatePay() {
		long payId = 1;

		double pay_value = 20000;

		long clientId = 1;

		long orderId = 1;

		Pay newPay = new Pay(payId, pay_value, clientId, orderId);

		Pay savedProd = repo.save(newPay);

		assertThat(savedProd).isNotNull();

		assertThat(savedProd.getPayId()).isGreaterThan(0);
	}

}
