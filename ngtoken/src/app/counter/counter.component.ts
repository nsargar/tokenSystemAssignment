import { Component, OnInit } from '@angular/core';
import {GenerateTokenService} from '../generate-token/generate-token.service';
import {Router} from '@angular/router';
import {Token} from '../generate-token/Token.model';
import {CounterServiceService} from './counter-service.service';
import {DisplayServiceService} from '../display/display-service.service';

@Component({
  selector: 'app-counter',
  templateUrl: './counter.component.html',
  styleUrls: ['./counter.component.css']
})
export class CounterComponent implements OnInit {
  private counterNumber: string;
  private token: Token;
  private deleteToken: Token;
  constructor(private service: CounterServiceService,
              private displayService: DisplayServiceService,
              private router: Router) { this.counterNumber = '0'; }

  ngOnInit() {
  }

  getTokenforTemplate(): void {
    this.service.getToken(this.counterNumber)
      .subscribe( data => {
        this.token = data;
        /*this.displayService.tokenList.push(this.token);*/
         /*!this.displayService.tokenList.some((item) => item.window === this.token.window)) {
           this.deleteToken = this.displayService.tokenList.find(i => i.window === this.token.window);
          const index: number = this.displayService.tokenList.indexOf(this.deleteToken);
          this.displayService.tokenList.splice(index, 1 );
          this.displayService.tokenList.push(this.token);
        */

        console.log(data);
        alert('Token retrieved successfully, Token to service is ' + this.token.tokenId);
      });
  }

}
