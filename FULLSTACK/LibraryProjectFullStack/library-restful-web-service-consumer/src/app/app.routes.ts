import { Routes } from '@angular/router';
import { IndexComponent } from './library/index/index.component';
import { CreateComponent } from './library/create/create.component';
import { EditComponent } from './library/edit/edit.component';

export const routes: Routes = [
	{ path: 'library', redirectTo: 'library/index', pathMatch:'full'},
	{ path: 'library/index', component: IndexComponent},
	{ path: 'library/create', component: CreateComponent},
	{ path: 'library/:isbn/edit', component: EditComponent},
];
