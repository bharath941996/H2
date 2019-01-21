//package com.stackroute.muzix.muzix.seedpackage;
//
//import com.stackroute.muzix.muzix.domain.Track;
//import com.stackroute.muzix.muzix.repository.TrackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SeedDataUsingCommandLineRunner implements CommandLineRunner
//{
//    private TrackRepository trackRepository;
//
//    @Autowired
//    public SeedDataUsingCommandLineRunner(TrackRepository trackRepository)
//    {
//        this.trackRepository = trackRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Track track1=Track.builder().trackName("guleba").trackComment("Prabhu Deba").build();
//        trackRepository.save(track1);
//        Track track2=Track.builder().trackName("gul").trackComment("Prabhu").build();
//        trackRepository.save(track2);
//    }
//}
package com.stackroute.muzix.muzix.seedpackage;


import com.stackroute.muzix.muzix.domain.Track;
import com.stackroute.muzix.muzix.service.TrackService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("application.properties")
public class SeedDataUsingCommandLineRunner implements CommandLineRunner {
    private Track feedTrackData = new Track();
    @Value("${song.total}")
    private int totalSongs;
    @Value("${song.1.id}")
    private int id1;
    @Value("${song.1.name}")
    private String name1;
    @Value("${song.1.comment}")
    private String comment1;
    @Value("${song.2.id}")
    private int id2;
    @Value("${song.2.name}")
    private String name2;
    @Value("${song.2.comment}")
    private String comment2;
    @Value("${song.3.id}")
    private int id3;
    @Value("${song.3.name}")
    private String name3;
    @Value("${song.3.comment}")
    private String comment3;


    @Autowired
    Environment env;
    @Autowired
    private TrackService trackServices;
    //    TODO: Add all feeder data to a file, don't let it be hardcoded
//    TODO: Find a better way to write expressions for @Value tag
    @Override
    public void run(String... args) throws Exception {
        System.out.println(env.getProperty("app.name"));
        System.out.println(env.getProperty("JAVA_HOME"));
        feedTrackData.setTrackId(id1);
        feedTrackData.setTrackName(name1);
        feedTrackData.setTrackComment(comment1);
        trackServices.saveTrack(feedTrackData);
        feedTrackData.setTrackId(Integer.parseInt(env.getProperty("song.1.id")));
        feedTrackData.setTrackName(env.getProperty("song.1.name"));
        feedTrackData.setTrackComment(env.getProperty("song.1.comment"));
        trackServices.saveTrack(feedTrackData);

        feedTrackData.setTrackId(id2);
        feedTrackData.setTrackName(name2);
        feedTrackData.setTrackComment(comment2);
        trackServices.saveTrack(feedTrackData);

        feedTrackData.setTrackId(id3);
        feedTrackData.setTrackName(name3);
        feedTrackData.setTrackComment(comment3);
        trackServices.saveTrack(feedTrackData);
    }
}
