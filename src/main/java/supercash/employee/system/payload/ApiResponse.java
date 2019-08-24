package supercash.employee.system.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ApiResponse {
    private Boolean success;
    private String message;
    private List<FieldError> errors;
}

