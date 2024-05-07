package co.com.hyunsedaOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import co.com.hyunsedaOrder.domain.entity.Order;

/**
 * Clase encargada de iniciar el microservicio
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
@SpringBootApplication
@EnableFeignClients
public class HyunSedaOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyunSedaOrderApplication.class, args);

		Order or = new Order(454001);
		or.shipment(7);

		System.out.println("Total products (Not sent state):" + or.getProductsQuantity());

		or.shipment(8);
		System.out.println("Total products (Received state):" + or.getProductsQuantity());

		or.shipment(9);
		System.out.println("Total products (Processed state):" + or.getProductsQuantity());

		or.shipment(10);
		System.out.println("Total products (Embarked state):" + or.getProductsQuantity());

		or.shipment(11);
		System.out.println("Total products (Sent state):" + or.getProductsQuantity());

		or.shipment(12);
		System.out.println("Total products (Cancelled state):" + or.getProductsQuantity());
	}

}
