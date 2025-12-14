package co.yuno.n8nService.persistence.repository;

import co.yuno.n8nService.persistence.entity.RawTable;
import co.yuno.n8nService.persistence.enums.InfoSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RawTableRepository extends JpaRepository<RawTable, Integer> {

    // Buscar por source
    List<RawTable> findBySource(InfoSource source);

    // Buscar por país (ignorando mayúsculas/minúsculas)
    List<RawTable> findByCountryIgnoreCase(String country);

    // Buscar por merchant exacto
    List<RawTable> findByMerchant(String merchant);

    // Buscar por merchant que contenga texto (like %texto%)
    List<RawTable> findByMerchantContainingIgnoreCase(String merchant);

    // Buscar por rango de fechas
    List<RawTable> findByDateBetween(LocalDateTime start, LocalDateTime end);

    // Traer últimos N registros por fecha y país (usando Pageable en el service/controller)
    List<RawTable> findByCountryIgnoreCaseOrderByDateDesc(String country);
}
