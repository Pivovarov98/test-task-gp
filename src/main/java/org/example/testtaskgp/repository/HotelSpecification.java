package org.example.testtaskgp.repository;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.example.testtaskgp.entity.Hotel;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class HotelSpecification {

    public static Specification<Hotel> hasCity(String city) {
        return (root, query, criteriaBuilder) ->
                city == null
                        ? null
                        : criteriaBuilder.like(criteriaBuilder.lower(root.get("address").get("city")),
                        "%" + city.toLowerCase() + "%");
    }

    public static Specification<Hotel> hasCountry(String country) {
        return (root, query, criteriaBuilder) ->
                country == null
                        ? null
                        : criteriaBuilder.like(criteriaBuilder.lower(root.get("address").get("country")),
                        "%" + country.toLowerCase() + "%");
    }

    public static Specification<Hotel> hasBrand(String brand) {
        return (root, query, criteriaBuilder) ->
                brand == null
                        ? null
                        : criteriaBuilder.like(criteriaBuilder.lower(root.get("brand")),
                        "%" + brand.toLowerCase() + "%");
    }

    public static Specification<Hotel> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null
                        ? null
                        : criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
                        "%" + name.toLowerCase() + "%");
    }

    public static Specification<Hotel> hasAmenities(List<String> amenities) {
        return (root, query, criteriaBuilder) -> {
            if (amenities == null || amenities.isEmpty()) {
                return null;
            }

            Join<Hotel, String> join = root.join("amenities");

            query.distinct(true);

            List<Predicate> predicates = amenities.stream()
                    .map(amenity ->
                            criteriaBuilder.like(criteriaBuilder.lower(join), "%" + amenity.toLowerCase() + "%"))
                    .toList();

            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }
}
