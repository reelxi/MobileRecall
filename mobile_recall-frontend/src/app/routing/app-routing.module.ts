import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LearnViewComponent} from "../components/learn-view/learn-view.component";
import {CardGroupListComponent} from "../components/cardgroup-list/cardgroup-list.component";

const routes: Routes = [
  {path: '', component: CardGroupListComponent},
  {path: 'learnView/:groupName', component: LearnViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
