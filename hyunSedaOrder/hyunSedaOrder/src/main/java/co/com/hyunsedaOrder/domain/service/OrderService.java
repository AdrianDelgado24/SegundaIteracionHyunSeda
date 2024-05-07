package co.com.hyunsedaOrder.domain.service;

import co.com.hyunsedaOrder.access.IOrderDao;
import co.com.hyunsedaOrder.domain.entity.Order;
import co.com.hyunsedaOrder.domain.entity.Pay;
import co.com.hyunsedaOrder.domain.service.feignclients.IItemProductClientRest;
import co.com.hyunsedaOrder.domain.service.feignclients.IPayClientRest;
import co.com.hyunsedaOrder.presentation.exception.OrderDomainException;
import co.com.hyunsedaOrder.presentation.exception.OrderError;
import co.com.hyunsedaOrder.presentation.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
@Service
public class OrderService implements IOrderService {

	/**
	 * Inyección de orden Dao
	 */
	@Autowired // permite realizar la inyección de dependencia
	private IOrderDao orderDao;
	@Autowired
	private IPayClientRest payFeignClient;
	@Autowired
	private IItemProductClientRest itemProductFeignClient;

	/**
	 * Servicio para buscar todas las ordenes
	 *
	 * @return Listado de ordenes
	 */
	@Override
	@Transactional(readOnly = true) // Para que esté sincronizada con la base de datos
	public List<Order> findAll() {
		return (List<Order>) orderDao.findAll();
	}

	/**
	 * Busca una orden por su Id
	 *
	 * @param id código de la orden
	 * @return objeto de tipo orden
	 */
	@Override
	public Order findById(Long id) throws ResourceNotFoundException {
		Order order = orderDao.findById(id).orElse(null);
		if (order == null) {
			throw new ResourceNotFoundException();
		}
		return order;
	}

	/**
	 * Crea una nueva orden
	 *
	 * @param order orden a crear en la base de datos
	 * @return Orden creada
	 */
	@Override
	@Transactional
	public Order create(Order order) throws OrderDomainException {
		List<OrderError> errors = validateDomain(order);
		if (!errors.isEmpty()) {
			throw new OrderDomainException(errors);
		}
		return orderDao.save(order);
	}

	/**
	 * Crea una nueva orden
	 *
	 * @param pay pago a crear en la base de datos
	 * @return Pago creado
	 * @throws Exception 
	 */
	@Override
	@Transactional
	public Pay create(long orderId, Pay pay) throws Exception {
		pay.setOrderId(orderId);
		Pay newPay = payFeignClient.create(pay);
		return newPay;
	}
	
	/**
	 * Modifica o edita una orden
	 *
	 * @param id,   código de la orden a modificar
	 * @param order orden con los datos a editar
	 * @return Orden modificada
	 */
	@Override
	@Transactional
	public Order update(Long id, Order order) throws OrderDomainException, ResourceNotFoundException {
		Order ord = this.findById(id);
		if (order == null) {
			throw new ResourceNotFoundException();
		}

		List<OrderError> errors = validateDomain(order);

		if (!errors.isEmpty()) {
			throw new OrderDomainException(errors);
		}
		  ord.setClientId(order.getClientId());
		  ord.setObjState(order.getObjState());
		  ord.setProductsQuantity(order.getProductsQuantity());
		return orderDao.save(ord);
	}

	/**
	 * Aplica validaciones o reglas del dominio para una orden. Antes de ser
	 * agregado o modificado.
	 *
	 * @param order orden a validar
	 * @return lista de errores de validación
	 */

	private List<OrderError> validateDomain(Order order) {
		List<OrderError> errors = new ArrayList<>();
		if (order.getOrderId() <= 0) { 
			errors.add(new OrderError(ErrorCodes.INVALID_NUMBER, "código",
					"El código de la orden es obligatorio y mayor a cero")); 
		}
		if (order.getClientId() <= 0) { 
			errors.add(new OrderError(ErrorCodes.INVALID_NUMBER, "código",
					"El código del cliente de la orden es obligatorio y mayor a cero")); 
		}
        if (order.getObjState() == null) {
            errors.add(new OrderError(ErrorCodes.EMPTY_FIELD, "state", "El estado del producto es obligatorio"));
        }
		return errors;
	}

	/**
	 * Eliminar orden por su id
	 *
	 * @param id identificador de la orden a eliminar
	 */
	@Override
	@Transactional
	public void deleteById(Long id) throws ResourceNotFoundException {
		Order order = this.findById(id);
		if (order == null) {
			throw new ResourceNotFoundException();
		}
		orderDao.deleteById(id);
	}
}