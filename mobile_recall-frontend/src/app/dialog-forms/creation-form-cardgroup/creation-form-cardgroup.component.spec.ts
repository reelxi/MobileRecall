import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreationFormCardGroupComponent } from "./creation-form-cardgroup.component";

describe('CreationDialogCardgroupComponent', () => {
  let component: CreationFormCardGroupComponent;
  let fixture: ComponentFixture<CreationFormCardGroupComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreationFormCardGroupComponent]
    });
    fixture = TestBed.createComponent(CreationFormCardGroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
