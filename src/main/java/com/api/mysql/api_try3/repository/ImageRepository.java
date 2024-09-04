package com.api.mysql.api_try3.repository;

import com.api.mysql.api_try3.models.Image;
import com.api.mysql.api_try3.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query("SELECT i FROM Image i WHERE i.idRoom = :idRoom AND i.date = :date AND i.time = :time AND i.imageSize = :imageSize AND i.imageType = :imageType")
    Image findImageByCriteria(@Param("idRoom") Long idRoom, @Param("date") String date, @Param("time") String time, @Param("imageSize") int imageSize, @Param("imageType") String imageType);

    List<Image> findByIdRoom(Long idRoom);
}
