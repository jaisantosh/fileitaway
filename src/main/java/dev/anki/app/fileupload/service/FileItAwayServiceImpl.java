package dev.anki.app.fileupload.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileItAwayServiceImpl implements FileItAwayService, EncryptionService {

    @Override
    public boolean saveFile(byte[] bytes, boolean shouldEncrypt, String userId) {

System.out.println("1");
        if (shouldEncrypt) {
            System.out.println("2");
            bytes= encryptDecryptFile(bytes, "");
        }
        return saveFileToDisk(bytes, userId);
    }

    public boolean saveFileToDisk(byte[] bytes, String path)  {
        File file = new File(DEFAULT_STORAGE_LOCATION+"/"+path+"/filename.pdf");
        OutputStream outputStream = null;
        try {
            System.out.println("3");
            outputStream = new FileOutputStream(file);
            outputStream.write(bytes);
            System.out.println(7);

        } catch (FileNotFoundException e) {
            System.out.println("4");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("5");
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public byte[] encryptDecryptFile(byte[] bytes, String encryptionType) {
        for (int i = 0; i < bytes.length / 2; i++) {
            byte temp = bytes[i];
            bytes[i] = bytes[bytes.length - i - 1];
            bytes[bytes.length - i - 1] = temp;
        }
        System.out.println("6");
        return bytes;
    }

    public byte[] readFile(String fileName, String userId) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(DEFAULT_STORAGE_LOCATION + "/" + userId + "/" + fileName));
        return encryptDecryptFile(bytes, "");

    }

    @Override
    public List<String> listOfFiles(String userId) {
        return null;
    }

    @Override
    public boolean deleteFile(String userId, String fileName) throws IOException {
        Files.delete(Paths.get(DEFAULT_STORAGE_LOCATION + "/" + userId + "/" + fileName));
        return true;

    }
}
