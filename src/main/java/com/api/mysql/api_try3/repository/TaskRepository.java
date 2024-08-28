package com.api.mysql.api_try3.repository;

import com.api.mysql.api_try3.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t WHERE t.idRoom = :idRoom AND t.date = :date AND t.time = :time AND t.name = :name AND t.points = :points AND t.checkBoxes = :checkBoxes")
    List<Task> findTaskByCriteria(@Param("idRoom") Long idRoom, @Param("date") String date, @Param("time") String time, @Param("name") String name, @Param("points") String points, @Param("checkBoxes") String checkBoxes);

    List<Task> findByIdRoom(Long idRoom);
}
