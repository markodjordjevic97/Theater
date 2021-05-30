import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RepertoarsComponent } from './repertoars.component';

describe('RepertoarsComponent', () => {
  let component: RepertoarsComponent;
  let fixture: ComponentFixture<RepertoarsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RepertoarsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RepertoarsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
