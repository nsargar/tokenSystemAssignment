import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {GenerateTokenService} from './generate-token/generate-token.service';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {GenerateTokenComponent} from './generate-token/generate-token.component';
import { DisplayComponent } from './display/display.component';
import { CounterComponent } from './counter/counter.component';

@NgModule({
  declarations: [
    AppComponent,
    GenerateTokenComponent,
    DisplayComponent,
    CounterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [GenerateTokenService],
  bootstrap: [AppComponent]
})
export class AppModule { }
