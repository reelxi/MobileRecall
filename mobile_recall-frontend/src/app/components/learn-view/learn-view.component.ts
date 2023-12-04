import {Component} from '@angular/core';
import {CardGroupService} from "../../services/cardgroup.service";
import {CardService} from "../../services/card.service";
import {Card} from "../../services/types";

@Component({
  selector: 'app-learn-view',
  templateUrl: './learn-view.component.html',
  styleUrls: ['./learn-view.component.scss']
})
export class LearnViewComponent {
  selectedCardIndex: number = 0;
  cardStack: Card[] = [];
  card: Card;
  showHint: boolean = false;

  constructor(private cardGroupService: CardGroupService, private cardService: CardService) {
    this.cardStack = cardService.cardsOfSelectedCardGroup;
    this.cardGenerator();
  }

  switchHint(): void {
    this.showHint = !this.showHint;
  }

  cardGenerator(): void {
    this.card = this.cardStack[this.selectedCardIndex++];
    this.showHint = false;
    //this.messages = [{ severity: "info", detail: "Hint: " + this.card.expectedAnswer }];
  }

  endDialog() {
    console.log("ENDED THE QUIZ :)");
  }
}
