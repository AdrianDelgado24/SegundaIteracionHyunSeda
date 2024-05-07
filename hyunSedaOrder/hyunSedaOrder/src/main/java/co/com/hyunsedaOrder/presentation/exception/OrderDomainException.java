package co.com.hyunsedaOrder.presentation.exception;

import java.util.List;

/**
 * Lista de errores del dominio para una orden
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
public class OrderDomainException extends Exception {

    /** Listado de errores*/
    public final List<OrderError> errors;
    public OrderDomainException(List<OrderError> errors) {
        this.errors = errors;
    }
}
