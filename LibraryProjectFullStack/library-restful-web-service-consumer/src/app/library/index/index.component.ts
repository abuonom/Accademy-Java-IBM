import { Component, inject, OnInit } from '@angular/core';
import { Book } from '../module/Book.module';
import { library_service_token, LibraryServiceI } from '../libraryI.service';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LibraryService } from '../library.service';

@Component({
	selector: 'app-index',
	standalone: true,
	providers: [{ provide: library_service_token, useClass: LibraryService }],
	imports: [CommonModule, RouterModule],
	templateUrl: './index.component.html',
	styleUrl: './index.component.css'
})
export class IndexComponent implements OnInit {

	books: Book[] = [];
	private libraryService = inject<LibraryServiceI>(library_service_token);
	constructor() { }

	ngOnInit(): void {
		this.getBooks();
	}

	getBooks(): void {
		this.libraryService.getBooks().subscribe({
			next: (res) => {
				this.books = res;
				console.log('Data fetched succesfully', res);
			},
			error: (err) => {
				console.error('Error fetching data', err);
			}
		});
	}

	removeBook(isbn: string): void {
		this.libraryService.deleteBook(isbn).subscribe({
			next: (res) => {
				console.log('Book deleted', res);
				this.getBooks();
			},
			error: (err) => {
				console.error('Error deleting book', err);
			}
		});

	}
}
