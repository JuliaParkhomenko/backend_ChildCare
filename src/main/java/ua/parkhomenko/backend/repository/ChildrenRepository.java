package ua.parkhomenko.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.parkhomenko.backend.model.Child;

import java.util.List;

@Repository
public interface ChildrenRepository extends JpaRepository<Child, Integer> {
    @Query(value = "SELECT * FROM child WHERE child_id IN " +
            "(SELECT child_id FROM child_relative WHERE relative_email=:relative_email)", nativeQuery = true)
    List<Child> getAllChildrenOfRelative(@Param("relative_email") String relativeEmail);

    @Query(value = "SELECT educator_email FROM group_educator WHERE group_id=:group_id", nativeQuery = true)
    List<String> getAllChildEducatorsEmails(@Param("group_id") Integer groupId);
}