package at.projects.rest.emitter.Controller;

import at.projects.rest.emitter.Model.Person;
import at.projects.rest.emitter.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class DataController {

    final PersonService personService;

    @Autowired
    public DataController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping(value = "/persons", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Person> returnPersons(@RequestParam(required = false, defaultValue = "1000") Integer limit) {
        return personService.returnPersons(limit);
    }
}
