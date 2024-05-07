package co.com.hyunsedaOrder.access;

import co.com.hyunsedaOrder.domain.entity.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz  Objeto de Acceso a Datos de ordenes
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
public interface IOrderDao extends CrudRepository<Order, Long> {
}