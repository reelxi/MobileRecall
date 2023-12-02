import {Component, OnInit} from '@angular/core';
import {CardGroupService} from "../../services/cardgroup.service";
import {CardService} from "../../services/card.service";
import {Router} from "@angular/router";
import {Card, CardGroup} from "../../services/types";

@Component({
  selector: 'app-main-container',
  templateUrl: './main-container.component.html',
  styleUrls: ['./main-container.component.scss']
})
export class MainContainerComponent implements OnInit {

  showDialog: boolean;
  cardGroups: CardGroup[];

  constructor(private cardGroupService: CardGroupService, private cardService: CardService, private router: Router) {
  }

  ngOnInit(): void {
    this.cardGroupService.getAllCardGroups().subscribe((data: CardGroup[]) => this.cardGroups = data);
  }

  openLearnViewWithCardsFromCardGroupID(cardGroup: CardGroup): void {
    this.cardService.getCardsByCardGroupId(cardGroup.identifier).subscribe((data: Card[]) => {
      this.cardService.cardsOfSelectedCardGroup = data;
      this.router.navigate(['learnView/', cardGroup.groupName]).then();
    });
  }

  openCardGroupCreationDialog(): void {
    this.showDialog = !this.showDialog;
  }
}
