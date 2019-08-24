package supercash.employee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supercash.employee.system.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findByIdIn(List<Long> userIds);
    boolean existsByEmail(String email);
}
