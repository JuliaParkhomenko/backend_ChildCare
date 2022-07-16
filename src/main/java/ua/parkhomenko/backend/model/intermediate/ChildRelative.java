package ua.parkhomenko.backend.model.intermediate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import ua.parkhomenko.backend.model.Child;
import ua.parkhomenko.backend.model.Relative;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class ChildRelative {
    @Id
    @GenericGenerator(name = "child_relative_id_generator", strategy = "increment")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "child_relative_id_generator")
    @Column(name = "ChildRelativeId", nullable = false)
    private Integer ChildRelativeId;

    @ManyToOne(targetEntity = Relative.class, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "RelativeEmail", nullable = false)
    private Relative Relative;

    @ManyToOne(targetEntity = Child.class, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ChildId", nullable = false)
    private Child Child;
}