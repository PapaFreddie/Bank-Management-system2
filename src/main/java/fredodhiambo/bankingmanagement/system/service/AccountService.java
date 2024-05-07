package fredodhiambo.bankingmanagement.system.service;

import fredodhiambo.bankingmanagement.system.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account addAccount(Account account);

    Optional<Account> getAccountByAccountNumber(Long accountNumber);

    List<Account> getAllAccounts();

    Account deposit(Long accountNumber, double amount);

    Account withdraw(Long accountNumber, double amount);

    void delete(Long accountNumber);
}
