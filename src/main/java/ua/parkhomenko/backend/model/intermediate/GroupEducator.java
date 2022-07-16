package ua.parkhomenko.backend.model.intermediate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import ua.parkhomenko.backend.model.Educator;
import ua.parkhomenko.backend.model.EducationGroup;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class GroupEducator {
    @Id
    @GenericGenerator(name = "group_educator_id_generator", strategy = "increment")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "group_educator_id_generator")
    @Column(name = "GroupEducatorId", nullable = false)
    private Integer GroupEducatorId;

    @ManyToOne(targetEntity = Educator.class, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "EducatorEmail", nullable = false)
    private Educator Educator;

    @ManyToOne(targetEntity = EducationGroup.class, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "GroupId", nullable = false)
    private EducationGroup Group;
}