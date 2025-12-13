// Java
package co.yuno.YunoTalkTrack.persistence.entity;

import co.yuno.YunoTalkTrack.persistence.enums.MeetingType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "meetings",
        indexes = {
                @Index(name = "idx_meeting_info", columnList = "id_info_proyecto"),
                @Index(name = "idx_meeting_date", columnList = "date")
        })
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meeting")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "meeting_type", nullable = false, length = 30)
    private MeetingType meetingType;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @ElementCollection
    @CollectionTable(name = "meeting_external_attendees",
            joinColumns = @JoinColumn(name = "id_meeting"))
    @Column(name = "attendee", length = 120)
    private List<String> externalAttendees;

    @ManyToMany
    @JoinTable(
            name = "meeting_internal_users",
            joinColumns = @JoinColumn(name = "id_meeting"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private List<User> internalAttendees;

    // Extraidos de un transcript obtenido por gong u otro software de meeting intelligence
    @Column(name = "summary", length = 2000)
    private String summary;

    // Uno a uno con ProjectInfo, lado dueño
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_info_proyecto", unique = true)
    private ProjectInfo projectInfo;

    public Meeting() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public MeetingType getMeetingType() { return meetingType; }
    public void setMeetingType(MeetingType meetingType) { this.meetingType = meetingType; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public List<String> getExternalAttendees() { return externalAttendees; }
    public void setExternalAttendees(List<String> externalAttendees) { this.externalAttendees = externalAttendees; }

    public List<User> getInternalAttendees() { return internalAttendees; }
    public void setInternalAttendees(List<User> internalAttendees) { this.internalAttendees = internalAttendees; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public ProjectInfo getProjectInfo() { return projectInfo; }
    public void setProjectInfo(ProjectInfo projectInfo) { this.projectInfo = projectInfo; }
}
