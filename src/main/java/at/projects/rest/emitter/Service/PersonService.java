package at.projects.rest.emitter.Service;

import at.projects.rest.emitter.Model.Person;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PersonService {

    private Person generatePerson(int id) {
        Faker faker = new Faker();
        return Person.builder()
                .id(String.valueOf(id))
                .uid(faker.hacker().abbreviation())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .birthDay(faker.date().birthday())
                .street(faker.address().streetAddress())
                .city(faker.address().city())
                .state(faker.address().state())
                .zipCode(faker.address().zipCode())
                .build();
    }

    public Flux<Person> returnPersons(Integer limit) {
        return Flux.range(1,limit)
                .map(this::generatePerson);
    }
}
