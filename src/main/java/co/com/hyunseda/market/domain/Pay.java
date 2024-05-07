package co.com.hyunseda.market.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pay {
    
    @JsonProperty("payId")
    private long payId;
    
    @JsonProperty("payValue")
    private double totalPago;
    private String codigoCuenta;
  
    /**
     * Código del país donde será entregado el producto.
     * */
    private String plataformaPago;

    public Pay(long payId, double totalPago, String codigoCuenta, String plataformaPago) {
        this.payId = payId;
        this.totalPago = totalPago;
        this.codigoCuenta = codigoCuenta;
        this.plataformaPago = plataformaPago;
    }
   public Pay (){
       
   }

    public long getPayId() {
        return payId;
    }

    public void setPayId(long payId) {
        this.payId = payId;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getPlataformaPago() {
        return plataformaPago;
    }

    public void setPlataformaPago(String plataformaPago) {
        this.plataformaPago = plataformaPago;
    }

  
    
}
