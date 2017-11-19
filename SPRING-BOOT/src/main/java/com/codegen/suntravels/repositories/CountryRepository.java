package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DELL on 11/18/2017.
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{
}
