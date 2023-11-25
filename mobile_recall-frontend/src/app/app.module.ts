import {LOCALE_ID, NgModule} from '@angular/core';
import {NgOptimizedImage, registerLocaleData} from '@angular/common';
import * as de from '@angular/common/locales/de';

import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserModule} from '@angular/platform-browser';

import {CardModule} from "primeng/card";
import {ButtonModule} from "primeng/button";
import {InputTextareaModule} from "primeng/inputtextarea";
import {DataViewModule} from "primeng/dataview";
import {KnobModule} from "primeng/knob";
import {MenuModule} from "primeng/menu";
import {BadgeModule} from "primeng/badge";
import {TableModule} from "primeng/table";
import {MenubarModule} from "primeng/menubar";
import {ToolbarModule} from "primeng/toolbar";
import {TagModule} from "primeng/tag";

import {AppRoutingModule} from './routing/app-routing.module';
import {AppComponent} from './app.component';

import {MainContainerComponent} from './components/main-container/main-container.component';
import {CardComponent} from './components/card/card.component';
import {LearnViewComponent} from './components/learn-view/learn-view.component';
import {MessagesModule} from "primeng/messages";
import {InputTextModule} from "primeng/inputtext";
import {DialogModule} from "primeng/dialog";
import {CreationFormCardGroupComponent} from "./dialog-forms/creation-form-cardgroup/creation-form-cardgroup.component";
import { NavigationBarComponent } from './components/navigation-bar/navigation-bar.component';


@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    MainContainerComponent,
    LearnViewComponent,
    CreationFormCardGroupComponent,
    NavigationBarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CardModule,
    BrowserAnimationsModule,
    ButtonModule,
    NgOptimizedImage,
    HttpClientModule,
    InputTextareaModule,
    DataViewModule,
    KnobModule,
    FormsModule,
    MenuModule,
    BadgeModule,
    TableModule,
    MenubarModule,
    MenubarModule,
    ToolbarModule,
    TagModule,
    MessagesModule,
    InputTextModule,
    DialogModule,
    ReactiveFormsModule
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'de-DE'}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
    registerLocaleData(de.default);
  }
}
