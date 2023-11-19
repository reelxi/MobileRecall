import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LearnViewComponent } from './learn-view.component';

describe('LearnViewComponent', () => {
  let component: LearnViewComponent;
  let fixture: ComponentFixture<LearnViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LearnViewComponent]
    });
    fixture = TestBed.createComponent(LearnViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
