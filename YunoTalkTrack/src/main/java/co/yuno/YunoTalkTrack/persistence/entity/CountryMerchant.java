package co.yuno.YunoTalkTrack.persistence.entity;

import co.yuno.YunoTalkTrack.persistence.entity.ids.CountryMerchantId;
import jakarta.persistence.*;

@Entity(name = "country_merchants")
public class CountryMerchant {

    @EmbeddedId
    private CountryMerchantId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idCountry")
    @JoinColumn(name = "id_country", nullable = false)
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idMerchant")
    @JoinColumn(name = "id_merchant", nullable = false)
    private Merchant merchant;

    public CountryMerchant() {}

    public CountryMerchant(Country country, Merchant merchant) {
        this.country = country;
        this.merchant = merchant;
        this.id = new CountryMerchantId(country.getIdCountry(), merchant.getIdMerchant());
    }

    public CountryMerchantId getId() { return id; }
    public void setId(CountryMerchantId id) { this.id = id; }

    public Country getCountry() { return country; }
    public void setCountry(Country country) {
        this.country = country;
        if (country != null) {
            if (this.id == null) this.id = new CountryMerchantId();
            this.id.setIdCountry(country.getIdCountry());
        }
    }

    public Merchant getMerchant() { return merchant; }
    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
        if (merchant != null) {
            if (this.id == null) this.id = new CountryMerchantId();
            this.id.setIdMerchant(merchant.getIdMerchant());
        }
    }
}
