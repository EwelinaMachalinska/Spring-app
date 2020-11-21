package newprojectspring.demo.controller;

import lombok.extern.slf4j.Slf4j;
import newprojectspring.demo.model.Personnel;
import newprojectspring.demo.service.PersonnelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/hotel/personnel")
@Slf4j
public class PersonelController {

    private final PersonnelService personnelService;

    // Tu wstrzykujemy potrzebny serwis.
    public PersonelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    // Metoda adnotowana jako GetMapping zostanie wywolana na zadanie: localhost:<PORT>/hotel/personnel/<id>, gdzie id to numer pracownika
    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonnelById(@PathVariable Long id){
        Personnel personnel = personnelService.getPersonnelById(id);
        // Jezeli znalazlo pracownika to zwroc go.
        if(Objects.nonNull(personnel)){
            return ResponseEntity.ok(personnel);
        }
        // W innym przypadku powiedz ze nie znaleziono
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Personnel>> getPersonnel(){
        return ResponseEntity.ok(personnelService.getAllPersonnel());
    }

    // DeleteMapping powinien sluzyc do usuwania zasobow z serwisu. W tym przypadku jesli sie uda to 202 jesli nie to 400
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersonnel(@PathVariable Long id) {
        if (personnelService.removePersonnelById(id)) {
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.badRequest().build();

    }

    // PostMapping powinien sluzyc do tworzenia nowych zasobow. Jedna z metod z ktora mozemy wyslac body.
    @PostMapping("/batch")
    public ResponseEntity<?> createNewPersonnel(@RequestBody List<Personnel> personnels) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personnelService.createBatchOfPersonnel(personnels));
    }

   // @PutMapping(path = "/{id}")
   // public ResponseEntity<?> updatePersonnelById(@PathVariable Long id, @PathVariable Personnel personnel) {
    //    return ResponseEntity.status(HttpStatus.ACCEPTED).body(personnelService.updatePersonnelById(personnel));
   // }

//    @GetMapping
//    public List<Personnel> getAllPersonnel(@RequestParam(value = "id", required = false, defaultValue = "100") Long id) {
//        if (Objects.nonNull(id)) {
//            return Collections.singletonList(new Personnel(id, "Jacek", "Warzycha", "Parkingowy",
//                    LocalDate.parse("2000-11-13"), 3500.0, false));
//        }
//        return Collections.singletonList(new Personnel(5L, "Jacek", "Warzycha", "Parkingowy",
//                LocalDate.parse("2000-11-13"), 3500.0, false));
//    }
//
//    @PostMapping
//    public ResponseEntity<?> createNewPersonnel(@RequestBody Personnel personnel) {
//        personnel.setId(1000L);
//        return ResponseEntity.status(HttpStatus.CREATED).body(personnel);
//    }
//
//    @PutMapping("/{id}")
//    public Personnel updatePersonnel(@PathVariable Long id, @RequestBody Personnel personnel) {
//        if (id.equals(50000L)) {
//            log.info(personnel.toString());
//            personnel.setId(personnel.getId() + 1L);
//            return personnel;
//        }
//        return null;
//    }
}

