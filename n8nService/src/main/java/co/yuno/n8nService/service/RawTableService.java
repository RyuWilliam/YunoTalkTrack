package co.yuno.n8nService.service;

import co.yuno.n8nService.persistence.entity.RawTable;
import co.yuno.n8nService.persistence.enums.InfoSource;
import co.yuno.n8nService.persistence.repository.RawTableRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RawTableService {

    private final RawTableRepository repository;

    public RawTableService(RawTableRepository repository) {
        this.repository = repository;
    }

    public RawTable save(RawTable rawTable) {
        return repository.save(rawTable);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    public RawTable findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<RawTable> findAll() {
        return repository.findAll();
    }

    public List<RawTable> findBySource(InfoSource source) {
        return repository.findBySource(source);
    }

    public List<RawTable> findByCountry(String country) {
        return repository.findByCountryIgnoreCase(country);
    }

    public List<RawTable> findByMerchentContaining(String merchent) {
        return repository.findByMerchantContainingIgnoreCase(merchent);
    }

    public List<RawTable> findByDateBetween(LocalDateTime start, LocalDateTime end) {
        return repository.findByDateBetween(start, end);
    }

    public List<RawTable> findLatestByCountry(String country) {
        return repository.findByCountryIgnoreCaseOrderByDateDesc(country);
    }
}
