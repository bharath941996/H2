package com.stackroute.muzix.muzix.service;

import com.stackroute.muzix.muzix.domain.Track;
import com.stackroute.muzix.muzix.exceptions.TrackIdNotFoundException;
import com.stackroute.muzix.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.muzix.exceptions.UserAlreadyExistsException;
import com.stackroute.muzix.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
    @Service
    public class TrackServiceImpl implements TrackService {
        TrackRepository trackRepository;
        @Autowired
        public TrackServiceImpl(TrackRepository trackRepository) {
            this.trackRepository=trackRepository;
        }
        @Override
        public Track saveTrack(Track track) throws UserAlreadyExistsException {

            if(trackRepository.existsById(track.getTrackId())){
                throw new UserAlreadyExistsException("Track already exists");
            }
            Track savedTrack=trackRepository.save(track);
            if(savedTrack==null){
                throw new UserAlreadyExistsException("Track already exist");
            }
            return savedTrack;
        }


        @Override
        public boolean deleteTrack(int id) throws TrackIdNotFoundException {
            boolean status=false;
            if(trackRepository.existsById(id)){
                trackRepository.deleteById(id);
                status=true;
                return status;
            }
            else{
                throw new TrackIdNotFoundException("Track id not found");
            }

        }

        @Override
        public Track updateTrack(Track track)throws TrackNotFoundException {
            if (trackRepository.existsById(track.getTrackId())){
                throw new TrackNotFoundException("track updated");
            }

            Track updatedTrack=trackRepository.save(track);
            if (updatedTrack==null){
                throw new TrackNotFoundException("track not updated");
            }
            return updatedTrack;
        }

        @Override
        public List<Track> getAllTracks() {
            return trackRepository.findAll();
        }
    }

