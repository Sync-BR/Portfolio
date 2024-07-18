
package config;

/**
 *
 * @author SYNC
 * @Configuração
 */
public class production {

    public production() {
        this.urlRepository = "https://github.com/Sync-BR/";
        this.host = "127.0.0.1";
        this.port = 21;
        this.user = "admin";
        this.pass = "1415";
        this.remoteFilePath = "/Pasta/";
    }
    
    public String urlRepository;
    
    //Configuração do ftp
    public String host;
    public int port;
    public String user;
    public String pass;
    public String remoteFilePath;
}
