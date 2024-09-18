package com.api.mysql.api_try3.repository;

import com.api.mysql.api_try3.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {
    @Query("SELECT i FROM File i WHERE i.idRoom = :idRoom AND i.date = :date AND i.time = :time AND i.url = :url")
    File findFileByCriteria(@Param("idRoom") Long idRoom, @Param("date") String date, @Param("time") String time, @Param("url") String url);

    List<File> findByIdRoom(Long idRoom);
}
