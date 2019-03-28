package pl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.entity.Connect;

public interface ConnectRepository extends JpaRepository<Connect, Long> {
    @Query("select c from Connect c where c.drug1 =:drug1 and c.drug2 =:drug2")
    Connect getByDrug1AndDrug2(@Param("drug1") String drug1, @Param("drug2") String drug2);

    Connect findOneByDrug1AndDrug2(String drug1, String drug2);



}
