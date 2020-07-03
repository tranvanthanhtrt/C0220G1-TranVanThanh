import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionaries= [
    { eng: 'hello', meaning: 'Xin chào' },
    { eng: 'school', meaning: 'Trường học' },
    { eng: 'dog', meaning: 'Chó' },
    { eng: 'game', meaning: 'Trò chơi' }
  ];

  constructor() {
  }

  find(eng: string) {
    return this.dictionaries.find(item => item.eng === eng)
  }
}
