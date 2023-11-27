import {Component, Input} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-navigation-bar',
  templateUrl: './navigation-bar.component.html',
  styleUrls: ['./navigation-bar.component.scss']
})
export class NavigationBarComponent {

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
