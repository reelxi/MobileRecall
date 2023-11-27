import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreationDialogCardgroupComponent } from './creation-dialog-cardgroup.component';

describe('CreationDialogCardgroupComponent', () => {
  let component: CreationDialogCardgroupComponent;
  let fixture: ComponentFixture<CreationDialogCardgroupComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreationDialogCardgroupComponent]
    });
    fixture = TestBed.createComponent(CreationDialogCardgroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
