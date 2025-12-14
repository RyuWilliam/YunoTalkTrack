package co.yuno.YunoTalkTrack.persistence.crud;

import co.yuno.YunoTalkTrack.persistence.entity.raw.FillTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FillTableRepository extends JpaRepository<FillTable, Integer> {

    List<FillTable> findByProcessedFalse();
}
