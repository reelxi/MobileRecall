import {Component, Input} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  title: string = 'Mobile Recall';

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
