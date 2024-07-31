import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Academy } from '../../model/academy.model';
import { AcademyServiceI } from '../academyI.service';

@Injectable({
  providedIn: 'root'
})
export class AcademyService implements AcademyServiceI{

  private apiURL = "http://localhost:8080/rest/api/academies"

  /*
  Tramite httpOptions specifichiamo
  il formato dati utilizzato per lo
  scambio di informazioni con il 
  Web Service Provider : JSON
  */
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  /*
  HttpClient è una API fornita da Angular
  E' un Service che si può iniettare tramite
  costruttore in un altro Service
  La funzione di HttpClient è quella di effettuare
  chiamate REST tramite metodi get, post, put, delete
  */

  constructor(private httpClient: HttpClient) { }

  getAcademies(): Observable<any> {
  
    /*
    chiamata rest GET "http://localhost:8080/rest/api/academies"
    Tutti i metodi di HttpClient (compreso il metodo get)
    restituiscono un Observable
    Observable è una API asincrona (rxjs) in grado di mappare JSON 
    in Oggetti Typescript e può trovarsi in tre stati differenti :
    NEXT---->>> LA CHIAMATA AD UN SERVIZIO REST E' STATA EFFETTUATA MA ANCORA NON TERMINATA
    COMPLETED--->>> LA CHIAMATA AL SERVIZIO REST E' STATA EFFETTUATA CON SUCCESSO
    ERROR--->>> LA CHIAMATA AL SERVIZO REST HA RESTITUITO UNA ECCEZIONE

    NB: Observale non è una API nativa Angular, ma è una API fornita dalla libreria
    rxjs utilizzabile da tutte le tecnologie Front End (React,javascript,Typescript)

    */
    
    return this.httpClient.get(this.apiURL)
  
    /*
    pipe è una funzione Typescript corrispondente allo
    stato error di un Observable: se l'Observable non
    completa catcha una eccezione 
    */
    .pipe(
      catchError(this.errorHandler)
    )
  }


  /*
    chiamata rest 
    GET "http://localhost:8080/rest/api/academies/code/{code}"
  */
  getAcademyByCode(code:string):Observable<any>{

    return this.httpClient.get(this.apiURL + '/code/' + code).
    
    pipe(
      catchError(this.errorHandler)
    )

  }

  /*
    chiamata rest 
    POST "http://localhost:8080/rest/api/academies"
  */
  saveAcademy(academy:Academy):Observable<any>{

    return this.httpClient.post(this.apiURL,JSON.stringify(academy),this.httpOptions).
    
    pipe(
      catchError(this.errorHandler)
    )
    
  }

  /*
    chiamata rest 
    PUT "http://localhost:8080/rest/api/academies"
  */
    updateAcademy(academy:Academy):Observable<any>{

      return this.httpClient.put(this.apiURL,JSON.stringify(academy),this.httpOptions).
      
      pipe(
        catchError(this.errorHandler)
      )
      
    }

  /*
    chiamata rest DELETE "http://localhost:8080/rest/api/academies/code/{code}"
  */
  removeAcademy(code:string):Observable<any>{

    return this.httpClient.delete(this.apiURL + '/code/' + code).
    
    pipe(
      catchError(this.errorHandler)
    )

  }



  /*
  metodo che serve a gestire eventuali eccezioni
  derivanti da errori relativi alle chiamate REST 
  */
  errorHandler(exception: any) {

    let errorMessage = '';

    if (exception.error instanceof ErrorEvent) {
      errorMessage = exception.error.message;
    } else {
      errorMessage = `Error Code: ${exception.status}\nMessage: ${exception.message}`;
    }
    return throwError(() => new Error(errorMessage));
  }





}
