# How to test from postman.
Request Type : POST
URL : http://localhost:8090/rest/student
Input : Body-->Raw-->Text or Json

Input1:
{
	student(id:1002){
		id
		name
		course
		subjects
	}
}

Ouput1:
{
    "data": {
        "student": {
            "id": 1002,
            "name": "Manish Pandey",
            "course": "BCA",
            "subjects": [
                "OS",
                "JAVA"
            ]
        }
    },
    "errors": [],
    "dataPresent": true,
    "extensions": null
}

Input2:
{
	student(id:1002){
		id
		name
	}
}

Output2:
{
    "data": {
        "student": {
            "id": 1002,
            "name": "Manish Pandey"
        }
    },
    "errors": [],
    "dataPresent": true,
    "extensions": null
}

Input3:
{
    "data": {
        "student": {
            "id": 1002,
            "name": "Manish Pandey"
        }
    },
    "errors": [],
    "dataPresent": true,
    "extensions": null
}

Output3:
{
    "data": {
        "students": [
            {
                "id": 1001,
                "name": "Rohan Shinde"
            },
            {
                "id": 1002,
                "name": "Manish Pandey"
            },
            {
                "id": 1003,
                "name": "Rakshit Patel"
            },
            {
                "id": 1004,
                "name": "Ritu Chaudhary"
            },
            {
                "id": 1005,
                "name": "Anamika Shukla"
            }
        ]
    },
    "errors": [],
    "dataPresent": true,
    "extensions": null
}

Input4:
{
	students{
		id
		name
		course
		subjects
	}
}

Output4:
{
    "data": {
        "students": [
            {
                "id": 1001,
                "name": "Rohan Shinde",
                "course": "BCA",
                "subjects": [
                    "DBMS",
                    "JAVA"
                ]
            },
            {
                "id": 1002,
                "name": "Manish Pandey",
                "course": "BCA",
                "subjects": [
                    "OS",
                    "JAVA"
                ]
            },
            {
                "id": 1003,
                "name": "Rakshit Patel",
                "course": "BCA",
                "subjects": [
                    "DBMS",
                    "DOT NET"
                ]
            },
            {
                "id": 1004,
                "name": "Ritu Chaudhary",
                "course": "BCA",
                "subjects": [
                    "DAA",
                    "CBOT"
                ]
            },
            {
                "id": 1005,
                "name": "Anamika Shukla",
                "course": "BCA",
                "subjects": [
                    "CN",
                    "DE"
                ]
            }
        ]
    },
    "errors": [],
    "dataPresent": true,
    "extensions": null
}

Input5:
{
	students{
		id
		name
		course
		subjects
	}
	student(id:1004){
		id
		name
	}
}

Output5:
{
    "data": {
        "students": [
            {
                "id": 1001,
                "name": "Rohan Shinde",
                "course": "BCA",
                "subjects": [
                    "DBMS",
                    "JAVA"
                ]
            },
            {
                "id": 1002,
                "name": "Manish Pandey",
                "course": "BCA",
                "subjects": [
                    "OS",
                    "JAVA"
                ]
            },
            {
                "id": 1003,
                "name": "Rakshit Patel",
                "course": "BCA",
                "subjects": [
                    "DBMS",
                    "DOT NET"
                ]
            },
            {
                "id": 1004,
                "name": "Ritu Chaudhary",
                "course": "BCA",
                "subjects": [
                    "DAA",
                    "CBOT"
                ]
            },
            {
                "id": 1005,
                "name": "Anamika Shukla",
                "course": "BCA",
                "subjects": [
                    "CN",
                    "DE"
                ]
            }
        ],
        "student": {
            "id": 1004,
            "name": "Ritu Chaudhary"
        }
    },
    "errors": [],
    "dataPresent": true,
    "extensions": null
}
