package hw6.pages.enteties;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@AllArgsConstructor
public class JdiUser {
    private String numberType;
    private String user;
    private String description;

    @Override
    public String toString() {
        return "JdiUser{" +
                "numberType='" + numberType + '\'' +
                ", user='" + user + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof JdiUser)) {
            return false;
        }

        JdiUser jdiUser = (JdiUser) o;
        return Objects.equals(numberType, jdiUser.numberType) &&
                Objects.equals(user, jdiUser.user) &&
                Objects.equals(description, jdiUser.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberType, user, description);
    }
}
