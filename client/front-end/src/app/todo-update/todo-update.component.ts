import { Component, OnInit } from '@angular/core';
import { TodoServiceService } from '../todo-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Todo } from '../todo';

@Component({
  selector: 'app-todo-update',
  templateUrl: './todo-update.component.html',
  styleUrls: ['./todo-update.component.css']
})
export class TodoUpdateComponent implements OnInit{
  entryNumber:number;
  todo=new Todo();
  constructor(private service:TodoServiceService,private router:Router,private route:ActivatedRoute){
  }
  ngOnInit(): void {
    this.entryNumber=this.route.snapshot.params['entryNumber'];
    this.service.getTaskByEntryNumber(this.entryNumber).subscribe(data=>{
      this.todo=data
    })
  }
  onSubmit(){
    this.service.updateTodo(this.entryNumber,this.todo).subscribe(data=>{
      console.log("Updated ",data)
      this.router.navigate(['/list'])
    })
  }

}
