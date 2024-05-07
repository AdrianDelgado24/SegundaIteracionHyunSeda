package co.com.hyunsedaPay.presentation.exception;

import java.util.List;

/**
 * 
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
/**
 * Lista de errores del dominio para un pago
 */

public class PayDomainException extends Exception {

    /** Listado de errores*/
    public final List<PayError> errors;
    public PayDomainException(List<PayError> errors) {
        this.errors = errors;
    }
}
