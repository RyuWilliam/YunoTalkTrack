package co.yuno.n8nService.persistence.repository;

import co.yuno.n8nService.persistence.entity.Processed;
import co.yuno.n8nService.persistence.entity.ProcessedRaw;
import co.yuno.n8nService.persistence.entity.RawTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessedRawRepository extends JpaRepository<ProcessedRaw, Integer> {

    List<ProcessedRaw> findByProcessed(Processed processed);

    List<ProcessedRaw> findByRawTable(RawTable rawTable);
}
