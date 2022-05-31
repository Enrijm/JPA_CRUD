package Domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    List<PersonEntity> findByName(String name);// ES SPRING BOOT EL QUE HACE EL CODIGO

    void deleteById(Integer id); // ES SPRING BOOT EL QUE HACE EL CODIGO
}
