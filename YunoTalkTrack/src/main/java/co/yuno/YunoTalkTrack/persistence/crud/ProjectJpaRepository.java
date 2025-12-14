package co.yuno.YunoTalkTrack.persistence.crud;


import co.yuno.YunoTalkTrack.persistence.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectJpaRepository extends JpaRepository<Project, Integer> {
    Optional<Project> findByNameIgnoreCase(String name);
}
