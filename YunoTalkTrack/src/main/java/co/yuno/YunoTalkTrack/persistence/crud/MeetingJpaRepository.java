package co.yuno.YunoTalkTrack.persistence.crud;


import co.yuno.YunoTalkTrack.persistence.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingJpaRepository extends JpaRepository<Meeting, Integer> {
}
