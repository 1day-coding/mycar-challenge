package com.mycar.coding.persistance;

import com.mycar.coding.model.Dealer;
import com.mycar.coding.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Long> {

    Iterable<Listing> findAllByDealer(final Dealer dealer);

}

