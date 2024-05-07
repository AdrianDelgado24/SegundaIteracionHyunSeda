package co.com.hyunsedaOrder.domain.service.feignclients;

import java.util.List;

import co.com.hyunsedaOrder.domain.entity.ItemProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@FeignClient(name = "hyunSedaItemProduct", url = "localhost:8005")
public interface IItemProductClientRest {

	@GetMapping("/items/")
	public List<ItemProduct> findAll();

    @GetMapping("/items/{id}")
	public ItemProduct findById(@PathVariable Long id) throws Exception;

    @PostMapping("/items")
	public ItemProduct create(@RequestBody ItemProduct itemProduct) throws Exception;

    @PutMapping("/items/{id}")
	public ItemProduct update(@RequestBody ItemProduct itemProduct, @PathVariable Long id) throws Exception;

    @DeleteMapping("/eliminar/{id")
    public void delete(@PathVariable Long id) throws Exception;
}
