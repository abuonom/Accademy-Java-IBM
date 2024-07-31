import { Routes } from '@angular/router';
import { IndexComponent } from './module/academy/index/index.component';
import { CreateComponent } from './module/academy/create/create.component';
import { EditComponent } from './module/academy/edit/edit.component';

/*
all'interno dell'Array routes
è possibile impostare le rotte di navigazione
dell'applicazione  e corrispondenti Component
che Node.js dovrà caricare per ogni rotta

/*
path: 'academy/index', component: IndexComponent --->>>
Node.js comprende che se la rotta di navigazione è http://localhost:4200/academy/index
deve caricare la component IndexComponent

path: 'academy/create', component: CreateComponet --->>>
Node.js comprende che se la rotta di navigazione è http://localhost:4200/academy/create
deve caricare la component CreateComponent

path: 'academy/edit', component: EditComponent --->>>
Node.js comprende che se la rotta di navigazione è http://localhost:4200/academy/edit
deve caricare la component CreateComponent

path: 'academy', redirectTo: 'academy/index', pathMatch: 'full'},
Node.js comprende che se la rotta di navigazioe è http://localhost:4200/academy
deve caricare la IndexComponnet

*/


export const routes: Routes = [
    { path: 'academy', redirectTo: 'academy/index', pathMatch: 'full'},
    { path: 'academy/index', component: IndexComponent },
    { path: 'academy/create', component: CreateComponent },
    { path: 'academy/:code/edit', component: EditComponent } 
];

