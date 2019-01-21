package com.stackroute.muzix.muzix.exceptions;

public class TrackIdNotFoundException extends Throwable {
    private int id;

    public TrackIdNotFoundException(int id) {
        this.id = id;
    }

    public TrackIdNotFoundException(String track_id_not_found) {
    }
}
