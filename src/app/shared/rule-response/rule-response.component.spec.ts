import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RuleResponseComponent } from './rule-response.component';

describe('RuleResponseComponent', () => {
  let component: RuleResponseComponent;
  let fixture: ComponentFixture<RuleResponseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RuleResponseComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RuleResponseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
