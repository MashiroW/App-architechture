import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService 
{
  private getByIdUrl = "http://localhost:8081/api/v1/users/get"
  private listUrl = "http://localhost:8081/api/v1/users/list"
  private addUrl = "http://localhost:8081/api/v1/users/add"
  private deleteUrl = "http://localhost:8081/api/v1/users/delete"
  private loginUrl = "http://localhost:8081/api/v1/users/login"
  private updateUrl = "http://localhost:8081/api/v1/users/edit"
 



  constructor(private httpClient: HttpClient) { }

  updateUser(id: number | undefined, user: User): Observable<Object>{
    return this.httpClient.post(`${this.updateUrl}/${id}`, user);
  }

  getUsersList(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.listUrl}`);
  }

  createUser(user: User): Observable<Object>{
    return this.httpClient.post(`${this.addUrl}`, user);
  }

  getUserById(id: number | undefined): Observable<User>{
    return this.httpClient.get<User>(`${this.getByIdUrl}/${id}`);
  }

  loginUser(user: User): Observable<Object>{
    return this.httpClient.post(`${this.loginUrl}`, user)
  }

  deleteUser(id: number | undefined): Observable<Object>{
    return this.httpClient.delete(`${this.deleteUrl}/${id}`)
  }


}
