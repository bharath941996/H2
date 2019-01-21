package com.stackroute.muzix.muzix.controller;

import com.stackroute.muzix.muzix.domain.Track;
import com.stackroute.muzix.muzix.exceptions.TrackIdNotFoundException;
import com.stackroute.muzix.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.muzix.exceptions.UserAlreadyExistsException;
import com.stackroute.muzix.muzix.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @Controller
    @RequestMapping(value = "/api/v1")
    @RestController
    @Api(value="bharath",description = "shows bharath")
    public class TrackController {
        TrackService trackService;
        ResponseEntity responseEntity;
        @Autowired
        private TrackController(TrackService trackService) {
            this.trackService = trackService;
        }
        @ApiOperation(value = "hello")
        @ApiResponses(
                value={
                        @ApiResponse(code = 100,message="100isthe message")
                }
        )
        @PostMapping("track")
        public ResponseEntity<?> saveTrack(@RequestBody Track track) throws UserAlreadyExistsException {
                trackService.saveTrack(track);
                responseEntity = new ResponseEntity<String>("Created", HttpStatus.CREATED);
            return responseEntity;
        }
        @ApiOperation(value = "helloworld")
        @DeleteMapping("track/{id}")
        public ResponseEntity<?> deleteTrack(@PathVariable("id") int id) throws TrackIdNotFoundException
        {

                trackService.deleteTrack(id);
                responseEntity = new ResponseEntity<String>("deleted successfully", HttpStatus.OK);

            return responseEntity;
        }
        @ApiOperation(value = "helloworld 1")
        @PutMapping("track")
        public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFoundException {
            trackService.updateTrack(track);
            responseEntity=new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);
            return responseEntity;    }
        @ApiOperation(value = "helloworld2")
        @GetMapping("track")
        public ResponseEntity<?>getAllTracks(){
            return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
        }
    }
