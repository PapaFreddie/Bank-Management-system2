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
    public Account addAccount(Account account) {
        Account account1 = accountRepository.save(account);

        return account1;
    }

    @Override
    public Optional<Account> getAccountByAccountNumber(Long accountNumber) {
        Optional<Account> accountDetail = Optional.ofNullable(accountRepository
                .findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Ooops!! Account Not Available!!")));

        return accountDetail;
    }

    @Override
    public List<Account> getAllAccounts() {

        return accountRepository.findAll();
    }

    @Override
    public Account deposit(Long accountNumber, double amount) {
        Account account = accountRepository
                .findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account do not exist"));
        double total = account.getBalance() + amount;
        account.setBalance(total);

        return accountRepository.save(account);
    }

    @Override
    public Account withdraw(Long accountNumber, double amount) {
        Account account = accountRepository
                .findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account do not exist"));

        double total = account.getBalance() - amount;
        account.setBalance(total);

        return accountRepository.save(account);
    }

    @Override
    public void delete(Long accountNumber) {
        Account account = accountRepository
                .findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account do not exist"));
        accountRepository.deleteById(accountNumber);
    }


}
