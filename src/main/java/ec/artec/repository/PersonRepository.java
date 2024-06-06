package ec.artec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ec.artec.model.entities.Person;
import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
 
    @Query("FROM Person e WHERE e.userName = :userName")
    public Person findByUserName(String userName);
}
