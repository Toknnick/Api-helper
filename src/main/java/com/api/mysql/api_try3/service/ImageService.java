package com.api.mysql.api_try3.service;

import com.api.mysql.api_try3.models.Image;

import java.util.List;

public interface ImageService {
    public Image createImage(Image image);
    public String deleteImage(Long idImage);
    public Image updateImage(Image image);
    public Image getImage(Long idRoom, String date, String time, int imageSize,String imageType);
    public List<Image> getImagesByIdRoom(Long idRoom);
    public List<Image> getAllImages();
}
