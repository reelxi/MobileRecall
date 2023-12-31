import {Component, Input} from '@angular/core';
import {Card} from "../../services/types";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent {

  @Input()
  card: Card;

}
