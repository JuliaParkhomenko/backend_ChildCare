package ua.parkhomenko.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Admin {
    @Id
    @GenericGenerator(name = "admin_email_generator", strategy = "increment")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "admin_email_generator")
    @Column(name = "AdminEmail", nullable = false, length = 100)
    private String AdminEmail = "";

    @Column(name = "Pwd", nullable = false, length = 20)
    private String Password = "";

    @Column(name = "Name", nullable = false, length = 20)
    private String Name = "";

    @Column(name = "Surname", nullable = false, length = 20)
    private String Surname = "";
}