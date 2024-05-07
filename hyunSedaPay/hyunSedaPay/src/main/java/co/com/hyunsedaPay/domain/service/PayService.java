package co.com.hyunsedaPay.domain.service;

import co.com.hyunsedaPay.access.IPayDao;
import co.com.hyunsedaPay.domain.entity.Pay;
import co.com.hyunsedaPay.presentation.exception.PayDomainException;
import co.com.hyunsedaPay.presentation.exception.PayError;
import co.com.hyunsedaPay.presentation.exception.ResourceNotFoundException;
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
public class PayService implements IPayService {

	/**
	 * Inyección de pago Dao
	 */
	@Autowired // permite realizar la inyección de dependencia
	private IPayDao payDao;

	/**
	 * Servicio para buscar todos las pagos
	 * 
	 * @return Listado de pagos
	 */
	@Override
	@Transactional(readOnly = true) // Para que esté sincronizada con la base de datos
	public List<Pay> findAll() {
		return (List<Pay>) payDao.findAll();
	}

	/**
	 * Busca una pago por su Id
	 * 
	 * @param id código del pago
	 * @return objeto de tipo pago
	 */
	@Override // Para que esté sincronizada con la base de datos
	public Pay findById(Long id) throws ResourceNotFoundException {
		Pay pago = payDao.findById(id).orElse(null);
		if (pago == null) {
			throw new ResourceNotFoundException();
		}
		return pago;
	}

	/**
	 * Crea una nueva pago
	 * 
	 * @param pay pago a crear en la base de datos
	 * @return Pago creada
	 */
	@Override
	@Transactional
	public Pay create(Pay pay) throws PayDomainException {
		List<PayError> errors = validateDomain(pay);
		if (!errors.isEmpty()) {
			throw new PayDomainException(errors);
		}
		return payDao.save(pay);
	}

	/**
	 * Modifica o edita una pago
	 * 
	 * @param id, código del pago a modificar
	 * @param pay pago con los datos a editar
	 * @return Pago modificado
	 */
	@Override
	@Transactional
	public Pay update(Long id, Pay pay) throws PayDomainException, ResourceNotFoundException {
		Pay pago = this.findById(id);
		if (pago == null) {
			throw new ResourceNotFoundException();
		}

		List<PayError> errors = validateDomain(pay);

		if (!errors.isEmpty()) {
			throw new PayDomainException(errors);
		}
		pago.setPayValue(pay.getPayValue());
		pago.setClientId(pay.getClientId());
		pago.setOrderId(pay.getOrderId());
		return payDao.save(pago);
	}

	/**
	 * Aplica validaciones o reglas del dominio para un Pago. Antes de ser agregado
	 * o modificado.
	 *
	 * @param pay pago a validar
	 * @return lista de errores de validación
	 */

	private List<PayError> validateDomain(Pay pay) {
		List<PayError> errors = new ArrayList<>();
		if (pay.getPayId() <= 0) {
			errors.add(new PayError(ErrorCodes.INVALID_NUMBER, "código",
					"El código del pago es obligatorio y mayor a cero"));
		}
		if (pay.getClientId() <= 0) {
			errors.add(new PayError(ErrorCodes.INVALID_NUMBER, "código",
					"El código del cliente es obligatorio y mayor a cero"));
		}
		if (pay.getOrderId() <= 0) {
			errors.add(new PayError(ErrorCodes.INVALID_NUMBER, "código",
					"El código de la orden es obligatorio y mayor a cero"));
		}
		if (pay.getPayValue() <= 0) {
			errors.add(new PayError(ErrorCodes.INVALID_NUMBER, "código",
					"El valor del pago es obligatorio y mayor a cero"));
		}
		return errors;
	}

	/**
	 * Eliminar pago por su id
	 * 
	 * @param id código del pago a eliminar
	 */
	@Override
	@Transactional
	public void deleteById(Long id) throws ResourceNotFoundException {
		Pay pago = this.findById(id);
		if (pago == null) {
			throw new ResourceNotFoundException();
		}
		payDao.deleteById(id);
	}
}