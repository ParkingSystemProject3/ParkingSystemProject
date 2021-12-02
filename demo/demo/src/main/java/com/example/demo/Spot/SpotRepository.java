package com.example.demo.Spot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Long> {


    @Query(value ="select * from spot where taking = ?1 and slot_type = ?2 limit 1",nativeQuery = true)
     public Spot findAvailableNormalSpot(boolean bool,String str);

}