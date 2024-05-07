package fredodhiambo.bankingmanagement.system.service;

import fredodhiambo.bankingmanagement.system.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account createAccount(Account account);

    Optional<Account> getAccountByAccountNumber(Long accountNumber);

    List<Account> getAllAccounts();

    Account withdraw(Long accountNumber, double amount);

    Account deposit(Long accountNumber, double amount);

    Optional<Account> delete(Long accountNumber);
}
