package co.com.hyunsedaOrder.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import co.com.hyunsedaOrder.domain.entity.Order;
import co.com.hyunsedaOrder.domain.service.IOrderService;
import co.com.hyunsedaOrder.presentation.exception.OrderDomainException;
import co.com.hyunsedaOrder.presentation.exception.ResourceNotFoundException;
import co.com.hyunsedaOrder.domain.entity.Pay;

import java.util.List;

/**
 * 
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
/**Servicios web de ordens*/

@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    /**
     * Listar todos
     * @return listado de ordens en json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Order> findAll() {
        return (List<Order>) orderService.findAll();
    }

    /**
     * Listar una orden por id
     * @param id codigo
     * @return Orden en formato json
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Order findById(@PathVariable Long id) throws ResourceNotFoundException {

        Order order = orderService.findById(id);
        return order;
    }

    /**
     * Crear una orden
     * @param order orden
     * @return orden creado
     */

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Order create(@RequestBody Order order) throws OrderDomainException {
        return orderService.create(order);
    }
    
    /**
     * Crear un pago
     * @param pay pago
     * @return pago creado
     */

    @RequestMapping(value = "/pay/{orderId}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Pay create(@PathVariable Long orderId, @RequestBody Pay pay) throws Exception {
        return orderService.create(orderId, pay);
    }
    
    /**
     * Editar
     * @param order Orden a editar
     * @param id      codigo de la orden
     * @return orden editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Order update(@RequestBody Order order, @PathVariable Long id)
            throws OrderDomainException, ResourceNotFoundException {
        return orderService.update(id, order);
    }

    /**
     * Eliminar
     * @param id codigo de la orden
     * @throws ResourceNotFoundException id no encontrado
     */

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        orderService.deleteById(id);
    }
}
