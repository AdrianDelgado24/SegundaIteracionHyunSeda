package co.com.hyunsedaOrder.domain.entity;


/**
 * Estado de la orden procesado: Recibe 3 productos gratis
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
public class ProcessedState extends State {
    public void sendMailToAccountHolder() {
        System.out.println("Attention: Your order has been processed");
    }

    public ProcessedState(Order account) {
        super(account);
        sendMailToAccountHolder();
    }

    public ProcessedState(State source) {
        super(source);
        sendMailToAccountHolder();
    }

    public State transitionState() {
        double productsQuantity = getContext().getProductsQuantity();
        if (productsQuantity > Order.MIN_PRODUCTSQUANTITY && productsQuantity < Order.MAX_PRODUCTSQUANTITY) {
            getContext().setObjState(new EmbarkedState(this));
        }else {
            getContext().setObjState(new CancelledState(this));
        }
        return getContext().getObjState();
    }

    public boolean shipment(double additionalProducts) {
        double productsQuantity = getContext().getProductsQuantity();
        getContext().setProductsQuantity(productsQuantity + Order.FREE_PRODUCTS_PROCESSED);
        System.out.println("You will receive 3 free products due to your order status (Received)");
        return super.shipment(additionalProducts);
    }
	/*
	public boolean withdraw(double amount) {
		double balance = getContext().getBalance();
		if ((balance - Order.TRANS_FEE_OVERDRAW - amount) > Order.OVERDRAW_LIMIT) {
			getContext().setBalance(
					balance - Order.TRANS_FEE_OVERDRAW);
			System.out.println("Transaction Fee was charged due to "
					+ "account status(Overdrawn)");
			return super.withdraw(amount);
		} else {
			System.out.println(Order.ERR_OVERDRAW_LIMIT_EXCEED);
			return false;
		}
	}

	 */
}
