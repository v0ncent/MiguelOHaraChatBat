import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public final class Config {
    public static String FEED_PROMPT = null;

    static {
        try {
            FEED_PROMPT = Files.readString(Path.of("feed.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (FEED_PROMPT == null) {
            try {
                throw(new Exception("Could not properly load feeding prompt"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static final Dotenv dotenv = Dotenv.load();

    public static String getENV(String key){
        return dotenv.get(key.toUpperCase(Locale.ROOT));
    }

}
