Project name: "Healthcare".

Enteties are main classes with variables that we will store  and retrieve from database. 
In our project we have 3 entities : Doctor, Patient, and Appointment.

Interface Repository are interface that we used in order to override our construct. 
There are three Interfaces: IAppoinmentRepository, IDoctorRepository, IPatientRepository

Repository is class that has method with commands for our database, like insert , select etc.
There are three Interfaces: AppoinmentRepository, DoctorRepository, PatientRepository

IDB is interface that helps with connection to Database.

PostgresDB is a class that implements and retrieves from database login , password.

Controller is a class that notifies us if we created new object in our database.
There are three controllers: AppoinmentController, DoctorController, PatientController

Application retrives variables that we inserted with usage of our console. 
We have two of them : DoctorApplication, PatientApplication

Main uses all classes as one mechanism.
