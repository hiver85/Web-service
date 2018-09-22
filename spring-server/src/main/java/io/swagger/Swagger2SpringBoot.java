package io.swagger;

import io.swagger.model.Room;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "io.swagger", "io.swagger.api" })
public class Swagger2SpringBoot implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        //int no_bedroom, float surface, int floor, boolean stt, String city, float price, String desc
        Room.rooms.add(new Room(2, 15, 0, false, "Paris", 25, "room1"));
        Room.rooms.add(new Room(2, 15, 1, false, "Toulouse", 27, "room2"));
        Room.rooms.add(new Room(3, 20, 0, false, "Paris", 30, "room3"));
        Room.rooms.add(new Room(3, 22, 1, false, "Toulouse", 33, "room4"));
        Room.rooms.add(new Room(4, 30, 2, false, "Nante", 40, "room5"));
        Room.rooms.add(new Room(2, 20, 1, false, "Nante", 30, "room6"));
        System.out.println(Room.rooms.get(0).getIdRoom()+Room.rooms.get(0).getCity()+Room.rooms.get(0).getNoBedroom());
        System.out.println(Room.rooms.get(1).getIdRoom()+Room.rooms.get(1).getCity()+Room.rooms.get(1).getNoBedroom());
        System.out.println(Room.rooms.get(2).getIdRoom()+Room.rooms.get(2).getCity()+Room.rooms.get(2).getNoBedroom());
        
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
