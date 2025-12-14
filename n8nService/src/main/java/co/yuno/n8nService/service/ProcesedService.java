package co.yuno.n8nService.service;

import co.yuno.n8nService.persistence.entity.Processed;
import co.yuno.n8nService.persistence.enums.Phase;
import co.yuno.n8nService.persistence.repository.ProcesedRepository;
import co.yuno.n8nService.web.dto.ProcessedUpdateRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProcesedService {

    private final ProcesedRepository repository;

    public ProcesedService(ProcesedRepository repository) {
        this.repository = repository;
    }

    public Processed save(Processed procesed) {
        return repository.save(procesed);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
    public Processed partialUpdate(Integer id, ProcessedUpdateRequest request) {
        Processed existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }

        if (request.getPhase() != null) {
            existing.setPhase(request.getPhase());
        }
        if (request.getPayment() != null) {
            existing.setPayment(request.getPayment());
        }
        if (request.getRisk() != null) {
            existing.setRisk(request.getRisk());
        }
        if (request.getLegal() != null) {
            existing.setLegal(request.getLegal());
        }
        if (request.getTechnical() != null) {
            existing.setTechnical(request.getTechnical());
        }
        if (request.getCommercial() != null) {
            existing.setCommercial(request.getCommercial());
        }

        return repository.save(existing);

    }

        public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    public Processed findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Processed> findAll() {
        return repository.findAll();
    }

    public List<Processed> findByProjectName(String projectName) {
        return repository.findByProjectName(projectName);
    }

    public List<Processed> findHistoryAsc(String projectName) {
        return repository.findByProjectNameOrderByIdProcessedAsc(projectName);
    }

    public List<Processed> findHistoryDesc(String projectName) {
        return repository.findByProjectNameOrderByIdProcessedDesc(projectName);
    }

    public List<Processed> findByPhase(Phase phase) {
        return repository.findByPhaseNormalized(phase.name());
    }

    public List<Processed> findByProjectAndPhase(String projectName, Phase phase) {
        return repository.findByProjectNameAndPhase(projectName, phase);
    }

    public List<Processed> searchInSummary(String text) {
        return repository.findBySummaryContainingIgnoreCase(text);
    }

    public long countByProjectName(String projectName) {
        return repository.countByProjectName(projectName);
    }
    public List<Processed> findByDateBetweenAndPhase(
            LocalDateTime start,
            LocalDateTime end,
            Phase phase
    ) {
        return repository.findByLastUpdatedBetweenAndPhase(start, end, phase);
    }

    public long countByProjectNameAndPhase(String projectName, Phase phase) {
        return repository.countByProjectNameAndPhase(projectName, phase);
    }

    // Nuevo: implementación de búsqueda por merchant ignore case
    public List<Processed> findByMerchantIgnoreCase(String merchant) {
        return repository.findByMerchantNormalized(merchant);
    }

    public Processed updateProcessed(Processed procesed) {
        return repository.save(procesed);
    }
}
