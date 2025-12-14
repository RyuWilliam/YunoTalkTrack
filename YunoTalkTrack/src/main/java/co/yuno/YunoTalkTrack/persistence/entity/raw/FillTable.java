// java
package co.yuno.YunoTalkTrack.persistence.entity.raw;

import co.yuno.YunoTalkTrack.persistence.enums.InfoSource;
import co.yuno.YunoTalkTrack.persistence.enums.IsoCode;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "fill_table")
@EntityListeners(FillTableListener.class)
public class FillTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fill_table")
    private Integer idFillTable;

    @Column(name = "user_name", length = 100,  nullable = false)
    private String userName;

    @Column(name = "project_name", length = 150, nullable = false)
    private String projectName;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private InfoSource infoSource;

    @Column(name = "content", length = 2000, nullable = false)
    private String content;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "worker", length = 100, nullable = false)
    private String worker;

    @Enumerated(EnumType.STRING)
    @Column(name = "iso_code", nullable = false)
    private IsoCode isoCode;

    @Column(name = "merchant_name", length = 150, nullable = false)
    private String merchantName;

    @Column(name = "processed", nullable = false)
    private boolean processed = false;




    public FillTable() { }

    public FillTable(Integer idFillTable, String userName, String projectName,
                     InfoSource infoSource, String content, LocalDateTime date,
                     String worker, IsoCode isoCode, String merchantName) {
        this.idFillTable = idFillTable;
        this.userName = userName;
        this.projectName = projectName;
        this.infoSource = infoSource;
        this.content = content;
        this.date = date;
        this.worker = worker;
        this.isoCode = isoCode;
        this.merchantName = merchantName;
    }
    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public Integer getIdFillTable() { return idFillTable; }
    public void setIdFillTable(Integer idFillTable) { this.idFillTable = idFillTable; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }

    public InfoSource getInfoSource() { return infoSource; }
    public void setInfoSource(InfoSource infoSource) { this.infoSource = infoSource; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public String getWorker() { return worker; }
    public void setWorker(String worker) { this.worker = worker; }

    public IsoCode getIsoCode() { return isoCode; }
    public void setIsoCode(IsoCode isoCode) { this.isoCode = isoCode; }

    public String getMerchantName() { return merchantName; }
    public void setMerchantName(String merchantName) { this.merchantName = merchantName; }
}
