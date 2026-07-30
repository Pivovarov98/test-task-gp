package org.example.testtaskgp.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contacts {

    @NotNull
    private String phone;

    @NotNull
    @Email
    private String email;
}
