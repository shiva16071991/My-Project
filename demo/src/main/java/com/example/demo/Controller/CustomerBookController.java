package com.example.demo.Controller;

import java.util.List;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.CustomerRegistration;
import com.example.demo.Entity.Book;
import com.example.demo.Entity.Customer;
import com.example.demo.Service.CustomerBookService;

@RestController
@RequestMapping("/book/api")
public class CustomerBookController {

    private CustomerBookService customerBookService;


    public CustomerBookController(CustomerBookService customerBookService) {
        this.customerBookService = customerBookService;
    }

    public ResponseEntity<Customer> saveCustomerRegistration(CustomerRegistration customerRegistration){
        return ResponseEntity.ok(customerBookService.saveCustomerRegistration(customerRegistration));
    }

    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(customerBookService.getAllBooks());
    }

    public ResponseEntity<Customer> assignBookToCustomer(Book book, Long customerId, Integer days){
        return ResponseEntity.ok(customerBookService.assignBookToCustomer(book, customerId, days));
    } 

    

}
