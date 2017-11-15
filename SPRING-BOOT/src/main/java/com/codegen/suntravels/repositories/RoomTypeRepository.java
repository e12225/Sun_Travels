package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

    //TODO : implement 'searchRmTypeByName()' here

}
