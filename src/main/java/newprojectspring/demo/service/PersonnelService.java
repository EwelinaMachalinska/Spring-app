package newprojectspring.demo.service;

import newprojectspring.demo.model.Personnel;

import java.util.List;

public interface PersonnelService {

    Personnel getPersonnelById(Long id);

    List<Personnel> getAllPersonnel();

    boolean removePersonnelById(Long id);

    Personnel createNewPersonnel(Personnel personnel);

    List<Personnel> createBatchOfPersonnel(List<Personnel> personnels);

    Personnel updatePersonnelById(Long id, Personnel personnel);

}
