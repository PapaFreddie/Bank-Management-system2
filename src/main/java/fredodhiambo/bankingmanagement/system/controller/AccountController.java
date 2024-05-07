package fredodhiambo.bankingmanagement.system.controller;

import fredodhiambo.bankingmanagement.system.entity.Account;
import fredodhiambo.bankingmanagement.system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;


    //Add Account
    @PostMapping
    public Account addAccount(@RequestBody Account account){
        Account account1 = accountService.addAccount(account);
        return account1;
    }

    //Get account by account number

    @GetMapping("/{accountNumber}")
    public Optional<Account> getAccountByAccountNumber(@PathVariable Long accountNumber){
        Optional<Account> accountDetails = accountService.getAccountByAccountNumber(accountNumber);
       return accountDetails;

    }

    //get all accounts

    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    //Deposit amount

    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account deposit(@PathVariable Long accountNumber, @PathVariable double amount){
        return accountService.deposit(accountNumber, amount);
    }

    //witdraw amount
    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdraw(@PathVariable Long accountNumber, @PathVariable double amount){
        return accountService.withdraw(accountNumber, amount);
    }

    //deelete account

    @DeleteMapping("/{accountNumber}")
    public String delete(@PathVariable Long accountNumber){
        accountService.delete(accountNumber);

        return "Account deleted successfully!!!";
    }



}
