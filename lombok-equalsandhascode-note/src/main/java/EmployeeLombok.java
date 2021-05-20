import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@Builder
@EqualsAndHashCode
@Data
public class EmployeeLombok {
    private int id;
    private String dept;
    private String name;
}
