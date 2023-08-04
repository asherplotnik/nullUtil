package com.util.nullUtil;

import com.util.nullUtil.model.Level;
import com.util.nullUtil.model.Occupation;
import com.util.nullUtil.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static com.util.nullUtil.NullUtil.getObjectOrNull;
import static com.util.nullUtil.NullUtil.getOptional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NullUtilTest {

    @Test
    void testNullUtil_success() {
        var person = Person
                .builder()
                .name("asher")
                .birthdate(LocalDate.of(1990, 01, 01))
                .id(1)
                .male(true)
                .occupation(getOccupation("programmer", Level.builder().category(2).build()))
                .children(getChildren())
                .build();
        Person person2 = Person.builder().build();
        Person person3 = getNullPerson();

        assertNotNull(getObjectOrNull(() -> person.getOccupation().getLevel().getCategory()));
        assertNotNull(getObjectOrNull(() -> person.getChildren().get(1).getOccupation().getLevel()));
        assertNotNull(getObjectOrNull(() -> person.getChildren().get(1).getOccupation()));
        assertNull(getObjectOrNull(() -> person.getChildren().get(0).getOccupation().getLevel()));
        assertNull(getObjectOrNull(() -> person.getChildren().get(4).getOccupation().getLevel()));
        assertNull(getObjectOrNull(() -> person2.getChildren().get(0).getOccupation().getLevel()));
        assertNull(getObjectOrNull(() -> person3.getChildren().get(0).getOccupation().getLevel()));
        assertNull(getObjectOrNull(() -> person3.getChildren()));
        assertNull(getOptional(() -> person.getChildren().get(0).getOccupation().getLevel()).orElse(null));
        assertNotNull(getOptional(() -> person.getChildren().get(1).getOccupation().getLevel()).orElse(null));
    }


    private static Person getNullPerson() {
        return null;
    }

    private static Occupation getOccupation(String name, Level level) {
        return Occupation
                .builder()
                .name(name)
                .level(level)
                .build();
    }

    private static List<Person> getChildren() {
        var occupation = Occupation
                .builder()
                .name("gardner")
                .level(Level.builder().category(2).build())
                .build();
        var child1 = Person
                .builder()
                .name("emma")
                .birthdate(LocalDate.of(2015, 01, 01))
                .id(1)
                .male(false)
                .occupation(null)
                .build();
        var child2 = Person
                .builder()
                .name("bobi")
                .birthdate(LocalDate.of(2008, 01, 01))
                .id(1)
                .male(true)
                .occupation(occupation)
                .build();
        return Arrays.asList(child1, child2);
    }

}