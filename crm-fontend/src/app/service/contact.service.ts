import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Contact } from '../models/contact'; // Assuming you have a Contact model

const baseUrl = 'http://localhost:8080/api/contacts'; // Backend API URL

@Injectable({
  providedIn: 'root',
})
export class ContactService {
  constructor(private http: HttpClient) {}

  getAll(): Observable<Contact[]> {
    return this.http.get<Contact[]>(baseUrl);
  }

  get(id: any): Observable<Contact> {
    return this.http.get<Contact>(
      `<span class="math-inline">\{baseUrl\}/</span>{id}`
    );
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(
      `<span class="math-inline">\{baseUrl\}/</span>{id}`,
      data
    );
  }

  delete(id: any): Observable<any> {
    return this.http.delete(
      `<span class="math-inline">\{baseUrl\}/</span>{id}`
    );
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  findByName(name: string): Observable<Contact[]> {
    // Example search by name
    return this.http.get<Contact[]>(
      `<span class="math-inline">\{baseUrl\}?name\=</span>{name}`
    ); // Adjust if your backend search endpoint is different
  }
}
