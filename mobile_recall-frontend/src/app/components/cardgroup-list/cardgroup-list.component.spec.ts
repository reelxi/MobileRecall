import {ComponentFixture, TestBed} from '@angular/core/testing';

import {CardGroupListComponent} from './cardgroup-list.component';

describe('CardgroupListComponent', () => {
  let component: CardGroupListComponent;
  let fixture: ComponentFixture<CardGroupListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CardGroupListComponent]
    });
    fixture = TestBed.createComponent(CardGroupListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
