package supercash.employee.system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter @Setter
class Person {
    private String name;

    @Column(unique = true)
    private String cpf;
}
