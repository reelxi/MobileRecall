import { Component } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {User} from "../../services/types";
import {CardGroupService} from "../../services/cardgroup.service";

@Component({
  selector: 'app-creation-form-cardgroup',
  templateUrl: './creation-form-cardgroup.component.html',
  styleUrls: ['./creation-form-cardgroup.component.scss']
})
export class CreationFormCardGroupComponent {

  creator: User = {
    identifier: "6707d138-43c3-450b-b9bb-b982919ef50b",
    username: "reel",
    password: "reel"
  };

  formGroup_CardGroup = new FormGroup({
    groupName: new FormControl<string>('', [Validators.required, Validators.minLength(1)]),
    creator: new FormControl<string>(this.creator.username, [Validators.required])
  });

  constructor(private cardGroupService: CardGroupService) {
  }

  postCardGroupRequest(): void {
    this.cardGroupService.saveCardGroups(this.formGroup_CardGroup.controls['groupName'].value);
  }

}
