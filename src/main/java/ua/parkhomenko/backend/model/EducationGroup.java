package ua.parkhomenko.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class EducationGroup {
    @Id
    @GenericGenerator(name = "group_id_generator", strategy = "increment")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "group_id_generator")
    @Column(name = "GroupId", nullable = false)
    private Integer GroupId;

    @Column(name = "SilentTimeStart", nullable = false)
    private Time SilentTimeStart;

    @Column(name = "SilentTimeEnd", nullable = false)
    private Time SilentTimeEnd;

    @Column(name = "Room", nullable = false)
    private Integer Room;
}