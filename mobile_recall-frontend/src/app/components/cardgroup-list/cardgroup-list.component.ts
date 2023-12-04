import {Component} from '@angular/core';
import {CardGroupService} from "../../services/cardgroup.service";
import {CardService} from "../../services/card.service";
import {Router} from "@angular/router";
import {Card, CardGroup, User} from "../../services/types";
import {
  CreationFormCardGroupComponent
} from "../../dialog-forms/creation-form-cardgroup/creation-form-cardgroup.component";
import {MatDialog} from "@angular/material/dialog";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-cardgroup-list',
  templateUrl: './cardgroup-list.component.html',
  styleUrls: ['./cardgroup-list.component.scss']
})
export class CardGroupListComponent {

  cardGroupList: CardGroup[] = [];

  creator: User = {
    identifier: "6707d138-43c3-450b-b9bb-b982919ef50b",
    username: "reel",
    password: "reel"
  };

  constructor(private cardGroupService: CardGroupService, private cardService: CardService,
              private router: Router, private matDialog: MatDialog, private snackBar: MatSnackBar) {
    this.fetchData();
  }

  fetchData(): void {
    this.cardGroupService.fetchAllCardGroups().subscribe(responseBody => this.cardGroupList = responseBody);
  }

  openDialog(): void {
    this.matDialog.open(CreationFormCardGroupComponent, {
      disableClose: true,
      width: "500px",
      height: "250px",
      enterAnimationDuration: 500,
      exitAnimationDuration: 500
    }).afterClosed().subscribe(() => this.fetchData());
  }

  openLearnViewOfSelectedCardGroup(cardGroup: CardGroup): void {
    this.cardService.getCardsByCardGroupId(cardGroup.identifier).subscribe((data: Card[]) => {
      if (data.length === 0) {
        this.snackBar.open("empty card groups can't be learned!", "close",
          {
            duration: 2000,
            verticalPosition: "top",
            horizontalPosition: "left"
          });
      } else {
        this.cardService.cardsOfSelectedCardGroup = data;
        this.router.navigate(['learning/', cardGroup.groupName]).then();
      }
    });
  }

}
