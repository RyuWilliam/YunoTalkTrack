package co.yuno.n8nService.persistence.entity;


import co.yuno.n8nService.persistence.enums.Phase;
import jakarta.persistence.*;

@Entity(name = "procesed")
public class Procesed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProcesed;

    @Column(length = 2000)
    private String summary;

    @Column(length = 100)
    @Enumerated(EnumType.STRING)
    private Phase phase;

    private String projectName;

    private String payment;

    private String risk;

    private String legal;

    private String Technical;

    private String commercial;

    private String detail;

    public Integer getIdProcesed() {
        return idProcesed;
    }

    public void setIdProcesed(Integer idProcesed) {
        this.idProcesed = idProcesed;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getLegal() {
        return legal;
    }

    public void setLegal(String legal) {
        this.legal = legal;
    }

    public String getTechnical() {
        return Technical;
    }

    public void setTechnical(String technical) {
        Technical = technical;
    }

    public String getCommercial() {
        return commercial;
    }

    public void setCommercial(String commercial) {
        this.commercial = commercial;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
