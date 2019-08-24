package supercash.employee.system.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import supercash.employee.system.model.category.Role;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "email"
        })
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;

    @NotBlank
    @NotNull
    private String name = "";

    private String lastName = "";

    @Column(unique = true)
    @NotBlank
    @NotNull
    private String email = "";

    @NotBlank
    @NotNull
    private String password = "";

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String name, String email, String lastName, String password) {
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.password = password;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}