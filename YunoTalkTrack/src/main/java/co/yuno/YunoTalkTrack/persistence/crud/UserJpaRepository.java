package co.yuno.YunoTalkTrack.persistence.crud;

import co.yuno.YunoTalkTrack.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Integer> {
    Optional<User> findByNameIgnoreCase(String name);
}
