package ua.parkhomenko.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.parkhomenko.backend.model.Relative;

@Repository
public interface RelativesRepository extends JpaRepository<Relative, String> {
}
