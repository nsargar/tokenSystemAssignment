import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Token} from '../generate-token/Token.model';

@Injectable({
  providedIn: 'root'
})
export class CounterServiceService {
  constructor(private http: HttpClient) { }
  private userUrl = '/api';

  public getToken(counterNumber: string) {
    return this.http.get<Token>(this.userUrl + '/gettoken/' + counterNumber);

  }}
