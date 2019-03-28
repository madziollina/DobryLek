package pl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.entity.DrugsUsers;

import java.util.List;

public interface DrugsUsersRepository extends JpaRepository<DrugsUsers, Long> {
    DrugsUsers findOneByDrugIdAndUsersId(Long drug_id, Long user_id);
    List<DrugsUsers> findAllByUsersId(Long id);

}
