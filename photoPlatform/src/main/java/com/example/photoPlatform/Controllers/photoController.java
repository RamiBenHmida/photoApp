package com.example.photoPlatform.Controllers;

import com.example.photoPlatform.DAO.model.Photo;
import com.example.photoPlatform.Services.Interfaces.PhotoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/photo")
@RestController
public class photoController {

    @Autowired
    PhotoInterface photoInterface;

    @PostMapping("/add")
    public Photo addPhoto(@RequestBody Photo photo)  {
        System.out.println("photo that came : "+photo.user);
        return photoInterface.addPhoto(photo);
    }

    @PutMapping("/update")
    public Photo updatePhoto(@RequestBody Photo photo) {
        return photoInterface.updatePhoto(photo);
    }

    @GetMapping("/all")
    public List<Photo> findAllPhotos() {
        return photoInterface.findAllPhotos();
    }

    @GetMapping("/find/{id}")
    public Photo findPhotoById(@PathVariable long id) {
        return photoInterface.findPhotoById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePhotoById(@PathVariable long id) {
        photoInterface.deletePhotoById(id);
    }

    @PutMapping("/likeDelete/{id}")
    public void deleteLike(@PathVariable long id) {
        photoInterface.deleteLike(id);
    }

    @PutMapping("/likeAdd/{id}")
    public void addLike(@PathVariable long id) {
        photoInterface.addLike(id);
    }


}
