import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainContainerComponent} from "../components/main-container/main-container.component";
import {LearnViewComponent} from "../components/learn-view/learn-view.component";

const routes: Routes = [
  {path: '', component: MainContainerComponent},
  {path: 'learnView/:groupName', component: LearnViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
