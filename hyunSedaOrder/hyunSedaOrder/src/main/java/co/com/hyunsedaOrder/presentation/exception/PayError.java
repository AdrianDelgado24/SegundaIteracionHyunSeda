package co.com.hyunsedaOrder.presentation.exception;

import co.com.hyunsedaOrder.domain.service.ErrorCodes;

/**
 * 
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
/**
 *Error de un pago
 */

public class PayError {

    /**
     * Codigo del error
     */
    public final ErrorCodes code;
    /**
     * Campo del error
     */
    public final String field;
    /**
     * Descripción del error
     */
    public final String description;

    public PayError(ErrorCodes code, String field, String description) {
        this.code = code;
        this.field = field;
        this.description = description;
    }
}
