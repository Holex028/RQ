package oleg.datalayer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MessagesFileManager {
    /**Метод, создающий БД-файл с сообщениями*/
    private Path getMessageFileInstance() throws IOException {
        Path file = Path.of("MessagesDataBase.txt");
        if(!Files.exists(Path.of(String.valueOf(file)))) {
            Files.createFile(Path.of("MessagesDataBase.txt"));
        }
        return file;
    }

    /**Метод, записывающий в БД сообщение: отправитель, получатель, текст*/
    public boolean createMessage(String sender, String receiver, String message) {
        try {
            Files.writeString(getMessageFileInstance(), sender + ";" + receiver + ";" + message + ";" + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
