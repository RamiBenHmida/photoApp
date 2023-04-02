package com.example.photoPlatform.DAO.Repositories;

import com.example.photoPlatform.DAO.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
