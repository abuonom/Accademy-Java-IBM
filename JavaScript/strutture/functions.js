function arrayBuild1() {
  var courses = ["Java SE","Angular"];
  courses.push("React","Spark");
  courses.forEach(course=>console.log(course));
}

function arrayBuild2() {
  var letters = new Array();
  letters[0] = "A";
  letters[1] = "B";
  letters[2] = "C";
  letters.forEach(course=>console.log(course));
}

function arrayMap(){
	var numbers = [1, 2,3,4];
	/*
	L'operatore funzionale map può essere utilizzato in due vesti differenti
	- come un forEach
	- come operatore di trasformazione per ottenere un array con elementi diversi
		rispetto a quelli di partenza
	*/
	numbers = numbers.map(number=>number*2);
	numbers.forEach(number=>console.log(number));
}

