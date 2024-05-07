package co.com.hyunsedaOrder.presentation.exception;

import co.com.hyunsedaOrder.domain.service.ErrorCodes;

/**
 * Error de una orden
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */


public class OrderError {

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

    public OrderError(ErrorCodes code, String field, String description) {
        this.code = code;
        this.field = field;
        this.description = description;
    }
}
