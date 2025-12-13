package co.yuno.YunoTalkTrack.persistence.entity.ids;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CountryMerchantId implements Serializable {
    private Integer idCountry;
    private Integer idMerchant;

    public CountryMerchantId() {}

    public CountryMerchantId(Integer idCountry, Integer idMerchant) {
        this.idCountry = idCountry;
        this.idMerchant = idMerchant;
    }

    public Integer getIdCountry() { return idCountry; }
    public void setIdCountry(Integer idCountry) { this.idCountry = idCountry; }

    public Integer getIdMerchant() { return idMerchant; }
    public void setIdMerchant(Integer idMerchant) { this.idMerchant = idMerchant; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryMerchantId)) return false;
        CountryMerchantId that = (CountryMerchantId) o;
        return Objects.equals(idCountry, that.idCountry) &&
                Objects.equals(idMerchant, that.idMerchant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCountry, idMerchant);
    }
}
