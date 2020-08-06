public class FTPConfig {
    public static final String DEFAULT_BASE_DIR = "F:/03.temp";

    private String userName;
    private String password;
    private String baseDir;

    public FTPConfig() {
    }

    public FTPConfig(String userName, String password) {
        this(userName, password, DEFAULT_BASE_DIR);
    }

    public FTPConfig(String userName, String password, String baseDir) {
        this.userName = userName;
        this.password = password;
        this.baseDir = baseDir;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public String getBaseDir() {
        return baseDir;
    }

    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }


    public static FTPConfig build(String userName, String password) {
        return new FTPConfig(userName, password);
    }

    public static FTPConfig build(String userName, String password, String baseDir) {
        return new FTPConfig(userName, password, baseDir);
    }
}
