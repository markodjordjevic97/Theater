import { SharedService } from 'src/app/shared/services/shared.service';
import { Component, OnInit } from '@angular/core';
import { NotificationService } from 'src/app/shared/services/notification.service';
@Component({
  selector: 'app-tickets',
  templateUrl: './tickets.component.html',
  styleUrls: ['./tickets.component.scss'],
})
export class TicketsComponent implements OnInit {
  tickets: any;

  filterPlaceholder: string = 'Pretrazite predstave';

  activeUser = JSON.parse(localStorage.getItem('USER_DATA'))
  activeTickets?: any = JSON.parse(localStorage.getItem(this.activeUser.id));

  constructor(private sharedService: SharedService, private notificationService: NotificationService) {}

  ngOnInit() {
    
    this.sharedService.manipulateShowSubject.subscribe(data => {
      this.tickets = data;
    })
    
    if(this.activeTickets?.length > 0) {
      this.tickets = this.activeTickets;
    }
    else {
      this.tickets = []
    }
  }

  buyTicekts() {
    this.notificationService.success('Uspesno ste kupili karte. Vidimo se :)')
    this.tickets = []
    this.sharedService.manipulateShowSubject.next(this.tickets)
    localStorage.removeItem(this.activeUser.id)
  }
}
