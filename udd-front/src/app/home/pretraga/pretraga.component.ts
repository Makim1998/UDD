import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SearchService } from 'src/app/services/search.service';
import { SearchItem } from 'src/app/models/searchItem'
import { SearchItems } from 'src/app/models/searchItems'
import { SearchResult } from 'src/app/models/searchResult';
import { MatTable } from '@angular/material/table';

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
  rezultati: SearchResult[] = [];
  displayedColumns: string[] = ['datum', 'ime', 'prezime', 'stepen','sazetak'];
  @ViewChild(MatTable) table: MatTable<any>;

  searchPending = false;
  searchForm: FormGroup = new FormGroup({
    ime: new FormControl('', [Validators.pattern(new RegExp('\\S'))]),
    prezime: new FormControl('', [Validators.pattern(new RegExp('\\S'))]),
    stepen: new FormControl('', [Validators.pattern(new RegExp('\\S'))]),
    sadrzaj: new FormControl('', [Validators.pattern(new RegExp('\\S'))]),
    operator1: new FormControl('', [Validators.pattern(new RegExp('\\S'))]),
    operator2: new FormControl('', [Validators.pattern(new RegExp('\\S'))]),
    operator3: new FormControl('', [Validators.pattern(new RegExp('\\S'))]),
  });

  ngOnInit(): void {
  }

  search(){
    let items: SearchItem[] = [];
    const item1: SearchItem = {
      operand: this.searchForm.get('operator1').value,
      field: 'ime',
      value: this.searchForm.get('ime').value
    };
    const item2: SearchItem = {
      operand: this.searchForm.get('operator2').value,
      field: 'prezime',
      value: this.searchForm.get('prezime').value
    };
    const item3: SearchItem = {
      operand: this.searchForm.get('operator3').value,
      field: 'stepen',
      value: this.searchForm.get('stepen').value
    };
    const item4: SearchItem = {
      operand: 'And',
      field: 'text',
      value: this.searchForm.get('sadrzaj').value
    };
    items.push(item1);
    items.push(item2);
    items.push(item3);
    items.push(item4);

    const allItems: SearchItems = {
      items: items,
    };
    this.searchService.search(allItems).subscribe(
      (res) => {
        this.searchPending = false;
        console.log(res);
        this.rezultati = res;
        this.table.renderRows();
      }
    );
  }



  test(){
    // vazno!!!!! promeni null
    this.searchService.test().subscribe(
      (res) => {
        this.searchPending = false;
        console.log(res);
      }
    );
  }
}
