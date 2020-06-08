package dev.anki.app.fileupload.controller;

import dev.anki.app.fileupload.service.FileItAwayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class FileItAwayController {

    private final String DEFAULT_USER_NAME = "DEFAULT";

    @Autowired
    private FileItAwayService fileItAwayService;

    @GetMapping(value = "/health")
    public ResponseEntity<String> healthCheck() {
         return new ResponseEntity<>("Thank you, I am doing HTTPStatus.OK", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{file=.+}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) throws IOException {
        fileItAwayService.deleteFile(fileName, DEFAULT_USER_NAME);
        return new ResponseEntity<>("Thank you for checking on me i am doing HTTPStatus.OK", HttpStatus.OK);
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("Hello");
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getBytes());
        System.out.println(file.getOriginalFilename());
        fileItAwayService.saveFile(file.getBytes(), true, DEFAULT_USER_NAME);
        return new ResponseEntity<>("Thank you, I am doing HTTPStatus.OK", HttpStatus.OK);
    }

    @GetMapping(value = "/files")
    public ResponseEntity<String> getAllFiles() throws IOException {
        fileItAwayService.listOfFiles(DEFAULT_USER_NAME);
        return new ResponseEntity<>("Thank you, I am doing HTTPStatus.OK", HttpStatus.OK);
    }

}
