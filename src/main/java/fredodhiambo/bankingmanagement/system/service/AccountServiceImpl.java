package fredodhiambo.bankingmanagement.system.service;

import fredodhiambo.bankingmanagement.system.entity.Account;
import fredodhiambo.bankingmanagement.system.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> getAccountByAccountNumber(Long accountNumber) {

        return accountRepository.findById(accountNumber);
    }

    @Override
    public List<Account> getAllAccounts() {

        return accountRepository.findAll();
    }

    @Override
    public Account withdraw(Long accountNumber, double amount) {

        Account account = accountRepository
                .findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account unavailable!!"));

        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient funds to make this transaction!!");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        return account;
    }

    @Override
    public Account deposit(Long accountNumber, double amount) {
        Account account = accountRepository
                .findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account unavailable!!"));

        double total = account.getBalance() + amount;
        account.setBalance(total);

        return account;
    }

    @Override
    public Optional<Account> delete(Long accountNumber) {
        Account account = accountRepository
                .findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account unavailable!!"));
        return accountRepository.findById(accountNumber);
    }
}
