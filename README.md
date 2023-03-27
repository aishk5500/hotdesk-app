# hotdesk-app
The project imiztates a hot desking application for employees.

To run the appliaction clone it to your local repo and in your code editor Run the main file with connecting the MYSQL, change the mysql password and name according to your system.
Run the app by connecting it to Postman API with url loaclhost:/9090/city/getAll to get all the cities.

Seat name are displayed as TL and C for team lead and cubicle.
For every master entity (city, office, building, floor, seat) there is a Create, Update, Delete Operations

The View APIs will be the following:
Entity           Url                Request          Description
City        city/getAll                -             Get all Cities
Office     office/getByCityId       cityId           Get all offices of a particular city
Bulding    building/getByOfficeId   officeId         Get all buildings of an office
Floor     floor/getByBuildingId     buildingId       Get all floors of a building
Seat      seat/getByFloorId         floorId          Get all seats of a floor
