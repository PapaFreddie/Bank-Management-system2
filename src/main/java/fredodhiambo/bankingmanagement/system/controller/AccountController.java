package fredodhiambo.bankingmanagement.system.controller;

import fredodhiambo.bankingmanagement.system.entity.Account;
import fredodhiambo.bankingmanagement.system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //create account

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    //get by accountid
    @GetMapping("/{accountNumber}")
    public Optional<Account> getAccountByAccountNumber(@PathVariable Long accountNumber){
        return accountService.getAccountByAccountNumber(accountNumber);
    }

    //get all accounts

    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    //deposit

    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account deposit(@PathVariable Long accountNumber, @PathVariable double amount){
        return accountService.deposit(accountNumber,amount);
    }

    //withdraw

    @PutMapping("/withdraw/{accountNumber}/{amount}")

    public Account withdraw(@PathVariable Long accountNumber, @PathVariable double amount){
        return accountService.withdraw(accountNumber, amount);
    }

    @DeleteMapping("/delete/{accountNumber}")
    public Optional<Account> delete(@PathVariable Long accountNumber){
        return accountService.delete(accountNumber);
    }
}
