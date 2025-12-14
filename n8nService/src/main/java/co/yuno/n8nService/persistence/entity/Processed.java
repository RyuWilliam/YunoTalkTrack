package co.yuno.n8nService.persistence.entity;

import co.yuno.n8nService.persistence.enums.Phase;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "processed")
public class Processed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProcessed;

    @Column(length = 2000)
    private String summary;

    @Column(length = 100)
    private String merchant;

    @Column(length = 100)
    private String country;

    @Column(length = 100)
    @Enumerated(EnumType.STRING)
    private Phase phase;

    @Column(name = "project_name", length = 150)
    private String projectName;

    @Column(length = 1000)
    private String payment;

    @Column(length = 1000)
    private String risk;

    @Column(length = 1000)
    private String legal;

    @Column(length = 1000, name = "technical")
    private String Technical;

    @Column(length = 1000)
    private String commercial;

    @LastModifiedDate
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    // NUEVO: relación con la entidad puente
    @OneToMany(mappedBy = "processed", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ProcessedRaw> processedRaws;

    public Processed(Integer idProcessed, String summary, Phase phase, String projectName,
                     String payment, String risk, String legal, String technical,
                     String commercial, List<ProcessedRaw> processedRaws) {
        this.idProcessed = idProcessed;
        this.summary = summary;
        this.phase = phase;
        this.projectName = projectName;
        this.payment = payment;
        this.risk = risk;
        this.legal = legal;
        Technical = technical;
        this.commercial = commercial;
        this.processedRaws = processedRaws;
    }

    public Processed() {
    }

    // getters y setters...

    public Integer getIdProcessed() {
        return idProcessed;
    }

    public void setIdProcessed(Integer idProcessed) {
        this.idProcessed = idProcessed;
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

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<ProcessedRaw> getProcessedRaws() {
        return processedRaws;
    }

    public void setProcessedRaws(List<ProcessedRaw> processedRaws) {
        this.processedRaws = processedRaws;
    }
}
