package fredodhiambo.bankingmanagement.system.repository;

import fredodhiambo.bankingmanagement.system.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
