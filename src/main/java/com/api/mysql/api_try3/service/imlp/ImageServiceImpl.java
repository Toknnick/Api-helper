package com.api.mysql.api_try3.service.imlp;

import com.api.mysql.api_try3.models.Image;
import com.api.mysql.api_try3.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ImageServiceImpl {
    ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void createImage(Image image) {
        imageRepository.save(image);
    }

    public void deleteImage(Long idImage) {
        imageRepository.deleteById(idImage);
    }
    public Image getImage(Long idRoom, String date, String time, String url) {
        return imageRepository.findImageByCriteria(idRoom, date, time, url);
    }

    public List<Image> getImagesByIdRoom(Long idRoom) {
        return imageRepository.findByIdRoom(idRoom);
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }
}
