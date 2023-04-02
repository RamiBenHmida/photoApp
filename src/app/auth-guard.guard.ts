import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserServiceService } from './service/user-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardGuard implements CanActivate {
  sLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';

  constructor(private router:Router,private userService:UserServiceService){

  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      

      if (localStorage.getItem("user") != null ) {
        //console.log("checking token storage token"+this.tokenStorage.getToken())
        //console.log("checking token storage user"+this.tokenStorage.getUser())

        
        return true;
      }else{
        
        this.router.navigateByUrl('/');
        return false;
      }
  }
  
}
