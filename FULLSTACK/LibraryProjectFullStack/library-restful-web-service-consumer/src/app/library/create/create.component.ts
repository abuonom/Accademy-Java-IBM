import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { library_service_token, LibraryServiceI } from '../libraryI.service';
import { LibraryService } from '../library.service';
import { Book } from '../module/Book.module';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create',
  standalone: true,
  providers: [{ provide: library_service_token, useClass: LibraryService }],
  imports: [CommonModule,ReactiveFormsModule],
  templateUrl: './create.component.html',
  styleUrl: './create.component.css'
})
export class CreateComponent implements OnInit {

	books! : Book;
	private libraryService = inject<LibraryServiceI>(library_service_token);
	private router: Router = new Router;
	form!: FormGroup;

  ngOnInit(): void {
	this.form = new FormGroup({
		isbn: new FormControl(''),
		title: new FormControl(''),
		genre: new FormControl(''),
		publisher: new FormControl(false),
	});
}

submit() {
	this.libraryService.createBook(this.form.value).subscribe((res: any) => {
		console.log('Book created successfully!');
		this.router.navigateByUrl('/library/index');
})
}



}
