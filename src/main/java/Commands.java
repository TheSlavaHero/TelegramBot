import org.glassfish.grizzly.utils.Pair;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Commands {
private static Update update;
    public static Pair<SendMessage[], SendAnimation> checkForCommand(String command) {
        Character firstChar = command.charAt(0);
        if (firstChar.equals('/')) {
            switch (command) {
                case("/start"):
                    return start();
            }
        }
        return null;
    }
    public static Pair<SendMessage[], SendAnimation> start() {
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
//        return new SendMessage[] {message1, message2, message3};
        return new Pair<>(new SendMessage[] {message1, message2, message3}, null);
    }


    public static Update getUpdate() {
        return update;
    }

    public static void setUpdate(Update update) {
        Commands.update = update;
    }
}
