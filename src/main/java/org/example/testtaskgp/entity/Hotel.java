package org.example.testtaskgp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.example.testtaskgp.entity.enums.Amenities;
import org.example.testtaskgp.entity.enums.Brand;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Embedded
    private Address address;

    @Embedded
    private Contacts contacts;

    @Embedded
    private ArrivalTime arrivalTime;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Amenities> amenities;
}
