package supercash.employee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supercash.employee.system.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
