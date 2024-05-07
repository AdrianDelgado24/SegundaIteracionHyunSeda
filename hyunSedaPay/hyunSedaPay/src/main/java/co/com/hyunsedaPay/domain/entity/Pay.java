package co.com.hyunsedaPay.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Pay {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pay_Id")
	private long payId;
	@Column(name = "pay_value")
	private double payValue;
	@Column(name = "client_id")
	private long clientId;
	@Column(name = "order_id")
	private long orderId;
}
