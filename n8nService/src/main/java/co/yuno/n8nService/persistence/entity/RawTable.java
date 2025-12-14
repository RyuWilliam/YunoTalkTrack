package co.yuno.n8nService.persistence.entity;

import co.yuno.n8nService.persistence.enums.InfoSource;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "raw_table")
public class RawTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InfoSource source;

    @Column(length = 100)
    private String merchant;

    @Column(length = 10000)
    private String snippet;

    private LocalDateTime date;

    @Column(length = 100)
    private String country;

    public RawTable() {
    }

    public RawTable(Integer id, InfoSource source, String merchant, String snippet, LocalDateTime date, String country) {
        this.id = id;
        this.source = source;
        this.merchant = merchant;
        this.snippet = snippet;
        this.date = date;
        this.country = country;
    }
    // ELIMINADO: referencia directa a Processed
    // @ManyToOne
    // @JoinColumn(name = "processed_id")
    // private Processed processed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InfoSource getSource() {
        return source;
    }

    public void setSource(InfoSource source) {
        this.source = source;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
