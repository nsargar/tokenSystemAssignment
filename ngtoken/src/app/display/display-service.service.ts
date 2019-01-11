import { Injectable } from '@angular/core';
import {Token} from '../generate-token/Token.model';

@Injectable({
  providedIn: 'root'
})
export class DisplayServiceService {

  public tokenList: Token[];
  constructor() { }
}
