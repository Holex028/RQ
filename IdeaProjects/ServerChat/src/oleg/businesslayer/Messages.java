package oleg.businesslayer;

import oleg.datalayer.MessagesFileManager;

public class Messages {
    /**Метод, размещающий сообщение пользователя в БД*/
    public boolean saveNewMessage(String sender, String receiver, String message) {
        MessagesFileManager mfm = new MessagesFileManager();
        return mfm.createMessage(sender, receiver, message);
    }
}
