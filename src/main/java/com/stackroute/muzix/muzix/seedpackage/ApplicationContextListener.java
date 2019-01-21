//package com.stackroute.muzix.muzix.seedpackage;
//
//import com.stackroute.muzix.muzix.domain.Track;
//import com.stackroute.muzix.muzix.repository.TrackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.ContextRefreshedEvent;
//
//@Configuration
//public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {
//    private TrackRepository trackRepository;
//    @Autowired
//    public ApplicationContextListener(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        Track track1=Track.builder().trackName("gulebasfs").trackComment("Prabhu Dsaffdsfeba").build();
//        trackRepository.save(track1);
//        Track track2=Track.builder().trackName("gsdfdsfsdfsaffrul").trackComment("Prabwefsdfsfgdghu").build();
//        trackRepository.save(track2);
//
//    }
//}
