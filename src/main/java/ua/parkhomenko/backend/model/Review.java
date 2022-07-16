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
public class Review {
    @Id
    @GenericGenerator(name = "review_id_generator", strategy = "increment")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "review_id_generator")
    @Column(name = "RelativeReviewId", nullable = false)
    private Integer RelativeReviewId;


    @ManyToOne(targetEntity = AlertMessage.class, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "AlertMessageId", nullable = false)
    private AlertMessage AlertMessage;

    @Column(name = "ReviewMessage", length = 200)
    private String ReviewMessage = "";

    @Column(name = "Mark", nullable = false)
    private Integer Mark = 5;

    @Column(name = "RelativeEmail", nullable = false, length = 100)
    private String RelativeEmail;
}