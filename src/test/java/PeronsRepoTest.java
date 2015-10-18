import com.denis.models.Person;
import com.denis.repos.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by denis on 10/18/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-config.xml"})
public class PeronsRepoTest {


    @Autowired
    PersonRepository personRepository;

    @Test
    public void test(){

        Person person = new Person();
        person.setName("Denis");
        person.setEmail("dfisenko@costco.com");
        personRepository.save(person);

        List<Person> persons  =personRepository.findAll();
        System.out.println(person);
        assertNotNull(persons);
        assertTrue(persons.size() == 1);


        Person p = personRepository.findByName("Denis");
        assertTrue(person.getEmail().equals(p.getEmail()));


    }

}
