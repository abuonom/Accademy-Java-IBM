import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-send',
  templateUrl: './send.component.html',
  styleUrl: './send.component.css'
})
export class SendComponent {

	/*
	Il decorator @Output deve matchare il nome della templete reference usata
	dal template #name
	Occorre tipizzare EventMitter con il tipo dell'informazione inviata dal
	template se input type=text ->>>> string
	se input type=number ->>>> number
	*/
	@Output() name = new EventEmitter<string>();
	sendName(value:string){
		this.name.emit(value);
	}
}
