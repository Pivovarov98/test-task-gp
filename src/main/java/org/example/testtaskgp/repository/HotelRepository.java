package org.example.testtaskgp.repository;

import org.example.testtaskgp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HotelRepository extends JpaRepository<Hotel, Long>,
                                         JpaSpecificationExecutor<Hotel> {
}
