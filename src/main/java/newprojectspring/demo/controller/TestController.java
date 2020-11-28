package newprojectspring.demo.controller;


import newprojectspring.demo.model.Personnel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
@ResponseBody
public class TestController {

    //@RequestMapping(method = RequestMethod.GET, path = "/api/hello")
    //public ResponseEntity<String> sayHello(){
    //    return ResponseEntity.ok("Hello");
    //}

    //@RequestMapping(method = RequestMethod.GET, path = "/api/hello2")
    //public String sayHello2(){
     //   return "Hello2";
   // }

    //@RequestMapping(method = RequestMethod.GET, path = "/api/hello/{name}")
   // public String sayHello(@PathVariable String name){
    //    return "Hello " + name;
   // }
    //@RequestMapping(method = RequestMethod.GET, path = "/api/hello/{name}/{age}")
    //public String YourAge(@PathVariable String name, @PathVariable Integer age){
     //   return "Hello " + name + "mam " + age;
   // }

    //@RequestMapping(method = RequestMethod.GET, path = "/api/hello")
   // public Personnel sayHello(){
      //  return new Personnel(100L, "Jacek", "Warzycha", "Parkingowy", LocalDate.parse("2000-11-13"), 3500.0, false );

   // }
}
