package main;

import bot.*;
import org.javacord.api.DiscordApiBuilder;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args){
        try{
            DiscordApiBuilder builder = Client.createClient();
            ShardFactory.createShards(builder);
            ShardFactory.loginShard(builder,"Interactive");
        } catch(FileNotFoundException fnf){
            System.err.println(fnf.getMessage());
        }
    }

}
