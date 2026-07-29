package org.example.testtaskgp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contacts {

    private List<String> phone;

    private List<String> email;

    @OneToOne
    @JoinColumn(name = "hotel_id", unique = true)
    private Hotel hotel;
}
