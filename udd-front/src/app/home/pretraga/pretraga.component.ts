import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SearchService } from 'src/app/services/search.service';

@Component({
  selector: 'app-pretraga',
  templateUrl: './pretraga.component.html',
  styleUrls: ['./pretraga.component.css']
})
export class PretragaComponent implements OnInit {

  constructor(
    public searchService: SearchService

  ) { }

  stepeni: String[] = ['osnovna skola','srednja skola', 'visa', 'visoka', 'fakultet', 'master', 'doktor'];
  operatori: String[] = ['And','Or', 'Not'];
  searchPending = false;
  searchForm: FormGroup = new FormGroup({
    ime: new FormControl('', [Validators.pattern(new RegExp('\\S'))]),
    prezime: new FormControl('', [Validators.pattern(new RegExp('\\S'))]),
    stepen: new FormControl('', [Validators.pattern(new RegExp('\\S'))]),
    sadrzaj: new FormControl('', [Validators.pattern(new RegExp('\\S'))]),
  });

  ngOnInit(): void {
  }

  search(){
    // vazno!!!!! promeni null
    this.searchService.search(null).subscribe(
      (res) => {
        this.searchPending = false;
        console.log(res)
      }
    );
  }
  test(){
    // vazno!!!!! promeni null
    this.searchService.test().subscribe(
      (res) => {
        this.searchPending = false;
        console.log(res)
      }
    );
  }
}
