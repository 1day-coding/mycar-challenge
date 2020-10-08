package com.mycar.coding.converter;

import com.mycar.coding.model.Listing;
import dto.CreateUpdateListingDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateUpdateListingDtoToListingConverter implements Converter<CreateUpdateListingDto, Listing> {

    @Override
    public Listing convert(final CreateUpdateListingDto createUpdateListingDto) {
        return Listing.builder()
                      .code(createUpdateListingDto.getCode())
                      .make(createUpdateListingDto.getMake())
                      .model(createUpdateListingDto.getModel())
                      .powerInPs(convertKiloWattToHorsePower(createUpdateListingDto.getKiloWatt()))
                      .kW(createUpdateListingDto.getKiloWatt())
                      .year(createUpdateListingDto.getYear())
                      .color(createUpdateListingDto.getColor())
                      .price(createUpdateListingDto.getPrice())
                      .build();
    }

    private int convertKiloWattToHorsePower(int kiloWatt) {
        return (int) Math.round(kiloWatt * 1.3596);   // 1 kW = 1.3596 hp
    }
}
