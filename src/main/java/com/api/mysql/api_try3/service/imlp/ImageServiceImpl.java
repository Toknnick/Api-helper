package com.api.mysql.api_try3.service.imlp;

import com.api.mysql.api_try3.models.Image;
import com.api.mysql.api_try3.repository.EventRepository;
import com.api.mysql.api_try3.repository.ImageRepository;
import com.api.mysql.api_try3.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ImageServiceImpl implements ImageService {
    ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image createImage(Image image) {
        imageRepository.save(image);
        return image;
    }

    @Override
    public String deleteImage(Long idImage) {
        imageRepository.deleteById(idImage);
        return "Success";
    }

    @Override
    public Image updateImage(Image image) {
        imageRepository.save(image);
        return image;
    }

    @Override
    public Image getImage(Long idRoom, String date, String time, String imageData, String imageType) {
        return imageRepository.findImageByCriteria(idRoom, date, time, imageData, imageType);
    }

    @Override
    public List<Image> getImagesByIdRoom(Long idRoom) {
        return imageRepository.findByIdRoom(idRoom);
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }
}
