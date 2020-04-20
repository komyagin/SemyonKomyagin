package hw6.pages.enteties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class JdiUser {
    private String numberType;
    private String user;
    private String description;
}
