import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/model/user';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  apiurl="http://localhost:8080/"

  constructor(private http:HttpClient) { }

  findAllUsers(){
    return this.http.get<User>(this.apiurl+'user/all');
  }

  findUserById(id:number){
    return this.http.get<User>(this.apiurl+'user/findId' + id);
  }

  deleteUserById(id:number){
    return this.http.delete<User>(this.apiurl+'user/delete' + id);
  }

  updateUser(user:User){
    return this.http.put<User>(this.apiurl+'user/update', user);
  }

  addUser(user:any){
    return this.http.post<User>(this.apiurl+'user/add', user);
  }

  findUserByEmail(email:String){
    return this.http.get<User>(this.apiurl+'user/findEmail' + email);
  }

  signinUser(user:any){
    return this.http.post<Boolean>(this.apiurl+'user/signin',user);
  }
}


