package co.com.hyunsedaPay.domain.service;

import co.com.hyunsedaPay.domain.entity.Pay;
import co.com.hyunsedaPay.presentation.exception.PayDomainException;
import co.com.hyunsedaPay.presentation.exception.ResourceNotFoundException;

import java.util.List;

/**
 * 
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
/**
 * Interfaz de operaciones de la base de datos de pago 
 */
public interface IPayService {

	List<Pay> findAll();

	Pay findById(Long id) throws ResourceNotFoundException;

	Pay create(Pay pay) throws PayDomainException;

	Pay update(Long id, Pay pay) throws PayDomainException, ResourceNotFoundException;

	void deleteById(Long id) throws ResourceNotFoundException;
}
