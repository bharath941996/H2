package com.stackroute.muzix.muzix.repository;

import com.stackroute.muzix.muzix.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TrackRepository extends JpaRepository <Track,Integer>{
}
