package co.yuno.YunoTalkTrack.persistence.entity.raw;


import co.yuno.YunoTalkTrack.persistence.enums.InfoSource;
import co.yuno.YunoTalkTrack.persistence.enums.IsoCode;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "data")
public class Data {

    @Id

    @Column(name = "type", nullable = false)
    private InfoSource infoSource;

    @Column(name = "content", length = 2000, nullable = false)
    private String content;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "worker", length = 100, nullable = false)
    public String worker;

    @Column(name = "iso_code", nullable = false)
    @Enumerated(EnumType.STRING)
    public IsoCode isoCode;

    @Column(name = "merchant_name", length = 150, nullable = false)
    public String merchantName;

    public Data() {
    }

    public Data(InfoSource infoSource, String content, LocalDateTime date, String description, String worker, IsoCode isoCode, String merchantName) {
        this.infoSource = infoSource;
        this.content = content;
        this.date = date;
        this.description = description;
        this.worker = worker;
        this.isoCode = isoCode;
        this.merchantName = merchantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InfoSource getInfoSource() {
        return infoSource;
    }

    public void setInfoSource(InfoSource infoSource) {
        this.infoSource = infoSource;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public IsoCode getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(IsoCode isoCode) {
        this.isoCode = isoCode;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
}
