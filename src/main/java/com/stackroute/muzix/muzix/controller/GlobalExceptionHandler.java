package com.stackroute.muzix.muzix.controller;

import com.stackroute.muzix.muzix.exceptions.TrackIdNotFoundException;
import com.stackroute.muzix.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.muzix.exceptions.UserAlreadyExistsException;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Track already exist")
    @ExceptionHandler(UserAlreadyExistsException.class)
    public void handleUserAlreadyExistException(UserAlreadyExistsException e){
        System.out.println("Track already exist");
    }
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Track not found")
    @ExceptionHandler(TrackIdNotFoundException.class)
    public void handleTrackNotFoundException(TrackIdNotFoundException e){
        System.out.println("Track not found");
    }
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Track")
    @ExceptionHandler(TrackNotFoundException.class)
    public void handleTrackNotFoundException(TrackNotFoundException e){
        System.out.println("Track not found");
    }
}