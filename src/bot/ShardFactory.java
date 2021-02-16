package bot;

import org.javacord.api.DiscordApiBuilder;

public class ShardFactory extends Client{

    static final int NUMBER_OF_SHARDS = 2;
    public static final int INTERACTIVE_SHARD = 0;
    public static final int STATIC_SHARD = 1;

    public static void createShards(DiscordApiBuilder client){
        client.setTotalShards(NUMBER_OF_SHARDS);
        client.setCurrentShard(INTERACTIVE_SHARD);
    }

    public static void loginShard(DiscordApiBuilder client, String shard) {
        if (shard.equals("Interactive")) {
            client.setCurrentShard(INTERACTIVE_SHARD).addMessageCreateListener(InteractiveGreeter.onMessage()).login().join();
        } else {
            client.setCurrentShard(STATIC_SHARD).login().join();
        }
    }

}
