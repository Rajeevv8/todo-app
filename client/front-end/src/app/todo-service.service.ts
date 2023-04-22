import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Todo } from './todo';

@Injectable({
  providedIn: 'root'
})
export class TodoServiceService {

  private postUrl="http://localhost:8080/create";
  private getUrl="http://localhost:8080/retrieve";
  private deleteUrl="http://localhost:8080/delete";
  private putUrl="http://localhost:8080/update";
  private getTaskByEntryUrl = "http://localhost:8080/getTaskByEntryNumber";
  constructor(private http:HttpClient) { 

  }
  retrieveTodo():Observable<Todo[]>{
    return this.http.get<Todo[]>(
      `${this.getUrl}`
    )
  }
  createTodo(todo:Todo):Observable<Object>{
    return this.http.post(
      `${this.postUrl}`,todo
    )
}
  updateTodo(entryNumber:number,todo:Todo):Observable<Object>{
    return this.http.put(
      `${this.putUrl}/${entryNumber}`,todo
    )
  }
  deleteTodo(entryNumber:number):Observable<Object>{
    return this.http.delete(
      `${this.deleteUrl}/${entryNumber}`
    )
  }
  getTaskByEntryNumber(entryNumber:number):Observable<Todo>{
    return this.http.get<Todo>(
      `${this.getTaskByEntryUrl}/${entryNumber}`
    )
  }
}
