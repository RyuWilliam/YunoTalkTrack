// java
package co.yuno.YunoTalkTrack.persistence.entity;

import co.yuno.YunoTalkTrack.persistence.enums.Phase;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "project_info",
        indexes = {
                @Index(name = "idx_project_info_project", columnList = "id_project"),
        })
public class ProjectInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_info")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true) // antes optional = false
    @JoinColumn(name = "id_project", nullable = true)   // antes nullable = false
    private Project project;

    @Column(name = "description", nullable = false, length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "phase", length = 50)
    private Phase phase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id", nullable = true) // antes nullable = false
    private User createdBy;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_info_id")
    private ProjectInfo parentInfo;

    @OneToMany(
            mappedBy = "projectInfo",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProjectDetail> details;

    @OneToOne(mappedBy = "projectInfo", fetch = FetchType.LAZY)
    private Meeting meeting;

    public ProjectInfo() {}

    public ProjectInfo(Integer id, Project project, String description, Phase phase, User createdBy, LocalDateTime createdAt, ProjectInfo parentInfo, List<ProjectDetail> details, Meeting meeting) {
        this.id = id;
        this.project = project;
        this.description = description;
        this.phase = phase;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.parentInfo = parentInfo;
        this.details = details;
        this.meeting = meeting;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }


    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Phase getPhase() { return phase; }
    public void setPhase(Phase phase) { this.phase = phase; }

    public User getCreatedBy() { return createdBy; }
    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public ProjectInfo getParentInfo() { return parentInfo; }
    public void setParentInfo(ProjectInfo parentInfo) { this.parentInfo = parentInfo; }

    public List<ProjectDetail> getDetails() { return details; }
    public void setDetails(List<ProjectDetail> details) { this.details = details; }

    public Meeting getMeeting() { return meeting; }
    public void setMeeting(Meeting meeting) { this.meeting = meeting; }
}
