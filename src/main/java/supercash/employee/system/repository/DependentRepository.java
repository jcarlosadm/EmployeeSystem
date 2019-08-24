package supercash.employee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supercash.employee.system.model.Dependent;

public interface DependentRepository extends JpaRepository<Dependent, Long> {
}
