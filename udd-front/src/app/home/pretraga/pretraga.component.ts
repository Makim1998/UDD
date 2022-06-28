import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-pretraga',
  templateUrl: './pretraga.component.html',
  styleUrls: ['./pretraga.component.css']
})
export class PretragaComponent implements OnInit {

  constructor() { }

  stepeni: String[] = ['osnovna skola','srednja skola', 'visa', 'visoka', 'fakultet', 'master', 'doktor'];

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

  }
}
