package co.yuno.n8nService.web.controller;

import co.yuno.n8nService.persistence.entity.RawTable;
import co.yuno.n8nService.persistence.enums.InfoSource;
import co.yuno.n8nService.service.RawTableService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/raw-table")
public class RawTableController {

    private final RawTableService service;

    public RawTableController(RawTableService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RawTable> getById(@PathVariable Integer id) {
        RawTable rawTable = service.findById(id);

        return ResponseEntity.ok(rawTable);
    }

    @GetMapping
    public List<RawTable> getAll() {
        return service.findAll();
    }

    @PostMapping
    public RawTable create(@RequestBody RawTable rawTable) {
        return service.save(rawTable);
    }

    @PutMapping("/{id}")
    public RawTable update(@PathVariable Integer id, @RequestBody RawTable rawTable) {
        rawTable.setId(id);
        return service.save(rawTable);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @GetMapping("/by-source")
    public List<RawTable> getBySource(@RequestParam InfoSource source) {
        return service.findBySource(source);
    }

    @GetMapping("/by-country")
    public List<RawTable> getByCountry(@RequestParam String country) {
        return service.findByCountry(country);
    }

    @GetMapping("/by-merchant")
    public List<RawTable> getByMerchant(@RequestParam String merchant) {
        return service.findByMerchentContaining(merchant);
    }

    @GetMapping("/by-date-range")
    public List<RawTable> getByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end
    ) {
        return service.findByDateBetween(start, end);
    }

    @GetMapping("/latest-by-country")
    public List<RawTable> getLatestByCountry(@RequestParam String country) {
        return service.findLatestByCountry(country);
    }
}
