package co.yuno.YunoTalkTrack.persistence.entity;


import co.yuno.YunoTalkTrack.persistence.enums.Currency;
import co.yuno.YunoTalkTrack.persistence.enums.IsoCode;
import jakarta.persistence.*;

@Entity(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_country")
    private Integer idCountry;

    @Column(length = 40, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "iso_code", nullable = false, length = 10)
    private IsoCode isoCode;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Currency currency;

    public Country(){
    }

    public Country(Integer idCountry, String name, IsoCode isoCode, Currency currency) {
        this.idCountry = idCountry;
        this.name = name;
        this.isoCode = isoCode;
        this.currency = currency;
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IsoCode getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(IsoCode isoCode) {
        this.isoCode = isoCode;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
