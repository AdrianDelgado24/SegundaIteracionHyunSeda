package co.com.hyunsedaOrder.domain.service;

import java.util.List;
import co.com.hyunsedaOrder.domain.entity.Pay;
import co.com.hyunsedaOrder.domain.entity.Order;
import co.com.hyunsedaOrder.presentation.exception.OrderDomainException;
import co.com.hyunsedaOrder.presentation.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.Query;

/**
 * 
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
/**
 * Interfaz de operaciones de la base de datos de ordenes
 */
public interface IOrderService {

	List<Order> findAll();

	Order findById(Long id) throws ResourceNotFoundException;

	Order create(Order order) throws OrderDomainException;
	
	Pay create(long orderId, Pay pay) throws Exception;
	
	Order update(Long id, Order order) throws OrderDomainException, ResourceNotFoundException;

	void deleteById(Long id) throws ResourceNotFoundException;
}
