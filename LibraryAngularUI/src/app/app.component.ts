import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
   
  public router : Router;
  constructor(router : Router){
    this.router = router;
  }
  title = 'Library Management System';
  onClick(){
    this.router.navigate(["/library"]);
  }
}
