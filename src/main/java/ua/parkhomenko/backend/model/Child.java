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
public class Child {
    @Id
    @GenericGenerator(name = "child_id_generator", strategy = "increment")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "child_id_generator")
    @Column(name = "ChildId", nullable = false)
    private Integer ChildId;

    @ManyToOne(targetEntity = EducationGroup.class, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "GroupId", nullable = false)
    private EducationGroup Group;

    @Column(name = "Name", nullable = false, length = 20)
    private String Name = "";

    @Column(name = "Surname", nullable = false, length = 20)
    private String Surname = "";

    @Column(name = "Sex", nullable = false)
    private Integer Sex;

    @Column(name = "Age", nullable = false)
    private Integer Age;

    @Column(name = "Height", nullable = false)
    private Integer Height;

    @Column(name = "Weight", nullable = false)
    private Integer Weight;

    @Column(name = "NormalTemperature", nullable = false)
    private Float NormalTemperature;

    @OneToOne(targetEntity = AlertTriggerValues.class, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "TriggerValuesId", nullable = false)
    private AlertTriggerValues TriggerValues;
}