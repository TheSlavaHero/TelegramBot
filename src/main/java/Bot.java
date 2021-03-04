import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        Commands.setUpdate(update);
        SendMessage[] messages = Commands.checkForCommand(update.getMessage().getText()).getFirst();
        SendAnimation animation = Commands.checkForCommand(update.getMessage().getText()).getSecond();

        try {
            if (animation != null) {execute(animation);}
            for (SendMessage message : messages) {
                execute(message);
                Thread.sleep(1500);
            }
        } catch (TelegramApiException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "t_magazin_bot";
    }

    @Override
    public String getBotToken() {
        return "1480440702:AAH12WpGwHRPUuUSIHBfrf4kTGTg6In81uc";
    }
}
