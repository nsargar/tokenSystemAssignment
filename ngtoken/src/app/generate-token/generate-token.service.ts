import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Token} from './Token.model';

@Injectable({
  providedIn: 'root'
})
export class GenerateTokenService {

  constructor(private http: HttpClient) { }
  private userUrl = '/api';

  public generateToken(customerNumber: string) {
    return this.http.post<Token>(this.userUrl + '/generate', customerNumber);

  }


}
