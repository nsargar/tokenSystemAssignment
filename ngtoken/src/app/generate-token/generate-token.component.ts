import { Component, OnInit } from '@angular/core';
import {Token} from './Token.model';
import {GenerateTokenService} from './generate-token.service';
import {Router, RouterModule} from '@angular/router';

@Component({
  selector: 'app-generate-token',
  templateUrl: './generate-token.component.html',
  styleUrls: ['./generate-token.component.css']
})
export class GenerateTokenComponent implements OnInit {

  private customerNumber: string;
  private token: Token;
  constructor(private service: GenerateTokenService, private router: Router) { this.customerNumber = ''; }

  ngOnInit() {
  }

  generateToken(): void {
    this.service.generateToken(this.customerNumber)
      .subscribe( data => {
        console.log(data);
        alert('Token generated successfully, Your Token number is ' + data.tokenId);
      });
  }

}
