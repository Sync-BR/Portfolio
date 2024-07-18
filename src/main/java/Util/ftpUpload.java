package Util;

import config.production;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import javax.servlet.http.Part;
import javax.sound.sampled.AudioInputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author SYNC
 * @ftpUpload Classe responsanvel pelas operações fpt
 */
public class ftpUpload {

    production config = new production();

    public void uploadIMG(Path img) {
        //Verificar se a imagem está nulla
        if (img != null) {
            FTPClient ftpCliente = new FTPClient();
            try {
                ftpCliente.connect(config.host, config.port);
                System.out.println("Efetuando conexão com ftp.");
                boolean login = ftpCliente.login(config.user, config.pass);
                if(login){
                    System.out.println("Login efetuado com sucesso!");
                    //Definir o modo de transferencia para passivo
                    ftpCliente.enterLocalPassiveMode();
                    //Definir o tipo de arquivo a ser transferido.
                    ftpCliente.setFileType(FTP.BINARY_FILE_TYPE);
                    //Enviar arquivo por ftp
                     try (InputStream inputStream = new FileInputStream(img.toFile())) {
                         boolean done = ftpCliente.storeFile(config.remoteFilePath + img.getFileName().toString(), inputStream);
                         if(done){
                             System.out.println("Sucesso");
                         } else {
                             System.out.println("Falhou");
                         }
                     }
                
                }
            } catch (IOException e) {
                e.getMessage();
            }
        } else {
            System.out.println("Sem imagem");
        }

    }
}
