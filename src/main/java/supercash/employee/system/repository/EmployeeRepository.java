package supercash.employee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supercash.employee.system.model.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByCpf(String cpf);
    Optional<Employee> findByCpf(String cpf);
}
