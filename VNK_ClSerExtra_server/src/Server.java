import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server has started");
        int port = 6789;
        try {
            ServerSocket servSocket = new ServerSocket(port);
            while (true) {
                System.out.println("Waiting for a connection on " + port);
                Socket fromClientSocket = servSocket.accept();

                try (Socket localSocket = fromClientSocket;
                     PrintWriter printWriter = new PrintWriter(localSocket.getOutputStream(), true);
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(localSocket.getInputStream()))) {

                    String firstClientWords = bufferedReader.readLine();
                    System.out.println("Клиент: " + firstClientWords);
                    printWriter.println("Кто там?");

                    String secondClientWords = bufferedReader.readLine();
                    System.out.println("Клиент: " + secondClientWords);
                    printWriter.println("Как Вас зовут, почтальон Печкин?");

                    String thirdClientWords = bufferedReader.readLine();
                    String clientName = thirdClientWords;
                    System.out.println("Клиент: " + thirdClientWords);
                    printWriter.println("Что Вы нам принесли, " + clientName + ", письмо или посылку?");

                    String fourthClientWords = bufferedReader.readLine();
                    System.out.println("Клиент: " + fourthClientWords);
                    if (fourthClientWords.equalsIgnoreCase("письмо")) {
                        printWriter.println("Опустите его в почтовый ящик.");
                    } else {
                        printWriter.println("Поставьте на крыльцо.");
                    }

                    String fifthClientWords = bufferedReader.readLine();
                    System.out.println("Клиент: " + fifthClientWords);

                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }// main
}