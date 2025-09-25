package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Statament;
import java.util.List;


@Repository
public interface StatamentRepository extends JpaRepository<Statament, Object> {

    List<Statament> findByAccountNumber(String accountNumber);
}
