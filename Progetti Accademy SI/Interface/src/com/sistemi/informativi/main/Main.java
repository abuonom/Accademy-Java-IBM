package com.sistemi.informativi.main;

import com.sistemi.informativi.Docente;
import com.sistemi.informativi.DocenteJava;
import com.sistemi.informativi.DocenteMicrosoft;

public class Main {

	public static void main(String[] args) {
		DocenteJava docenteJava = new DocenteJava();
		docenteJava.spiegaLinguaggio();
		docenteJava.spiegaArchitettura();
		docenteJava.spiegaFramework();
		
		DocenteMicrosoft docenteMicrosoft = new DocenteMicrosoft();
		docenteMicrosoft.spiegaLinguaggio();
		docenteMicrosoft.spiegaArchitettura();
		docenteMicrosoft.spiegaFramework();
		 
		/*
		 * E' possibile fare una reference del tipo del Padre che controlla
		 * l'oggetto di tipo figlio (POLIMORFISMO)
		 * 
		 * Il polimorfismo di oggetti vuol dire far assumere ad una reference
		 * di tipo padre la forma di uno dei suoi oggetti figlio a RUNTIME
		 * 
		 * Possono però essere invocati solo i metodi comuni tra padre e figlio
		 * eventuali nuovi metodi del figlio non possono essere usati
		 * 
		 * Nell'esempio sottostante, non possiamo infatti usare faPausa()
		 * 
		 */
		Docente docenteJavaNew = new DocenteJava();
		docenteJavaNew.spiegaArchitettura();
		docenteJava.faPausa();
		//docenteJavaNew.faPausa();
	}

}
