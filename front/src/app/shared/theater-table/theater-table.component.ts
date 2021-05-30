import { Router } from '@angular/router';
import { NotificationService } from './../services/notification.service';
import { SharedService } from './../services/shared.service';
import {
  AfterViewInit,
  Component,
  Input,
  OnInit,
  ViewChild,
} from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { PerformancesService } from '../services/performances.service';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-theater-table',
  templateUrl: './theater-table.component.html',
  styleUrls: ['./theater-table.component.scss'],
})
export class TheaterTableComponent implements OnInit, AfterViewInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  @Input() data: any[] = [];
  @Input() filterDataPlaceholder: string = '';

  activeUser = JSON.parse(localStorage.getItem('USER_DATA'))


  displayedColumns: any = [
    'Id',
    'Naziv',
    'Trajanje',
    'Opis',
    'Kreator',
    'Zanr',
    'Cena',
    'Kupovina',
  ];

  dataSource: MatTableDataSource<any>;
  dataCellDef: any[] = [];

  manipulateShow: any[] = [];

  constructor(
    private sharedService: SharedService,
    private performanceService: PerformancesService,
    private notificationService: NotificationService,
    public router: Router
  ) {}

  ngOnInit() {
    const cellData = this.data.filter((data) => this.premappedObject(data));

    this.dataSource = new MatTableDataSource(cellData);
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  premappedObject(data: any) {
    let mappedData = [];
    Object.entries(data).forEach((item) => {
      let value = item.pop();
      this.dataCellDef.push(item.pop());
      mappedData = [...mappedData, value];
    });
    return mappedData;
  }

  addShow(item: any) {
    for (const x of this.manipulateShow) {
      if (x.id === item.id) {
        this.notificationService.warning('Predstava je vec dodata !');
        return;
      }
    }
    this.manipulateShow.push(item);
    this.notificationService.success('Predstava je uspesno dodata u korpu!');
    this.sharedService.manipulateShowSubject.next(this.manipulateShow);
    localStorage.setItem(this.activeUser.id, JSON.stringify(this.manipulateShow));
  }

  removeShow(item: any) {
    const idx = this.data.findIndex((x) => x.id === item.id);

    if(this.activeUser.username !== 'admin') {
      if (idx !== -1) {
        this.data.splice(idx, 1);
        this.sharedService.manipulateShowSubject.next(this.data);
        this.notificationService.success(
          'Predstava je uspesno uklonjena iz korpe!'
        );
        this.dataSource = new MatTableDataSource(this.data)
      } else {
        this.notificationService.error('Ovu predstavu ste uklonili vec!');
        return;
      }
  
      const localReportoars = JSON.parse(localStorage.getItem(this.activeUser.id));
       
      const index = localReportoars.findIndex(data => data.id === item.id);
      
      if(index !== -1) {
            
            localStorage.setItem(this.activeUser.id, JSON.stringify(this.data));
      }
      else {
          localStorage.setItem(this.activeUser.id, JSON.stringify(this.data));
      }
    }
    else {
      this.performanceService.deletePerfomance(this.data[idx]);
      this.data.splice(idx, 1);
      this.dataSource = new MatTableDataSource(this.data)
    }
    
  }
}
