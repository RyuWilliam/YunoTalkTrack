// Java
package co.yuno.YunoTalkTrack.persistence.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "merchants")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_merchant")
    private Integer idMerchant;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 150)
    private String website;

    @Column(name = "primary_contact_name", length = 80)
    private String primaryContactName;

    @Column(name = "primary_contact_email", length = 80)
    private String primaryContactEmail;

    @Column(length = 50)
    private String industry;

    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CountryMerchant> countryMerchants;

    public Merchant() {}

    public Integer getIdMerchant() { return idMerchant; }
    public void setIdMerchant(Integer idMerchant) { this.idMerchant = idMerchant; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    public String getPrimaryContactName() { return primaryContactName; }
    public void setPrimaryContactName(String primaryContactName) { this.primaryContactName = primaryContactName; }

    public String getPrimaryContactEmail() { return primaryContactEmail; }
    public void setPrimaryContactEmail(String primaryContactEmail) { this.primaryContactEmail = primaryContactEmail; }

    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }

    public List<CountryMerchant> getCountryMerchants() { return countryMerchants; }
    public void setCountryMerchants(List<CountryMerchant> countryMerchants) { this.countryMerchants = countryMerchants; }
}
