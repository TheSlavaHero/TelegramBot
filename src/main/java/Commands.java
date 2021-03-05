import org.glassfish.grizzly.utils.Pair;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.apache.commons.io.FileUtils.getFile;

public class Commands {
private static Update update;
    public static SendMessage[] checkForCommand(String command) {
        Character firstChar = command.charAt(0);
        try {
            if (firstChar.equals('/')) {
                switch (command) {
                    case ("/start"):
                        return start();
                }
            }
        } catch (IOException e) {e.printStackTrace();}
        return new SendMessage[0];
    }
    public static SendMessage[] start() throws IOException {
        sendQuery(Method.SEND_DOCUMENT,"?chat_id=326768517&document=BQACAgIAAxkBAAPrYEEl_fFP_66IdX4RrX7bMZA-4VcAAo0OAAKa9wlKOukFV-xjf0YeBA");
        String message_text1 = "Привет!";
        String message_text2 = "Тебя приветствует бот интернет магазиза TShop.";
        String message_text3 = "Чем я могу помочь?";
        Long chat_id = update.getMessage().getChatId();
        SendMessage message1 = new SendMessage()
                .builder()
                .chatId(Long.toString(chat_id))
                .text(message_text1)
                .build();
        SendMessage message2 = new SendMessage()
                .builder()
                .chatId(Long.toString(chat_id))
                .text(message_text2)
                .build();
        SendMessage message3 = new SendMessage()
                .builder()
                .chatId(Long.toString(chat_id))
                .text(message_text3)
                .build();

        return new SendMessage[] {message1, message2, message3};
    }


    public static Update getUpdate() {
        return update;
    }

    public static void setUpdate(Update update) {
        Commands.update = update;
    }


    public static String sendQuery(Method method, String parameters) throws IOException {
        String url = "https://api.telegram.org/bot" + new Bot().getBotToken() + "/" + method.getMethod() + parameters;

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        return connection.getResponseMessage();
    }
}
