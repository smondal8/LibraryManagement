import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

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
  version = environment.appVersion;
  onClick(){
    this.router.navigate(["/library"]);
  }
}
