package com.example.photoPlatform.Services.Classes;

import com.example.photoPlatform.DAO.Repositories.PhotoRepository;
import com.example.photoPlatform.DAO.model.Photo;
import com.example.photoPlatform.Services.Interfaces.PhotoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class photoService implements PhotoInterface {

    @Autowired
    PhotoRepository photoRep;

    @Override
    public Photo addPhoto(Photo photo) {
        return photoRep.save(photo);
    }

    @Override
    public List<Photo> findAllPhotos() {
        return photoRep.findAll();
    }

    @Override
    public Photo updatePhoto(Photo photo) {
        return photoRep.save(photo);
    }

    @Override
    public Photo findPhotoById(Long id) {
        Optional<Photo> photo = photoRep.findById(id);
        if (photo.isPresent()){
            return photo.get();
        }
        return null;
    }

    @Override
    public void deletePhotoById(Long id) {
        photoRep.deleteById(id);
    }

    @Override
    public  void addLike(long id) {
        Photo photo = photoRep.getById(id);
        photo.setLikeStatus(true);
        photo.setNbOfLikes(photo.getNbOfLikes()+1);
        photoRep.save(photo);
    }

    @Override
    public  void deleteLike(long id) {
        Photo photo = photoRep.getById(id);
        photo.setLikeStatus(false);
        photo.setNbOfLikes(photo.getNbOfLikes()-1);
        photoRep.save(photo);
    }
}
