package co.yuno.YunoTalkTrack.persistence.crud;


import co.yuno.YunoTalkTrack.persistence.entity.ProjectInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectInfoRepository extends JpaRepository<ProjectInfo, Integer> {
}
