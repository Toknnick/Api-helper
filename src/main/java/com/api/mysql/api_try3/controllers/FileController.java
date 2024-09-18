package com.api.mysql.api_try3.controllers;

import com.api.mysql.api_try3.models.File;
import com.api.mysql.api_try3.service.imlp.FileServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {

    FileServiceImpl fileService;

    public FileController(FileServiceImpl fileService) {
        this.fileService = fileService;
    }


    @GetMapping("/get/one/{idRoom}/{date}/{time}/{url}")
    public File getFileDetails(@PathVariable("idRoom") Long idRoom, @PathVariable("date") String date, @PathVariable("time") String time, @PathVariable("url") String url) {
        return fileService.getFile(idRoom, date, time,url);
    }

    @GetMapping("/get/all/{idRoom}")
    public List<File> getFilesByIdRoom(@PathVariable("idRoom") Long idRoom) {
        return fileService.getFilesByIdRoom(idRoom);
    }

    @GetMapping("/get/all")
    public List<File> getAllFiles() {
        return fileService.getAllFiles();
    }

    @PostMapping("/create")
    public String createFile(@RequestBody File file) {
        fileService.createFile(file);
        return "File created";
    }

    @DeleteMapping("/delete/{idFile}")
    public String deleteFile(@PathVariable("idFile") Long idFile) {
        fileService.deleteFile(idFile);
        return "File deleted successfully";
    }
}
