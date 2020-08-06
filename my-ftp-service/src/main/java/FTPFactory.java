import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;

import java.util.ArrayList;

public final class FTPFactory {

    private FTPConfig config;
    private FtpServer server;


    private FTPFactory(FTPConfig config) {
        this.config = config;
        init();
    }

    public static FTPFactory build(FTPConfig config) {
        return new FTPFactory(config);
    }

    public void run() {
        try {
            this.server.start();
            System.out.println("FTP服务器启动成功");
        } catch (FtpException e) {
            System.out.println("FTP服务器启动失败");
            e.printStackTrace();
        }
    }

    private void init() {
        FtpServerFactory factory = new FtpServerFactory();
        BaseUser baseUser = new BaseUser();
        WritePermission permission = new WritePermission();
        ArrayList<Authority> list = new ArrayList<Authority>();
        list.add(permission);
        baseUser.setAuthorities(list);
        baseUser.setName(this.config.getUserName());
        baseUser.setPassword(this.config.getPassword());
        baseUser.setHomeDirectory(this.config.getBaseDir());
        try {
            factory.getUserManager().save(baseUser);
        } catch (FtpException e) {
            e.printStackTrace();
        }
        this.server = factory.createServer();
    }

}
