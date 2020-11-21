package newprojectspring.demo.repository;

import newprojectspring.demo.model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

}
