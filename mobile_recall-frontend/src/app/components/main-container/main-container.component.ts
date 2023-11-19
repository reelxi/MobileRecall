import {Component, OnInit} from '@angular/core';
import {CardGroupService} from "../../services/cardgroup.service";
import {CardService} from "../../services/card.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-main-container',
  templateUrl: './main-container.component.html',
  styleUrls: ['./main-container.component.scss']
})
export class MainContainerComponent implements OnInit {

  cardGroups: CardGroup[];

  constructor(private cardGroupService: CardGroupService, private cardService: CardService, private router: Router) {}

  ngOnInit(): void {
    this.cardGroupService.getCardGroups().subscribe((data: CardGroup[]) => this.cardGroups = data);
  }

  openLearnViewWithCardsFromCardGroupID(cardGroup: CardGroup): void {
    this.cardService.getCardsByCardGroup(cardGroup.identifier).subscribe((data: Card[]) => {
      this.cardService.cardsOfSelectedCardGroup = data;
      this.router.navigate(['cardGroup', cardGroup.groupName]).then();
    });
  }

}
