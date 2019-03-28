package pl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmail(String email);
    User findOneByLogin( String login);
}
