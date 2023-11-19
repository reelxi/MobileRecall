import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  @Input()
  user: string = "reel"; // TODO: implement getCurrentUser();
  href: string;
  clock: number;

  constructor(private router: Router) {
  }

  ngOnInit(): void {

    setInterval(() => {
      this.href = this.router.url.replace("%20", " ");
      this.clock = new Date().getTime();
    }, 1000);

  }

}
