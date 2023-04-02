import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Photo } from 'src/model/photo';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PhotoServiceService {

  apiurl="http://localhost:8080/"

  constructor(private http:HttpClient) { }

  findAllUPhotos(){
    return this.http.get<Photo[]>(this.apiurl+'photo/all');
  }

  findPhotoById(id:number){
    return this.http.get<Photo>(this.apiurl+'photo/find' + id);
  }

  deletePhotoById(id:number){
    return this.http.delete<Photo>(this.apiurl+'photo/delete' + id);
  }

  updatePhoto(photo:Photo){
    return this.http.put<Photo>(this.apiurl+'photo/update', photo);
  }

  addPhoto(photo:Photo){
    return this.http.post<Photo>(this.apiurl+'photo/add', photo);
  }

  addLike(id:any){
    console.log(this.apiurl+'photo/likeAdd/', id)
    return this.http.put<Photo>(this.apiurl+'photo/likeAdd/', id);
  }

  deleteLike(id:any){
    return this.http.put<Photo>(this.apiurl+'photo/likeDelete/', id);
  }


}
