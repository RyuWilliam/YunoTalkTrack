package co.yuno.n8nService.persistence.repository;

import co.yuno.n8nService.persistence.entity.Procesed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcesedRepository extends JpaRepository<Procesed, Integer> {

    List<Procesed> findByProjectNameAndIdProcesedLessThan(String projectName, Integer idProcesed);
}
