package com.jeka8833.tntclientendpoints.services.discordbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.jeka8833.tntclientendpoints.services.discordbot",
        "com.jeka8833.tntclientendpoints.services.general"
})
public class RunDiscordBot {
    public static void main(String[] args) {
        SpringApplication.run(RunDiscordBot.class, args);
    }
}
