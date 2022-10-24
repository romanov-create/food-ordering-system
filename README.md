# food-ordering-system
## simple spring-boot application with spring-shell for command line interface
### the project has an in-memory database H2 and PostConstruct init DB(init cuisines, init dishes and init orders)

how to run:
1. run SpringShellApplication
2. write comand help
3. SSH Command
       get-all-cuisine: get all cuisine
       place-order: create a new order; parameters: [dishIdList]; exp.: place-order --id 1 2 3
       create-dish: create a new dish; parameters: [name, price, TypeDish[main, dessert, drink], Cuisine(optional), isIceCubes(optional), isLemon(optional) ]; example: add-dish tea 15.90 drink --ice --lemon
       get-all-dish: get all dish
       get-all-order: get all order
       add-cuisine: add a new cuisine; parameters: [name, description]; exp.: add-cuisine Italian Some description
 4. choose command and write

# SQL queries for this task
![image](https://user-images.githubusercontent.com/85928123/197555766-0ce31cea-81ae-4b36-90c6-96a609fd44b4.png)

1.
SELECT 
  Country.* 
FROM 
  Country 
  INNER JOIN City ON Country.CountryID = City.CountryID 
GROUP BY 
  City.CountryID 
HAVING 
  SUM(City.Population) > 400;
  
//------------------------------------------------------//

2.
SELECT 
  Country.* 
FROM 
  Country 
  INNER JOIN City ON Country.CountryID = City.CountryID 
  INNER JOIN Building ON City.CityID = Building.CityID 
GROUP BY 
  City.CountryID 
HAVING 
  COUNT(Building.BuildingID) = 0;
