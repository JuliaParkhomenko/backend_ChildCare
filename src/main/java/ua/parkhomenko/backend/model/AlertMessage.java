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
public class AlertMessage {
    @Id
    @GenericGenerator(name = "alert_message_id_generator", strategy = "increment")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "alert_message_id_generator")
    @Column(name = "AlertMessageId", nullable = false)
    private Integer AlertMessageId;

    @ManyToOne(targetEntity = Child.class, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ChildId", nullable = false)
    private Child Child;

    @Column(name = "CriticalTemperatureReached", nullable = false)
    private Float CriticalTemperatureReached;

    @Column(name = "CriticalPulseReached", nullable = false)
    private Integer CriticalPulseReached;

    @Column(name = "AvgTemperatureReached", nullable = false)
    private Float AverageTemperatureReached;

    @Column(name = "AvgPulseReached", nullable = false)
    private Integer AveragePulseReached;

    @Column(name = "AlertMessage", nullable = false, length = 100)
    private String AlertMessage;

    @Column(name = "EducatorReviewMessage", nullable = false, length = 200)
    private String EducatorReviewMessage;
}