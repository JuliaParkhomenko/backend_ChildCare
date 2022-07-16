package ua.parkhomenko.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.parkhomenko.backend.model.Child;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChildForRelativeDTO {
    private String Name;
    private String Surname;
    private Integer GroupId;
    private Integer Room;

    public static ChildForRelativeDTO packChild(Child child) {
        return new ChildForRelativeDTO(
                child.getName(),
                child.getSurname(),
                child.getGroup().getGroupId(),
                child.getGroup().getRoom()
        );
    }
}
