
package co.yuno.YunoTalkTrack.domain.service;

import co.yuno.YunoTalkTrack.persistence.crud.FillTableRepository;
import co.yuno.YunoTalkTrack.persistence.entity.raw.FillTable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class FillTableScheduledProcessor {

    private final FillTableRepository fillTableRepository;
    private final FillTableProcessorService fillTableProcessorService;

    public FillTableScheduledProcessor(FillTableRepository fillTableRepository,
                                       FillTableProcessorService fillTableProcessorService) {
        this.fillTableRepository = fillTableRepository;
        this.fillTableProcessorService = fillTableProcessorService;
    }

    @Scheduled(fixedDelay = 5000) // cada 5 segundos después de terminar la última ejecución
    @Transactional
    public void processPendingRows() {
        List<FillTable> pending = fillTableRepository.findByProcessedFalse();
        if (pending.isEmpty()) {
            return;
        }

        System.out.println("[FillTableScheduledProcessor] Filas pendientes: " + pending.size());

        for (FillTable fill : pending) {
            try {
                fillTableProcessorService.processFillTable(fill);
                fill.setProcessed(true);           // marcar como procesado
                fillTableRepository.save(fill);    // guardar cambio
                System.out.println("[FillTableScheduledProcessor] Procesado id_fill_table=" + fill.getIdFillTable());
            } catch (Exception e) {
                System.out.println("[FillTableScheduledProcessor] ERROR en id_fill_table=" +
                        fill.getIdFillTable() + " -> " + e.getMessage());
            }
        }
    }
}
