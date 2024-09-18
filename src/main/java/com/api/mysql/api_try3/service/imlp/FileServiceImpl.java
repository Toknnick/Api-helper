package com.api.mysql.api_try3.service.imlp;

import com.api.mysql.api_try3.models.File;
import com.api.mysql.api_try3.repository.FileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class FileServiceImpl {
    FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void createFile(File file) {
        fileRepository.save(file);
    }

    public void deleteFile(Long idFile) {
        fileRepository.deleteById(idFile);
    }
    public File getFile(Long idRoom, String date, String time, String url) {
        return fileRepository.findFileByCriteria(idRoom, date, time, url);
    }

    public List<File> getFilesByIdRoom(Long idRoom) {
        return fileRepository.findByIdRoom(idRoom);
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }
}
