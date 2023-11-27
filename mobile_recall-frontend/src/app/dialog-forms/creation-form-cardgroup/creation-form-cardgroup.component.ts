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
    identifier: "IH33F-S4PO4J-SP5H5F-SPI5HF",
    username: "reel",
    password: ""
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
