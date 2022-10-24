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
