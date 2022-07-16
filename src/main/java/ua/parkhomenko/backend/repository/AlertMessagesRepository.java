package ua.parkhomenko.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.parkhomenko.backend.model.AlertMessage;
import ua.parkhomenko.backend.model.Child;

import java.util.List;

@Repository
public interface AlertMessagesRepository extends JpaRepository<AlertMessage, Integer> {
    @Query(value = "SELECT * FROM alert_message WHERE child_id=:child_id", nativeQuery = true)
    List<AlertMessage> getAllChildAlerts(@Param("child_id") Integer childId);
}