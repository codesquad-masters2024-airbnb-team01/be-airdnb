package com.team01.airdnb.accommadation.dto;

import com.team01.airdnb.accommadation.Accommodation;
import com.team01.airdnb.amenity.Amenity;
import com.team01.airdnb.amenity.AmenityStatus;
import com.team01.airdnb.image.Image;
import java.util.List;
import java.util.stream.Collectors;

public record AccommodationUpdateRequest(
    Long id,
    String title,
    String content,
    Long price,
    Integer discountRate,
    Integer maxAdults,
    Integer maxChildren,
    Integer maxInfants,
    Integer maxPets,
    String address,
    List<String> images,
    AmenityStatus tv,
    AmenityStatus kitchen,
    AmenityStatus washingMachine,
    AmenityStatus freeParking,
    AmenityStatus paidParking,
    AmenityStatus airConditioning,
    AmenityStatus dedicatedWorkspace,
    AmenityStatus wirelessInternet,
    Integer beds,
    Integer bathrooms,
    String userId
) {
  public Accommodation toAccommodationEntity() {
    return Accommodation.builder()
        .id(id)
        .title(title)
        .content(content)
        .price(price)
        .discountRate(discountRate)
        .maxAdults(maxAdults)
        .maxChildren(maxChildren)
        .maxInfants(maxInfants)
        .maxPets(maxPets)
        .address(address)
        .build();
  }

  public List<Image> toImageEntity() {
    return images.stream()
        .map(imagePath -> Image.builder()
            .imagePath(imagePath)
            .build())
        .collect(Collectors.toList());
  }

  public Amenity toAmenityEntity() {
    return Amenity.builder()
        .tv(tv)
        .kitchen(kitchen)
        .washingMachine(washingMachine)
        .freeParking(freeParking)
        .paidParking(paidParking)
        .airConditioner(airConditioning)
        .dedicatedWorkspace(dedicatedWorkspace)
        .wirelessInternet(wirelessInternet)
        .beds(beds)
        .bathrooms(bathrooms)
        .build();
  }

}
