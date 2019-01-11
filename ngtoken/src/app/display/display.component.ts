import { Component, OnInit } from '@angular/core';
import {Token} from '../generate-token/Token.model';
import {DisplayServiceService} from './display-service.service';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {


  private tokenList: Token[];
  constructor(private service: DisplayServiceService) { }
  ngOnInit() {
    this.tokenList= this.service.tokenList;
  }
}
