package co.yuno.YunoTalkTrack.persistence.entity;

import co.yuno.YunoTalkTrack.persistence.enums.ProjectDetailType;
import jakarta.persistence.*;

@Entity
@Table(name = "project_detail")
public class ProjectDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_info", nullable = false)
    private ProjectInfo projectInfo;

    @Enumerated(EnumType.STRING)
    @Column(name = "detail_type", nullable = false, length = 50)
    private ProjectDetailType detailType;

    @Column(name = "detail", nullable = false, length = 4000)
    private String detail;

    public ProjectDetail() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public ProjectInfo getProjectInfo() { return projectInfo; }
    public void setProjectInfo(ProjectInfo projectInfo) { this.projectInfo = projectInfo; }

    public ProjectDetailType getDetailType() { return detailType; }
    public void setDetailType(ProjectDetailType detailType) { this.detailType = detailType; }

    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }

}
