package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Account;
import com.example.demo.Entity.Statament;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.StatamentRepository;

@Service
public class StatamentService {

    @Autowired
    private StatamentRepository statamentRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Statament createStatament(String name,Double amount,String type){
        Optional<Account> byAccountName = accountRepository.findByAccountName(name);
        UUID accountNumber = byAccountName.get().getAccountNumber();
        String accNum = accountNumber.toString();
        Statament s = new Statament();
        s.setAccountNumber(accNum);
        s.setAmount(amount);
        s.setAmountType(type);
        s.setTransactionDate(LocalDateTime.now());
       Statament saveStatement = statamentRepository.save(s);
        Account account = byAccountName.get();
        Double currentAmount = 0.0;
        if(type.equals("DEBIT") && amount < account.getAmount()){
            Double previousAmount = account.getAmount();
            currentAmount = previousAmount - amount;
        }
        if(type.equals("CREDIT")){
            Double previousAmount = account.getAmount();
            currentAmount = previousAmount + amount;
        }
            account.setAmount(currentAmount);
            accountRepository.save(account);
            saveStatement.setCurrentBalance(currentAmount);

       return saveStatement;

    }

    public List<Statament> getAllStatamentsByName(String name){
        Optional<Account> byAccountName = accountRepository.findByAccountName(name);
        UUID accountNumber = byAccountName.get().getAccountNumber();
        String accNum = accountNumber.toString();
        return statamentRepository.findByAccountNumber(accNum);
    }
}
