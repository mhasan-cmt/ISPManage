package dev.mhasan.ispmanage.resource;

import dev.mhasan.ispmanage.entity.Customer;
import dev.mhasan.ispmanage.response.ResponseHandler;
import dev.mhasan.ispmanage.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @PostMapping("/customer")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer){
//        if (customerService.addCustomer(customer)!=null){
//            return ResponseHandler.generateResponse("Successfully added a customer!", HttpStatus.OK, customer);
//        }
        return ResponseHandler.generateResponse("Failed to add a customer!", HttpStatus.MULTI_STATUS, null);
    }

    @GetMapping("/customer")
    public ResponseEntity<Object> getAllCustomer(){
        List<Customer> customers = customerService.getCustomerList();
        if (customers.isEmpty()){
            return ResponseHandler.generateResponse("NO DATA FOUND!", HttpStatus.NO_CONTENT, null);
        }
        return ResponseHandler.generateResponse("Customers", HttpStatus.OK, customers);
    }
}
