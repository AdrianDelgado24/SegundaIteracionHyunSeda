package co.com.hyunsedaPay.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import co.com.hyunsedaPay.domain.entity.Pay;
import co.com.hyunsedaPay.domain.service.IPayService;
import co.com.hyunsedaPay.presentation.exception.PayDomainException;
import co.com.hyunsedaPay.presentation.exception.ResourceNotFoundException;
import java.util.List;

/**
 * 
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
/**Servicios web de pagos*/

@RestController
@RequestMapping("payments")
public class PayController {
    @Autowired
    private IPayService payService;

    /**
     * Listar todos
     * @return listado de pagos en json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Pay> findAll() {
        return (List<Pay>) payService.findAll();
    }

    /**
     * Listar un pago por id
     * @param id codigo
     * @return Pagp en formato json
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Pay findById(@PathVariable Long id) throws ResourceNotFoundException {

        Pay pay = payService.findById(id);
        return pay;
    }

    /**
     * Crear un pago
     * @param pay pago
     * @return pago creado
     */

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Pay create(@RequestBody Pay pay) throws PayDomainException {
        return payService.create(pay);
    }

    /**
     * Editar
     * @param pay Pagp a editar
     * @param id      codigo del pago
     * @return pago editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Pay update(@RequestBody Pay pay, @PathVariable Long id)
            throws PayDomainException, ResourceNotFoundException {
        return payService.update(id, pay);
    }

    /**
     * Eliminar
     * @param id codigo del pago
     * @throws ResourceNotFoundException id no encontrado
     */

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        payService.deleteById(id);
    }
}
