package den.homework.homework_five.repository;

import den.homework.homework_five.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
