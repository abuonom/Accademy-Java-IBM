import { Component, inject, OnInit } from '@angular/core';
import { library_service_token } from '../libraryI.service';
import { LibraryService } from '../library.service';
import { CommonModule } from '@angular/common';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Book } from '../module/Book.module';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit',
  standalone: true,
  providers: [{provide: library_service_token, useClass: LibraryService}
  ],
  imports: [CommonModule,ReactiveFormsModule],
  templateUrl: './edit.component.html',
  styleUrl: './edit.component.css'
})
export class EditComponent implements OnInit{
	private libraryService = inject<LibraryService>(library_service_token);

	book!: Book;
	isbn!: string;
	form!: FormGroup;

	constructor(private route: ActivatedRoute, private router: Router){

	}

	ngOnInit(): void {
		this.isbn = this.route.snapshot.params['isbn'];
		this.libraryService.getBookByIsbn(this.isbn).subscribe((data) => {
			this.book = data;
			console.log(this.book);
		});

		this.form = new FormGroup({
			isbn: new FormControl(''),
			title: new FormControl(''),
			genre: new FormControl(''),
			published: new FormControl(false)
		});
	}

	submit(){
		this.libraryService.updateBook(this.form.value).subscribe((res : any) => {
			console.log('Book updated successfully!');
			this.router.navigateByUrl('/library/index');
	})
}
}
