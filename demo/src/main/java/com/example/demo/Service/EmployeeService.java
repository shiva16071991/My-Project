package com.example.demo.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeById(Integer id){
        return employeeRepository.findById(id).get();
    }

    public Employee savEmployee(String name, BigDecimal salary){
        Employee e = new Employee();
        e.setEName(name);
        e.setESalary(salary);
        employeeRepository.save(e);
        return e;
    }

    public List<Employee> getEmployeesBySalary(){
        List<Employee> empList = employeeRepository.findAll();
       List<Employee> list =  empList.stream().sorted(Comparator.comparing(Employee::getESalary, BigDecimal::compareTo)).toList();
       return list;
    }

}
