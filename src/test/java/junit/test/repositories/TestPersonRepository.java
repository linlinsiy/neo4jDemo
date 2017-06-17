package junit.test.repositories;

import com.lsy.SampleNeo4jDemoApplication;
import com.lsy.domain.Person;
import com.lsy.repositories.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lsy on 2017/6/13.
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest(classes = SampleNeo4jDemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class TestPersonRepository {

    @Autowired
    private Session session;
    @Autowired
    private PersonRepository personRepository;

    public TestPersonRepository() {
    }
    @Before
    public void setup(){
        Person joe = new Person("Joe");
        System.out.println(joe);
        Person bill = new Person("Bill");
        Person sara = new Person("Sara");
        Person derrick = new Person("Derrick");
        Person ian = new Person("Ian");
        Person jill = new Person("Jill");

        Person save = personRepository.save(joe);
        personRepository.save(bill);
        personRepository.save(sara);
        personRepository.save(derrick);
        personRepository.save(ian);
        personRepository.save(jill);
        System.out.println(save);
    }

    @Test
    public void findPerson(){
        Person joe = personRepository.findByName("Joe");
        System.out.println(joe);
    }
}
