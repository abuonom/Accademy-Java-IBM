import { Component, inject, model, OnInit } from '@angular/core';
import { academy_service_token, AcademyServiceI } from '../../academyI.service';
import { AcademyService } from '../academy.service';
import { Academy } from '../../../model/academy.model';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MatTableModule } from '@angular/material/table';
import { MatIcon } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule, MatMenuTrigger } from '@angular/material/menu';
import { MAT_DIALOG_DATA, MatDialog, MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { ChangeDetectionStrategy, viewChild } from '@angular/core';

@Component({
	selector: 'app-index',
	standalone: true,
	providers: [{ provide: academy_service_token, useClass: AcademyService }],
	imports: [CommonModule, RouterModule, MatTableModule, MatIcon, MatButtonModule, MatMenuModule, MatDialogModule, MatMenuTrigger],
	templateUrl: './index.component.html',
	styleUrl: './index.component.css'
})
export class IndexComponent implements OnInit {

	readonly menuTrigger = viewChild.required(MatMenuTrigger);
	readonly dialog = inject(MatDialog);

	academies: Academy[] = [];
	columnsToDisplay = ['code', 'title', 'cityLocation', 'studentsNumber', 'actions'];

	private academyService = inject<AcademyServiceI>(academy_service_token);

	getAcademies(): void {
		this.academyService.getAcademies().subscribe({
			next: (res) => {
				this.academies = res;
				console.log('Data fetched successfully', res);
			},
			error: (err) => {
				console.error('Error fetching data', err);
			}
		});
	}

	openDialog(academy: Academy): void {
		const dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
			data: academy
		});

		dialogRef.afterClosed().subscribe(result => {
			if (result === true) {
				this.removeAcademy(academy.code);
			}
		});
	}

	removeAcademy(code: string): void {
		this.academyService.removeAcademy(code).subscribe(res => {
			console.log(res.data);
			this.getAcademies();
		});
	}

	ngOnInit(): void {
		this.getAcademies();
	}
}

@Component({
	selector: 'delete-dialog',
	templateUrl: './delete-dialog.html',
	standalone: true,
	imports: [MatDialogModule,MatButtonModule],
})
export class DialogOverviewExampleDialog {
	readonly dialogRef = inject(MatDialogRef<DialogOverviewExampleDialog>);
	readonly data = inject<Academy>(MAT_DIALOG_DATA);

	onNoClick(): void {
		this.dialogRef.close(false);
	}

	onYesClick(): void {
		this.dialogRef.close(true);
	}
}
