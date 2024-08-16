
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
    
    public final String urlRepository;
    
    //Configuração do ftp
    public final String host;
    public final int port;
    public final String user;
    public final String pass;
    public final String remoteFilePath;
}
