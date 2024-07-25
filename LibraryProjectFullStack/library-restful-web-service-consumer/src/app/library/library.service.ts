import { Injectable } from '@angular/core';
import { LibraryServiceI } from './libraryI.service';
import { catchError, Observable, throwError } from 'rxjs';
import { Book } from './module/Book.module';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LibraryService implements LibraryServiceI{

	private apiU = 'http://localhost:8080/rest/api/library';

	httpOptions = {
		headers: new HttpHeaders({
			'Content-Type': 'application/json'
		})
	}

  constructor(private httpClient: HttpClient) { }

	getBooks(): Observable<any> {
		return this.httpClient.get(this.apiU)
		.pipe(
			catchError(this.errorHandler)
		)
	}

	getBookByIsbn(isbn: string): Observable<any> {
		return this.httpClient.get(this.apiU + '/isbn/' + isbn)
		.pipe(
			catchError(this.errorHandler)
		)
	}

	createBook(book: Book): Observable<any> {
		return this.httpClient.post(this.apiU, JSON.stringify(book), this.httpOptions)
		.pipe(
			catchError(this.errorHandler)
		)
	}
	updateBook(book: Book): Observable<any> {
		return this.httpClient.put(this.apiU, JSON.stringify(book), this.httpOptions)
		.pipe(
			catchError(this.errorHandler)
		)
	}
	deleteBook(isbn: string): Observable<any> {
		return this.httpClient.delete(this.apiU + '/isbn/' + isbn)
		.pipe(
			catchError(this.errorHandler)
		)
	}

	errorHandler(error: any) {
		let errorMessage = '';
		if(error.error instanceof ErrorEvent) {
			errorMessage = error.error.message;
		} else {
			errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
		}
		return throwError(()=>new Error(errorMessage));
		}
}
