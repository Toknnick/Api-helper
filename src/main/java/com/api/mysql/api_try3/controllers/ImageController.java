package com.api.mysql.api_try3.controllers;

import com.api.mysql.api_try3.models.Image;
import com.api.mysql.api_try3.service.ImageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {
    ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/get/one/{idRoom}/{date}/{time}/{imageSize}/{imageType}")
    public Image getImageDetails(@PathVariable("idRoom") Long idRoom, @PathVariable("date") String date, @PathVariable("time") String time
            , @PathVariable("imageSize") int imageSize, @PathVariable("imageType") String imageType) {
        return imageService.getImage(idRoom, date, time, imageSize, imageType);
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
    public Image createImage(@RequestBody Image image) {
        imageService.createImage(image);
        return image;
    }

    @PutMapping("/update")
    public Image updateImage(@RequestBody Image image) {
        imageService.updateImage(image);
        return image;
    }

    @DeleteMapping("/delete/{idImage}")
    public String deleteImage(@PathVariable("idImage") Long idImage) {
        imageService.deleteImage(idImage);
        return "Image deleted successfully";
    }
}
