import { Component,OnInit } from '@angular/core';
import { Todo } from '../todo';
import { TodoServiceService } from '../todo-service.service';
import { Router } from '@angular/router';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
  todos:Todo[];

  constructor(private service:TodoServiceService,private router:Router){

  }
  ngOnInit(): void {
    this.getAllTodo();
  }
  private getAllTodo(){
    this.service.retrieveTodo().subscribe(data=> {
      this.todos=data
    } )
  }
  updateTodo(entryNumber:number){
    this.router.navigate(['update',entryNumber])
  }
  deleteTodo(entryNumber:number){
    this.service.deleteTodo(entryNumber).subscribe(data=>{
      console.log("Deleted ",data)
      this.getAllTodo();
    });
  }

  dateFormat(date : string) : any{
    if (date==null){
      return 'N/A'
    } else {
      return formatDate(date, 'yyyy-mm-dd', 'en-US');
    }
  }
}
