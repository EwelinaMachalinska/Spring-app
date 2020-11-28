package newprojectspring.demo.repository;


import newprojectspring.demo.model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

    List<Personnel> findPersonnelsBySickLeaveEquals(Boolean sickLeave);

    @Query(value = "SELECT p FROM personnel p where p.position = :position", nativeQuery = false)
    List<Personnel> selectAllPersonnelWithPositionEqualTo(@Param("position") String position);

    @Modifying // Pozwala na uzywanie INSERT, UPDATE, DELETE i DDL
    @Query(value = "UPDATE personnel p set p.sickLeave = false")
    @Transactional
    void updateAllPersonnelToBeHealthy();


}

