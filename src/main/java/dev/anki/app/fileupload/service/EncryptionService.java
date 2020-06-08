package dev.anki.app.fileupload.service;

import java.io.IOException;

public interface EncryptionService {

    final String DEFAULT_ENCRYPTION = "REVERSE_BYTES";

    byte[] encryptDecryptFile(byte[] bytes, String encryptionType) throws IOException;


}
