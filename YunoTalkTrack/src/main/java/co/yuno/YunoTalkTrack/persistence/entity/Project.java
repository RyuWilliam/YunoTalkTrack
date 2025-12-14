// java
package co.yuno.YunoTalkTrack.persistence.entity;

import co.yuno.YunoTalkTrack.persistence.enums.Phase;
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
    @JoinColumn(name = "id_merchant", nullable = true) // antes nullable = false
    private Merchant merchant;

    @Column(length = 100, nullable = false)
    private String name;


    @Column(name = "project_phase", nullable = true, length = 50) // antes nullable = false
    @Enumerated(EnumType.STRING)
    private Phase projectPhase;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @Column(name = "go_live_date")
    private LocalDateTime goLiveDate;

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


    public Phase getProjectPhase() { return projectPhase; }
    public void setProjectPhase(Phase projectPhase) { this.projectPhase = projectPhase; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }

    public LocalDateTime getGoLiveDate() { return goLiveDate; }
    public void setGoLiveDate(LocalDateTime goLiveDate) { this.goLiveDate = goLiveDate; }


    public List<ProjectInfo> getProjectInfos() { return projectInfos; }
    public void setProjectInfos(List<ProjectInfo> projectInfos) { this.projectInfos = projectInfos; }
}
