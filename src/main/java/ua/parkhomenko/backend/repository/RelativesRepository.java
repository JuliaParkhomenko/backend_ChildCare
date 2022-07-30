package ua.parkhomenko.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.parkhomenko.backend.model.Relative;

import java.util.List;

@Repository
public interface RelativesRepository extends JpaRepository<Relative, String> {
    @Query(value = "SELECT * FROM relative WHERE relative_id IN (SELECT relative_id FROM child_relative WHERE child_id=:child_id)", nativeQuery = true)
    List<Relative> getAllRelativesByChild(@Param("child_id") Integer childId);
}
