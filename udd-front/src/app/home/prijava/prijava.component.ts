import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Request } from 'src/app/models/request';
import { RequestService } from 'src/app/services/request.service';

@Component({
  selector: 'app-prijava',
  templateUrl: './prijava.component.html',
  styleUrls: ['./prijava.component.css']
})
export class PrijavaComponent implements OnInit {
  constructor(
    public requestService: RequestService
  ) { }

  stepeni: String[] = ['osnovna skola','srednja skola', 'visa', 'visoka', 'fakultet', 'master', 'doktor'];

  fileName: String = '';
  fileName2: String = '';

  file1: File;
  file2: File;

  formData = new FormData();

  requestPending = false;
  requestForm: FormGroup = new FormGroup({
    ime: new FormControl('', [Validators.required,
    Validators.pattern(new RegExp('\\S'))]),
    prezime: new FormControl('', [Validators.required,
    Validators.pattern(new RegExp('\\S'))]),
    stepen: new FormControl('', [Validators.required,
    Validators.pattern(new RegExp('\\S'))]),

  });

  onFileSelected(event) {

    const file:File = event.target.files[0];

    if (file) {
        this.fileName = file.name;
        this.file1 = file
        //const upload$ = this.http.post("/api/thumbnail-upload", formData);
        //upload$.subscribe();
    }
  }

  onFile2Selected(event) {

    const file:File = event.target.files[0];

    if (file) {
        this.fileName2 = file.name;
        this.file2 = file;
    }
  }

  request(){
    const formData: FormData = new FormData();
    
    formData.append('file1', this.file1);
    formData.append('file2', this.file2);
    const r: Request = {
      ime: 'My Category',
      prezime: 'My Description',
      stepen: 'moj stepen'
    };

    formData.append('user', new Blob([JSON
      .stringify(r)], {
      type: 'application/json'
    }));

    this.requestService.request(formData).subscribe(
      (res) => {
        this.requestPending = false;
        console.log(res)
      }
    );
  }

  
  ngOnInit(): void {
  }

}
