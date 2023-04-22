import { Component,OnInit } from '@angular/core';
import { TodoServiceService } from '../todo-service.service';
import { Todo } from '../todo';
import { Router } from '@angular/router';

@Component({
  selector: 'app-todo-home',
  templateUrl: './todo-home.component.html',
  styleUrls: ['./todo-home.component.css']
})
export class TodoHomeComponent implements OnInit{
  todo:Todo=new Todo();
  constructor(private todoService:TodoServiceService,private router:Router){

  }
  ngOnInit():void{

  }

  createTodo(){
    this.todoService.createTodo(this.todo).subscribe(data=>{ 
      this.router.navigate(['/list'])
     })
  }

  onSubmit(){
    this.createTodo();
  }

}
