package ua.parkhomenko.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.parkhomenko.backend.model.AlertMessage;
import ua.parkhomenko.backend.model.Review;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Review, Integer> {
    @Query(value = "SELECT * FROM review WHERE alert_message_id=:alert_id", nativeQuery = true)
    List<Review> getAllReviewsForAlert(@Param("alert_id") Integer alertId);
}