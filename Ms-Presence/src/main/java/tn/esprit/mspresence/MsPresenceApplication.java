package tn.esprit.mspresence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsPresenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPresenceApplication.class, args);
    }

}
