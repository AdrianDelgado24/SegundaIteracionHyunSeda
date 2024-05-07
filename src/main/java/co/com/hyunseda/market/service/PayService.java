/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.service;


import co.com.hyunseda.market.domain.Pay;
import co.com.hyunseda.market.domain.Product;
import co.com.hyunseda.market.domain.acess.IPayRepository;
import java.util.ArrayList;
import java.util.List;



/**
 *
 *
 */
public class PayService {
    
    private Pay pay;
    private IPayRepository repository;
    
    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de IProductRepository
     */
    public PayService(IPayRepository repository) {
        this.repository = repository; 
    }

    public boolean savePay(long payId,double totalPago) {
        
        Pay newPay = new Pay();
        
        newPay.setPayId(payId);
        newPay.setTotalPago(totalPago);
       
        if (newPay.getPayId() < 0 ) {
            return false;
        }
        
        return repository.save(newPay);
    }    
    public List<Pay> findAllPay() {
         List<Pay> pays = new ArrayList<>();
         pays = repository.findAll();
         return pays;
     }
    
    
    public boolean editProduct(int payId, Product pay) {
        
        /*//Validate product
        if (pay == null || pay.getProductName().isEmpty() ) {
            return false;
        }
        repository.edit(productId, prod);*/
        return true;
    }
    
    public boolean deleteProduct(int productId){
        return repository.delete(productId);
    }
       
    
   public Pay findProductById(int payId) {
        return repository.findById(payId);
    }

}
