package bot;

import org.javacord.api.DiscordApi;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class InteractiveGreeter{

    public static MessageCreateListener onMessage() {
        return new MessageCreateListener() {
            @Override
            public void onMessageCreate(MessageCreateEvent messageCreateEvent){
                messageCreateEvent.getChannel().sendMessage(ResponseEngine.getDynamicResponse(messageCreateEvent.getMessageContent()));
            }
        };
    }
}
