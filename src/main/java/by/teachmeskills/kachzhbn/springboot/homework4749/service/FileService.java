package by.teachmeskills.kachzhbn.springboot.homework4749.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

@Service
public class FileService {

    public boolean uploadFile(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        file.transferTo(Path.of("D:\\TeachMeSkills\\SpringBoot\\src\\main\\resources\\uploaded-files\\" + file.getOriginalFilename()));
        return true;
    }
}
