public class Main {

    public static void main(String[] args) {
        FTPConfig config = FTPConfig.build("admin", "123456");
        FTPFactory factory = FTPFactory.build(config);
        factory.run();
    }
}
