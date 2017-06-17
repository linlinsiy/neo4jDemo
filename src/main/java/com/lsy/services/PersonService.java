package com.lsy.services;

import com.lsy.domain.Person;
import com.lsy.repositories.PersonRepository;
import com.lsy.utils.ToD3Format;
import org.neo4j.driver.v1.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;

/**
 * Created by lsy on 2017/6/13.
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Transactional(rollbackFor = Exception.class)
    public void setup(){
        Person joe = new Person("Joe");
        Person bill = new Person("Bill");
        Person sara = new Person("Sara");
        Person derrick = new Person("Derrick");
        Person ian = new Person("Ian");
        Person jill = new Person("Jill");
        joe.knowsSomeone(bill);
        joe.knowsSomeone(sara);
        sara.knowsSomeone(bill);
        sara.knowsSomeone(jill);
        sara.knowsSomeone(ian);
        bill.knowsSomeone(ian);
        bill.knowsSomeone(derrick);
        personRepository.save(joe);
        personRepository.save(bill);
        personRepository.save(sara);
        personRepository.save(derrick);
        personRepository.save(ian);
        personRepository.save(jill);


    }

    @Transactional(rollbackFor = Exception.class)
    public void purgeDatabase(){
        personRepository.deleteAll();
    }

    public Map<String,Object> graph(int limit) {
        Collection<Person> result = personRepository.graph(limit);
        return ToD3Format.getInstance().toD3Format(result);
    }
}
