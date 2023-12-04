import {Component} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CardGroupService} from "../../services/cardgroup.service";
import {MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-creation-form-cardgroup',
  templateUrl: './creation-form-cardgroup.component.html',
  styleUrls: ['./creation-form-cardgroup.component.scss']
})
export class CreationFormCardGroupComponent {

  formGroup_CardGroup = new FormGroup({
    groupName: new FormControl('', [Validators.required, Validators.minLength(3)]),
    creator: new FormControl({value: '6707d138-43c3-450b-b9bb-b982919ef50b', disabled: true}, [Validators.required])
  });

  // TODO: Creator readonly field, displaying current users name

  constructor(private cardGroupService: CardGroupService, private ref: MatDialogRef<any>) {
  }

  postCardGroupRequest(): void {
    if (this.formGroup_CardGroup.controls['groupName'].valid) {
      let dto = `
      {
        "groupName": "${this.formGroup_CardGroup.get('groupName')?.value}",
        "creatorId": "${this.formGroup_CardGroup.get('creator')?.value}"
      }`;
      this.cardGroupService.createCardGroups(dto).subscribe();
    }
  }

  close(): void {
    this.ref.close();
  }
}
