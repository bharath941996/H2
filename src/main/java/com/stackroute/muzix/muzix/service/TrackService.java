package com.stackroute.muzix.muzix.service;

import com.stackroute.muzix.muzix.domain.Track;
import com.stackroute.muzix.muzix.exceptions.TrackIdNotFoundException;
import com.stackroute.muzix.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.muzix.exceptions.UserAlreadyExistsException;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track)throws UserAlreadyExistsException;
    public boolean deleteTrack(int id) throws TrackIdNotFoundException;
    public Track updateTrack(Track track)throws TrackNotFoundException;
    public List<Track> getAllTracks();
}
