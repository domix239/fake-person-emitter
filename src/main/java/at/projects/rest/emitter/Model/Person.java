package at.projects.rest.emitter.Model;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class Person {
    String id;
    String uid;
    String firstName;
    String lastName;
    Date birthDay;
    String street;
    String city;
    String state;
    String zipCode;
}
