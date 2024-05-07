package co.com.hyunsedaPay.access;

import co.com.hyunsedaPay.domain.entity.Pay;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz  Objeto de Acceso a Datos de pagos
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
public interface IPayDao extends CrudRepository<Pay, Long> {
}
