package com.api.mysql.api_try3.controllers;

import com.api.mysql.api_try3.models.Image;
import com.api.mysql.api_try3.repository.ImageRepository;
import com.api.mysql.api_try3.service.ImageService;
import com.api.mysql.api_try3.service.imlp.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    ImageServiceImpl imageService;

    public ImageController(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }


    @GetMapping("/get/one/{idRoom}/{date}/{time}/{url}")
    public Image getImageDetails(@PathVariable("idRoom") Long idRoom, @PathVariable("date") String date, @PathVariable("time") String time, @PathVariable("url") String url) {
        return imageService.getImage(idRoom, date, time,url);
    }

    @GetMapping("/get/all/{idRoom}")
    public List<Image> getImagesByIdRoom(@PathVariable("idRoom") Long idRoom) {
        return imageService.getImagesByIdRoom(idRoom);
    }

    @GetMapping("/get/all")
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @PostMapping("/create")
    public String createImage(@RequestBody Image image) {
        imageService.createImage(image);
        return "Image created";
    }

    @DeleteMapping("/delete/{idImage}")
    public String deleteImage(@PathVariable("idImage") Long idImage) {
        imageService.deleteImage(idImage);
        return "Image deleted successfully";
    }
}
