package com.mycar.coding.converter;

import com.mycar.coding.model.Dealer;
import com.mycar.coding.model.Listing;
import dto.ListingDto;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;

class ListingToListingDtoConverterTest {

    private ListingToListingDtoConverter underTest;
    private UUID dealerIdentifier;

    @BeforeEach
    void setUp() {
        underTest = new ListingToListingDtoConverter();
        dealerIdentifier = UUID.randomUUID();
    }

    @Test
    void shouldConvert() {
        var actual = underTest.convert(Listing.builder()
                                              .id(-1L)
                                              .dealer(Dealer.builder()
                                                            .id(-1L)
                                                            .identifier(dealerIdentifier)
                                                            .createdAt(now())
                                                            .updatedAt(now())
                                                            .build())
                                              .code("a")
                                              .make("renault")
                                              .model("megane")
                                              .kW(132)
                                              .powerInPs(179)
                                              .year(2014)
                                              .color("red")
                                              .price(13990)
                                              .createdAt(now())
                                              .updatedAt(now())
                                              .build());
        var expected = ListingDto.builder()
                                 .code("a")
                                 .dealerId(dealerIdentifier)
                                 .make("renault")
                                 .model("megane")
                                 .kiloWatt(132)
                                 .powerInPs(179)
                                 .year(2014)
                                 .color("red")
                                 .price(13990)
                                 .build();

        assertThat(actual).isEqualTo(expected);
    }
}