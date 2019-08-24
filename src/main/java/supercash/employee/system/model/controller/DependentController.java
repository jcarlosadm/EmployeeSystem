package supercash.employee.system.model.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import supercash.employee.system.model.Dependent;
import supercash.employee.system.payload.ApiResponse;
import supercash.employee.system.repository.DependentRepository;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/dependent")
public class DependentController {
    private DependentRepository dependentRepository;

    public DependentController(DependentRepository dependentRepository) {
        this.dependentRepository = dependentRepository;
    }

    @GetMapping
    public List<Dependent> get() {
        return dependentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Dependent get(@PathVariable Long id) {
        return dependentRepository.findById(id).orElse(null);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public Dependent post(@Valid Dependent dependent) {
        if (dependent.getId() != null) { dependent.setId(null); }
        return dependentRepository.save(dependent);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public Dependent put(@Valid Dependent dependent) {
        checkId(dependent);
        return dependentRepository.save(dependent);
    }

    @DeleteMapping
    @PreAuthorize("hasRole('USER')")
    public ApiResponse delete(Dependent dependent) {
        checkId(dependent);
        dependentRepository.delete(dependent);
        return new ApiResponse(true, "dependent deleted", Collections.emptyList());
    }

    private void checkId(Dependent dependent) {
        if (dependent.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id cannot be null");
        }
    }
}
