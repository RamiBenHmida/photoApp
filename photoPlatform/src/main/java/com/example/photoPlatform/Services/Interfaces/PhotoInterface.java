package com.example.photoPlatform.Services.Interfaces;

import com.example.photoPlatform.DAO.model.Photo;

import java.util.List;

public interface PhotoInterface {

    public Photo addPhoto(Photo photo);

    public List<Photo> findAllPhotos();

    public Photo updatePhoto(Photo photo);

    public Photo findPhotoById(Long id);

    public void deletePhotoById(Long id);

    void addLike(long id);

    void deleteLike(long id);
}
