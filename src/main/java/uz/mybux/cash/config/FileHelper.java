package uz.mybux.cash.config;

import lombok.SneakyThrows;
import org.apache.commons.lang3.SystemUtils;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileHelper {
    public String getMD(String string) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(string.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        String checksum = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return checksum;
    }
    @SneakyThrows
    public String getFolder(Long second,String folder){


        String hash=getMD(String.valueOf(second));
        String f1 = hash.substring(0,1);
        String f2 = hash.substring(1,2);

        String final_folder = folder+"/"+f1+"/"+f2;
        return final_folder;
    }
}
