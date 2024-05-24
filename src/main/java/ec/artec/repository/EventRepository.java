package ec.artec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.artec.model.entities.Events;

@Repository
public interface EventRepository extends JpaRepository<Events, Long> {

  @Query("FROM Events e WHERE e.code = :code")
  Events findByCode(@Param("code") String code);

  @Query("FROM Events e WHERE e.name = :name")
  Events findByName(@Param("name") String name);

}
