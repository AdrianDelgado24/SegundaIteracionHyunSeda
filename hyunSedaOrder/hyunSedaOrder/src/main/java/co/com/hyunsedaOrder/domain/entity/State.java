package co.com.hyunsedaOrder.domain.entity;

import org.springframework.web.bind.annotation.GetMapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Define el comportamiento común de todas las cuentas. Es una clase base concreta.
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "states") //JPA->Java persistense API->iverneit motor
public class State {
	@Id
	@Column(name = "state_Id")
	private long stateId;
	@OneToOne(mappedBy = "objState")
    private Order context;

    public State(Order account) {
        setContext(account);
    }

    public Order getContext() {
        return context;
    }

    public void setContext(Order newAccount) {
        context = newAccount;
    }

    public State transitionState() {
        return null;
    }

    public State(State source) {
        setContext(source.getContext());
    }

    public static State InitialState(Order account) {
        return new NotSentState(account);
    }
    //deposito
    public boolean shipment(double additionalProducts) {
        double customerProducts = getContext().getProductsQuantity();
        getContext().setProductsQuantity(customerProducts + additionalProducts);
        transitionState();
        System.out.println("An amount of " + getContext().getProductsQuantity() + " will be delivered to your house");
        return true;
    }
	/*
	//Retiro
	public boolean withdraw(double amount) {
		double balance = getContext().getBalance();
		getContext().setBalance(balance - amount);
		transitionState();
		System.out.println("An amount " + amount + " is withdrawn ");
		return true;
	}

	 */
}
