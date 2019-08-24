package supercash.employee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supercash.employee.system.model.Dependent;

import java.util.Optional;

public interface DependentRepository extends JpaRepository<Dependent, Long> {
    boolean existsByCpf(String cpf);
    Optional<Dependent> findByCpf(String cpf);
}
