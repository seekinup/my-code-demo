import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("ftp upload!!!".getBytes());
        boolean b = FTPUtils.uploadFile("127.0.0.1", 80, "admin", "123456", "/", "hello.txt", in);
        System.out.println(b);
    }
}
