package conta.banco.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import conta.banco.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

    boolean existsByAccountNumber(String accountNumber);
}
