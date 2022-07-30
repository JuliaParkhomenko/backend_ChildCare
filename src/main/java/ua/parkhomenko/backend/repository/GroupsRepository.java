package ua.parkhomenko.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.parkhomenko.backend.model.EducationGroup;
import ua.parkhomenko.backend.model.Review;

import java.util.List;

@Repository
public interface GroupsRepository extends JpaRepository<EducationGroup, Integer> {
}