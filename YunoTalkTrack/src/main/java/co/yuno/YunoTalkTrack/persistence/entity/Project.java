// java
package co.yuno.YunoTalkTrack.persistence.entity;

import co.yuno.YunoTalkTrack.persistence.enums.Phase;
import co.yuno.YunoTalkTrack.persistence.enums.ProjectType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
    private Integer idProject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_merchant", nullable = false)
    private Merchant merchant;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(name = "project_type", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private ProjectType projectType;

    @Column(name = "project_phase", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Phase projectPhase;

    @ManyToMany
    @JoinTable(
            name = "project_responsibles",
            joinColumns = @JoinColumn(name = "id_project"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private List<User> responsibles;


    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "go_live_date")
    private LocalDateTime goLiveDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(
            mappedBy = "project",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProjectInfo> projectInfos;

    public Project() {}

    public Integer getIdProject() { return idProject; }
    public void setIdProject(Integer idProject) { this.idProject = idProject; }

    public Merchant getMerchant() { return merchant; }
    public void setMerchant(Merchant merchant) { this.merchant = merchant; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ProjectType getProjectType() { return projectType; }
    public void setProjectType(ProjectType projectType) { this.projectType = projectType; }

    public Phase getProjectPhase() { return projectPhase; }
    public void setProjectPhase(Phase projectPhase) { this.projectPhase = projectPhase; }

    public List<User> getResponsibles() { return responsibles; }
    public void setResponsibles(List<User> responsibles) { this.responsibles = responsibles; }

    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }

    public LocalDateTime getGoLiveDate() { return goLiveDate; }
    public void setGoLiveDate(LocalDateTime goLiveDate) { this.goLiveDate = goLiveDate; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<ProjectInfo> getProjectInfos() { return projectInfos; }
    public void setProjectInfos(List<ProjectInfo> projectInfos) { this.projectInfos = projectInfos; }
}
