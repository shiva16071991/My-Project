package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.CustomerRegistration;
import com.example.demo.Entity.Address;
import com.example.demo.Entity.Book;
import com.example.demo.Entity.Customer;
import com.example.demo.Entity.CustomerBookAudit;
import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.BookRepository;
import com.example.demo.Repository.CustomerBookAuditRepository;
import com.example.demo.Repository.CustomerRepository;

@Service
public class CustomerBookService {

    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final CustomerBookAuditRepository customerBookAuditRepository;


    public CustomerBookService(BookRepository bookRepository, CustomerRepository customerRepository, AddressRepository addressRepository, CustomerBookAuditRepository customerBookAuditRepository) {
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.customerBookAuditRepository = customerBookAuditRepository;
    }

    public Customer saveCustomerRegistration(CustomerRegistration customerRegistration){
        Customer customer = new Customer();
        customer.setName(customerRegistration.getCustomerName());
        customer.setEmail(customerRegistration.getEmail());
        customer.setPhone(customerRegistration.getPhone());
        customer = customerRepository.save(customer);
        Address address = new Address();
        address.setCustomerId(customer.getId());
        address.setArea(customerRegistration.getArea());
        address.setCity(customerRegistration.getCity());
        address.setHouseNumber(customerRegistration.getHouseNumber());
        address.setPincode(customerRegistration.getPincode());
        address.setState(customerRegistration.getState());
        addressRepository.save(address);
        return customer;
    }

    public List<Book> getAllBooks(){
       return bookRepository.findAll();
    }

    public Customer assignBookToCustomer(Book book, Long customerId, Integer days) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            CustomerBookAudit cba = new CustomerBookAudit();
            cba.setBookId(book.getId());
            cba.setCustomerId(customerId);
            cba.setDate(LocalDateTime.now());
            cba.setNumberOfDays(days);
            customerBookAuditRepository.save(cba);
            return customer.get();
        }
        return null;
    }

   public List<Customer> searchCustomersByBookName(String bookName){
    List<Customer> customerList = new ArrayList<>();
    Book book = bookRepository.findByBookName(bookName);
    List<CustomerBookAudit> list = customerBookAuditRepository.findByBookId(book.getId());
    List<Long> customerIds = list.stream().map(a -> a.getCustomerId()).collect(Collectors.toList());
    customerIds.stream().forEach(a -> {
        customerList.add(customerRepository.findById(a).get());
    });
    return customerList;
   }

   public List<Customer> searchCustomersByCategory(String category){
    List<CustomerBookAudit> list = customerBookAuditRepository.findByCategory(category);
    List<Customer> customerList = new ArrayList<>();
    List<Long> customerIds = list.stream().map(a -> a.getCustomerId()).collect(Collectors.toList());
    customerIds.stream().forEach(a -> {
        customerList.add(customerRepository.findById(a).get());
    });
    return customerList;
   }

   public List<Book> searchBooksByCategory(String category){
    List<Book> bookList = bookRepository.findByCategory(category);
    return bookList;
   }

}
