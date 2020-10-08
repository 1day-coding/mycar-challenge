package com.mycar.coding.service;

import com.mycar.coding.model.Dealer;
import com.mycar.coding.persistance.DealerRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DealerService {

    private final DealerRepository dealerRepository;

    public Optional<Dealer> findDealerByIdentifier(final UUID dealerIdentifier) {
        return dealerRepository.findByIdentifier(dealerIdentifier);
    }

    public Dealer createDealer(final UUID dealerIdentifier) {
        return dealerRepository.save(Dealer.builder().identifier(dealerIdentifier).build());
    }

    /*
        FIXME: This method should not exist. We create a Dealer here if it doesn't exist for simplification only !!!
    */
    public Dealer getOrCreateDealer(final UUID dealerIdentifier) {
        return findDealerByIdentifier(dealerIdentifier).orElseGet(() -> createDealer(dealerIdentifier));
    }
}
