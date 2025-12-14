package co.yuno.YunoTalkTrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class YunoTalkTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(YunoTalkTrackApplication.class, args);
	}

}
