// java
package co.yuno.YunoTalkTrack.persistence.crud;

import co.yuno.YunoTalkTrack.persistence.entity.Merchant;
import co.yuno.YunoTalkTrack.persistence.enums.IsoCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerchantJpaRepository extends JpaRepository<Merchant, Integer> {

    // Busca merchant por nombre (ignore case) y por isoCode de algún country asociado
    Optional<Merchant> findByNameIgnoreCaseAndCountryMerchants_Country_IsoCode(
            String name,
            IsoCode isoCode
    );
}
