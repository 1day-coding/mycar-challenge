package com.mycar.coding.persistance;

import com.mycar.coding.model.Dealer;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepository extends JpaRepository<Dealer, Long> {

    Optional<Dealer> findByIdentifier(final UUID dealerIdentifier);
}

