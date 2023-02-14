import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
//        String host = "127.0.0.1";
        String host = "netology.homework";
        int portNumber = 6789;
        System.out.println("Client has started");
        Socket socket = new Socket(host, portNumber);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

        String str = "Тук-тук!";
        printWriter.println(str);
        System.out.println("Запрос серверу отправлен.");
        System.out.println();
        System.out.println("Клиент: " + str);

        // Начало диалога
        String serverString;
        serverString = bufferedReader.readLine();
        System.out.println("Сервер: " + serverString);
        str = "Это я, почтальон Печкин";
        printWriter.println(str);
        System.out.println("Клиент: " + str);

        serverString = bufferedReader.readLine();
        System.out.println("Сервер: " + serverString);
        str = "Игорь Иванович";
        printWriter.println(str);
        System.out.println("Клиент: " + str);

        serverString = bufferedReader.readLine();
        System.out.println("Сервер: " + serverString);
        str = "Письмо";
        printWriter.println(str);
        System.out.println("Клиент: " + str);
//        str = "Посылку";
//        printWriter.println(str);
//        System.out.println("Клиент: " + str);

        serverString = bufferedReader.readLine();
        System.out.println("Сервер: " + serverString);
        str = "Все сделал. До свидания!";
        printWriter.println(str);
        System.out.println("Клиент: " + str);

        bufferedReader.close();
        printWriter.close();
        socket.close();
    }// main
}