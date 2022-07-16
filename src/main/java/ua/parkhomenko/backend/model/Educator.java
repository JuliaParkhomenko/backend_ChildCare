package ua.parkhomenko.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import ua.parkhomenko.backend.model.intermediate.ChildRelative;
import ua.parkhomenko.backend.model.intermediate.GroupEducator;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Educator {
    @Id
    @GenericGenerator(name = "educator_email_generator", strategy = "increment")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "educator_email_generator")
    @Column(name = "EducatorEmail", nullable = false, length = 100)
    private String EducatorEmail = "";

    @Column(name = "Pwd", nullable = false, length = 20)
    private String Password = "";

    @Column(name = "Name", nullable = false, length = 20)
    private String Name = "";

    @Column(name = "Surname", nullable = false, length = 20)
    private String Surname = "";
}