package newprojectspring.demo.controller;

import lombok.extern.slf4j.Slf4j;
import newprojectspring.demo.model.Customer;
import newprojectspring.demo.model.Personnel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class CustomerController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/hotel/customer")
    public void addClient(@RequestBody Customer customer) {
        log.info(customer.toString());
    }

    @RequestMapping(value = "/personnel/info", method = RequestMethod.PUT)
    public @ResponseBody
    String updatePersonnel(@RequestBody Personnel personnel){
        log.info(personnel.toString());
        return "ok";
    }
}
