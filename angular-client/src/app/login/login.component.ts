import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User();
  msg='';

  constructor(private userService :UserService, private router: Router) { }

  ngOnInit(): void {
  }

  login(){
    this.userService.loginUser(this.user).subscribe( data =>{
    console.log(data);
    this.goToUserList();
  },error => {
      console.log(error); 
      this.msg="Bad credentials, please enter valid username and password";
    }
    )
  }
  goToUserList(): void{
    this.router.navigate([`/loginsuccess`]);
  }

  onSubmit(){
    this.login();
  }
}
