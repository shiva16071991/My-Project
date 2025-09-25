package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Account;
import com.example.demo.Service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/save")
    public Account saveAccount(@RequestBody Account account){

        return accountService.saveAccount(account);
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }
}
