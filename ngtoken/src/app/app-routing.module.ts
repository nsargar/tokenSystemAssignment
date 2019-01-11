import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {GenerateTokenComponent} from './generate-token/generate-token.component';
import {CounterComponent} from './counter/counter.component';
import {DisplayComponent} from './display/display.component';


const routes: Routes = [{path: 'generatetoken', component : GenerateTokenComponent},
                        {path: 'counter', component: CounterComponent},
                        {path: 'display', component: DisplayComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
