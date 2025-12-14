package co.yuno.YunoTalkTrack.persistence.crud;

import co.yuno.YunoTalkTrack.persistence.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryJpaRepository extends JpaRepository<Country, Integer> {

    Optional<Country> findByNameIgnoreCase(String name);

    List<Country> findAllByNameContainingIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);
}
