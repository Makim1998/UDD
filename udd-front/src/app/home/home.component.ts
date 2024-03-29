import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LOGIN_PATH } from '../constants/routes';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(
    public authService: AuthService,
    public router: Router,
  ) { }

  ngOnInit(): void {
  }

  odjava(): void{
    this.authService.deleteUser();
    this.router.navigate([LOGIN_PATH]);
  }

}
