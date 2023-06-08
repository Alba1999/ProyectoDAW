import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ModeService {

  isDarkMode : boolean = false;

  toggleMode(): void {
    this.isDarkMode = !this.isDarkMode;
  }
}
