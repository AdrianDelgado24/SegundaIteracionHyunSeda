package co.com.hyunsedaOrder.domain.service.feignclients;

import java.util.List;

import co.com.hyunsedaOrder.domain.entity.Pay;
import co.com.hyunsedaOrder.presentation.exception.PayDomainException;
import co.com.hyunsedaOrder.presentation.exception.ResourceNotFoundException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "hyunSedaPay", url = "localhost:8004")
public interface IPayClientRest {

	@GetMapping("/payments/")
	public List<Pay> findAll();

    @GetMapping("/payments/{id}")
	public Pay findById(@PathVariable Long id) throws ResourceNotFoundException ;

    @PostMapping("/payments")
	public Pay create(@RequestBody Pay pay) throws PayDomainException;

    @PutMapping("/payments/{id}")
	public Pay update(@RequestBody Pay pay, @PathVariable Long id) throws ResourceNotFoundException;

    @DeleteMapping("/eliminar/{id")
    public void delete(@PathVariable Long id) throws ResourceNotFoundException;
}
