package oleg.businesslayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;

public class Messaging {
    public boolean outMessage() {
        //Нужно посылать inetAdress и сообщение . Тогдя для разАвторизации, нужно при написании метода Exit приписать метод удаления из БД ip-шника
        BufferedReader messageData = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введить никнейм получателя сообщения и нажмите \"Enter\"");
        String nickNameReceiverOfTheMessage = null;
        try {
            nickNameReceiverOfTheMessage = messageData.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Введить текст сообщения и нажмите \"Enter\"");
        String textOfMessage = null;
        try {
            textOfMessage = messageData.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String userOutMessage = "outMassage;" + nickNameReceiverOfTheMessage + textOfMessage + ";";
        try(Socket socket = new Socket("0.0.0.0", 8000);
            OutputStream os = socket.getOutputStream()) {
            os.write(userOutMessage.getBytes(Charset.forName("UTF-8")));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
            //переписать return, добавив код возврата из сервера, который можно скопировать из Authentication
        return true;
    }
}
