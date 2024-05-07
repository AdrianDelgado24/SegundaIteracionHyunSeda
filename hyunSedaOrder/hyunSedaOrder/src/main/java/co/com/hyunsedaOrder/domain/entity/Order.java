package co.com.hyunsedaOrder.domain.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Funcionalidad basica de un cliente. Con ella el objeto cliente puede hacer operaciones de depósitos y retiros.
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders") //JPA->Java persistense API->iverneit motor
public class Order {
    //Contantes para definer los limites de las transacciones
    public static final double MIN_PRODUCTSQUANTITY = 1;
    public static final double MAX_PRODUCTSQUANTITY = 100;
    public static final double FREE_PRODUCTS_NOT_SENT = 1.00;
    public static final double FREE_PRODUCTS_RECEIVED = 2.00;
    public static final double FREE_PRODUCTS_PROCESSED = 3.00;
    public static final double FREE_PRODUCTS_EMBARKED = 4.00;
    public static final double FREE_PRODUCTS_SENT = 5.00;
    public static final double FREE_PRODUCTS_CANCELLED = 0.00;

    //public static final String ERR_OVERDRAW_LIMIT_EXCEED = "Error: Transaction cannot be processed. " + "Overdraw limit exceeded.";
    //Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_Id")
    private long orderId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_state_Id")
    private State objState;
	@Column(name = "client_Id")
    private long clientId;
	@Column(name = "products_Quantity")
    private double productsQuantity;

    public Order(long accountNum) {
    	clientId = accountNum; //Número de cuenta del usuario que hizo la orden
        objState = State.InitialState(this); //El estado de esa orden
    }

    public boolean shipment(double additionalProducts) {
        return getObjState().shipment(additionalProducts);
    }

}
