package com.uber.uberapi.repository;

import com.uber.uberapi.models.Account;
import com.uber.uberapi.models.NamedLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NamedLocationRepository extends JpaRepository<NamedLocation, Long> {
}
