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
public class AlertTriggerValues {
    @Id
    @GenericGenerator(name = "trigger_values_id_generator", strategy = "increment")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "trigger_values_id_generator")
    @Column(name = "TriggerValuesId", nullable = false)
    private Integer TriggerValuesId;

    @Column(name = "MaxTemperature", nullable = false)
    private Integer MaxTemperature;

    @Column(name = "MaxPulse", nullable = false)
    private Integer MaxPulse;

    @Column(name = "MinTemperature", nullable = false)
    private Integer MinTemperature;

    @Column(name = "MinPulse", nullable = false)
    private Integer MinPulse;
}