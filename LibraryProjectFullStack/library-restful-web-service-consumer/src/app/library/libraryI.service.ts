import { InjectionToken } from "@angular/core";
import { Observable } from "rxjs";
import { Book } from "./module/Book.module";

export const library_service_token = new
InjectionToken<LibraryServiceI>('library_service_token');

export interface LibraryServiceI {
	getBooks(): Observable<any>;
	getBookByIsbn(isbn: string): Observable<any>;
	createBook(book: Book): Observable<any>;
	updateBook(book: Book): Observable<any>;
	deleteBook(isbn: string): Observable<any>;
}
