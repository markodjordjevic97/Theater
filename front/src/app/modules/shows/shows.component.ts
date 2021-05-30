import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { PerformancesService } from 'src/app/shared/services/performances.service';

@Component({
  selector: 'app-shows',
  templateUrl: './shows.component.html',
  styleUrls: ['./shows.component.scss'],
})
export class ShowsComponent implements OnInit {
  shows: any = [];
  filterPlaceholder: string = 'Pretrazite predstave';

  constructor(private performancesService: PerformancesService) {
  
  }

  ngOnInit(): void {
    this.performancesService.getPerformances().subscribe(data => {
      for(const item of data) {
        let premmaped = Object.assign(item);
        this.shows.push({
          id: +premmaped.id,
          title: premmaped.title,
          duration: premmaped.duration,
          description: premmaped.description,
          writer: premmaped.writer.name + " " + premmaped.writer.surname,
          type: premmaped.type.type,
          price: Math.floor(Math.random() * 10 * 200 + 300)
        })
      }
   });
  }
}
