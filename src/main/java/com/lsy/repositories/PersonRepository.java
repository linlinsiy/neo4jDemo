package com.lsy.repositories;

import com.lsy.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author pdtyreus
 * @author Mark Angrish
 */
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    Person findByName(@Param("name") String name);

    @Query("MATCH (p:Person)-[r:KNOWS]->(a:Person) RETURN p,r,a LIMIT {limit}")
    Collection<Person> graph(@Param("limit") int limit);
}
