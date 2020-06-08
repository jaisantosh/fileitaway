package dev.anki.app.fileupload.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface FileItAwayService {

    String DEFAULT_STORAGE_LOCATION = System.getProperty("user.home");

    boolean saveFile(byte[] bytes, boolean isEncrypted, String userId) throws IOException;

    boolean saveFileToDisk(byte[] bytes, String path) throws IOException;

    List<String> listOfFiles(String userId);

    byte[] readFile(String fileName, String userId) throws IOException;

    boolean deleteFile(String userId, String fileName) throws IOException;

}
