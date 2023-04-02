import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Photo } from 'src/model/photo';
import { PhotoServiceService } from '../service/photo-service.service';

@Component({
  selector: 'app-photos',
  templateUrl: './photos.component.html',
  styleUrls: ['./photos.component.css']
})

export class PhotosComponent implements OnInit{

  photos!:Photo[]
  url = "https://www.emoji.co.uk/files/apple-emojis/smileys-people-ios/148-person-with-pouting-face.png"

  constructor(private router:Router,private photoService:PhotoServiceService){}


  ngOnInit(): void {
    this.photoService.findAllUPhotos().subscribe(data => {
      console.log(data);this.photos = data;console.log("photos : ",this.photos);
      data.forEach(data => console.log(data.user.name))
    },err => {console.log("error : ",err)})

  }

  logout(){
    localStorage.clear()
    this.router.navigateByUrl("/")
  }

  incrementLikes(photo: Photo): void {
    if (photo.likeStatus) {
      this.photoService.deleteLike(photo.id)
      photo.nbOfLikes--
      photo.likeStatus=false
      console.log("photo- ", photo)

    } else {
      this.photoService.addLike(photo.id)
      photo.nbOfLikes++
      photo.likeStatus=true
      console.log("photo+ ", photo)
    }
  }
  

}
