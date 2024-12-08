
use MyMongoDB
db.dropDatabase()
db.info.drop()

	db.master.insertMany([
		{ name: "Paul", age: 55 ,sex:"male",location: "Seoul"},
		{ name: "Johan", age: 20,sex:"male" ,location: "Tokyo"},
		{ name: "Mikey", age: 24,sex:"female" ,location: "London"},
		{ name: "Lee", age: 30,sex:"female",location: "LA" }
	])

	db.info.insertMany([
		{ name: "Paul", job: "woker" },
		{ name: "Johan",  job: "woker" },
		{ name: "Mikey", job: "Student" },
		{ name: "Lee", job: "worker" }
	])
