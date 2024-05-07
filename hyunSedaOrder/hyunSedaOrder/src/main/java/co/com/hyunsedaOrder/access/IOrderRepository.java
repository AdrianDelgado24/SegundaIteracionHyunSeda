package co.com.hyunsedaOrder.access;

import co.com.hyunsedaOrder.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * Contiene las API para operaciones CRUD básicas, las API para paginación y las API para clasificación mediante JpaRepository.
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
public interface IOrderRepository extends JpaRepository<Order,Long> {
}
