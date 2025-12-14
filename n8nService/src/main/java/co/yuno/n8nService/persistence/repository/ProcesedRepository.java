package co.yuno.n8nService.persistence.repository;

import co.yuno.n8nService.persistence.entity.Processed;
import co.yuno.n8nService.persistence.enums.Phase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ProcesedRepository extends JpaRepository<Processed, Integer> {

    // Buscar por nombre de proyecto
    List<Processed> findByProjectName(String projectName);

    // Historial de un proyecto ascendente por id
    List<Processed> findByProjectNameOrderByIdProcessedAsc(String projectName);

    // Historial de un proyecto descendente por id
    List<Processed> findByProjectNameOrderByIdProcessedDesc(String projectName);

    // Java
    @Query("SELECT p FROM processed p " +
            "WHERE LOWER(TRIM(p.phase)) = LOWER(TRIM(:phase))")
    List<Processed> findByPhaseNormalized(@Param("phase") String phase);

    // Proyecto + fase
    List<Processed> findByProjectNameAndPhase(String projectName, Phase phase);

    List<Processed> findByLastUpdatedBetweenAndPhase(
            LocalDateTime start,
            LocalDateTime end,
            Phase phase
    );


    // Búsqueda de texto en summary
    List<Processed> findBySummaryContainingIgnoreCase(String text);

    // Contar por proyecto
    long countByProjectName(String projectName);

    // Contar por proyecto y fase
    long countByProjectNameAndPhase(String projectName, Phase phase);

    // Java
    @Query("SELECT p FROM processed p " +
            "WHERE LOWER(TRIM(p.merchant)) = LOWER(TRIM(:merchant))")
    List<Processed> findByMerchantNormalized(@Param("merchant") String merchant);


    List<Processed> findByMerchantIgnoreCaseAndLastUpdatedBetweenAndPhase(
            String merchant,
            LocalDateTime start,
            LocalDateTime end,
            Phase phase
    );
}
