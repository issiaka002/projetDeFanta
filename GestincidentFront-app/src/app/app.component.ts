import { Component,OnInit, AfterContentChecked, ChangeDetectorRef  } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterContentChecked {
  title = 'frontend01';
  public routeTitle:string = ""
  public routeDescription:string = ""
  protected errorMsg = ""
  protected infoMsg = ""

  constructor(
    protected changeDetector: ChangeDetectorRef,
    )  {
  }
  ngOnInit(): void {
  }
  ngAfterContentChecked() : void {
      this.changeDetector.detectChanges();
  }



  showError(msg:string) {
    this.errorMsg = msg
    if(this.errorMsg != "") {
      setTimeout(() => {
        this.errorMsg = ""
      }, 10000)
    }
  }
  showInfo(msg:string) {
    this.infoMsg = msg
    if(this.infoMsg != "") {
      setTimeout(() => {
        this.infoMsg = ""
      }, 5000)
    }
  }


}
