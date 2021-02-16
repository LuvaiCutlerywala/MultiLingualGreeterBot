package bot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Client {

    private static String getToken(){
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\luvai_kcrxbon\\IdeaProjects\\MultiLingualGreetingBot\\token.txt"))){
            return reader.readLine();
        }catch(IOException io){
            System.err.println(io.getMessage());
        }
        return null;
    }

    public static DiscordApiBuilder createClient() throws FileNotFoundException {
        String token = getToken();
        if (token == null || token.isEmpty()) {
            throw new FileNotFoundException("Token file not found or token not found.");
        }
        return new DiscordApiBuilder().setToken(token);
    }
}
