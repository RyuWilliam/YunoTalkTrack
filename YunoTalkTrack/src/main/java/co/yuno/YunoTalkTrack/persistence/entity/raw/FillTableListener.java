// java
package co.yuno.YunoTalkTrack.persistence.entity.raw;

import co.yuno.YunoTalkTrack.config.SpringContext;
import co.yuno.YunoTalkTrack.domain.service.FillTableProcessorService;
import jakarta.persistence.PostPersist;

public class FillTableListener {

    @PostPersist
    public void afterInsert(FillTable entity) {
        System.out.println("[FillTableListener] PostPersist id=" + entity.getIdFillTable());
        FillTableProcessorService service =
                SpringContext.getBean(FillTableProcessorService.class);
        service.processFillTable(entity);
    }
}
