package pl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.entity.Drug;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug, Long> {
    Drug findOneByName(String name);
    Drug findOne(Long id);
    List<Drug> findAllByUsersId(Long id);
}
