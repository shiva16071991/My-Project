package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Account;
import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<Account, Object>{

    public Optional<Account> findByAccountName(String accountName);

    List<Account> findAllByAccountName(String accountName);
}
