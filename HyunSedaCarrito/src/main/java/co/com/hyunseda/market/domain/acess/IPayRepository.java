/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.hyunseda.market.domain.acess;

import co.com.hyunseda.market.domain.Pay;
import java.util.List;

/**
 *
 * 
 */
public interface IPayRepository {
    
    List<Pay> findAll();
    Pay findById(int productId);
    boolean save(Pay newPay); //Lo guarda en un repositorio
   
    boolean edit(int payId, Pay pay);
    boolean delete(int payId);
    
}
