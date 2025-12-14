package co.yuno.n8nService.web.controller;

import co.yuno.n8nService.persistence.entity.Processed;
import co.yuno.n8nService.persistence.enums.Phase;
import co.yuno.n8nService.service.ProcesedService;
import co.yuno.n8nService.web.dto.ProcessedUpdateRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/processed")
public class ProcesedController {

    private final ProcesedService service;

    public ProcesedController(ProcesedService service) {
        this.service = service;
    }

    // CRUD básico
    @GetMapping("/{id}")
    public Processed getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Processed> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Processed create(@RequestBody Processed procesed) {
        return service.save(procesed);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }

    // Búsquedas
    @GetMapping("/by-project")
    public List<Processed> getByProject(@RequestParam String projectName) {
        return service.findByProjectName(projectName);
    }

    @GetMapping("/history-asc")
    public List<Processed> getHistoryAsc(@RequestParam String projectName) {
        return service.findHistoryAsc(projectName);
    }

    @GetMapping("/history-desc")
    public List<Processed> getHistoryDesc(@RequestParam String projectName) {
        return service.findHistoryDesc(projectName);
    }

    @GetMapping("/by-phase")
    public List<Processed> getByPhase(@RequestParam Phase phase) {
        return service.findByPhase(phase);
    }
    @GetMapping("/by-date-and-phase")
    public List<Processed> getByDateAndPhase(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            @RequestParam Phase phase
    ) {
        return service.findByDateBetweenAndPhase(start, end, phase);
    }

    @GetMapping("/by-project-and-phase")
    public List<Processed> getByProjectAndPhase(@RequestParam String projectName,
                                                @RequestParam Phase phase) {
        return service.findByProjectAndPhase(projectName, phase);
    }

    @GetMapping("/search-summary")
    public List<Processed> searchInSummary(@RequestParam String text) {
        return service.searchInSummary(text);
    }

    // Nuevo: buscar por merchant ignorando mayúsculas/minúsculas
    @GetMapping("/by-merchant")
    public List<Processed> getByMerchantIgnoreCase(@RequestParam String merchant) {
        return service.findByMerchantIgnoreCase(merchant);
    }

    @PutMapping("/{id}")
    public Processed partialUpdate(
            @PathVariable Integer id,
            @RequestBody ProcessedUpdateRequest request
    ) {
        return service.partialUpdate(id, request);
    }
}
