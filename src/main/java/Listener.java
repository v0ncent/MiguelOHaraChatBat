import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Listener extends ListenerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        LOGGER.info("Miguel watching the multiverse!");
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        for (TextChannel channel : event.getGuild().getTextChannels()) {
            if (channel.getName().equals("bot-chat")) {
                break;
            }
            event.getGuild().createTextChannel("bot-chat").queue();
        }

        if (event.getChannel().getName().equals("bot-chat")) {

        }

    }

    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        for (TextChannel channel : event.getGuild().getTextChannels()) {
            if (channel.getName().equals("bot-chat")) {
                return;
            }
        }

        event.getGuild().createTextChannel("bot-chat").queue();
    }
}
