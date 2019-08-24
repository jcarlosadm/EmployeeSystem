package supercash.employee.system.model.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import supercash.employee.system.model.Employee;
import supercash.employee.system.payload.ApiResponse;
import supercash.employee.system.repository.EmployeeRepository;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> get() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public Employee post(@Valid Employee employee) {
        if (employee.getId() != null) { employee.setId(null); }
        return employeeRepository.save(employee);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public Employee put(@Valid Employee employee) {
        checkId(employee);
        return employeeRepository.save(employee);
    }

    @DeleteMapping
    @PreAuthorize("hasRole('USER')")
    public ApiResponse delete(@Valid Employee employee) {
        checkId(employee);
        employeeRepository.delete(employee);
        return new ApiResponse(true, "employee deleted", Collections.emptyList());
    }

    private void checkId(Employee employee) {
        if (employee.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id cannot be null");
        }
    }
}
