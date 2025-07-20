package org.mapledpmlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public void run() {
        new DPMMain();
    }

    public static void main(String[] args) {
        //SpringApplication.run(Main.class, args);
        Main m = new Main(); m.run();
    }
}