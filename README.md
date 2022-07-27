# Recipe-Manager :bread: :baguette_bread: :flatbread:
- Main purpose: Create a Bread Recipe Manager to keep track of ingredients for intelligent ingredient shopping. 
- Goals are:
  - To practice input validation with try/catch blocks. Bad inputs are flagged in all steps of the application.
  - Create nested menus
  - Practice UI design in CLI
  - Create structure for file reading (next version of the application)

OBS.: Some recipes were provided, with made up quantities for ingredients. For this version, it is not possible to add or remove any ingredient.

## Sections

All the sections have input validation logic applied. Inputs are meant to be only integers, sometimes within a range. User is to be informed if a bad input is read and why it is not accepted.


### Main Menu
<img src="https://user-images.githubusercontent.com/37350658/180489650-6442836d-e145-4257-ba0d-d4e2fa015422.png"  width="260" height="200">

- User can choose any of the options listed, each explained in following sections
- Application detects bad input (Strings, out-of-range ints, decimals...), prints a message error, and prevents the software to crash.

### :arrow_right: Show available recipes [Option 1]
<img src="https://user-images.githubusercontent.com/37350658/180492615-0b0dde98-3b4e-49da-a3f8-4bbbf151d49a.png"  width="300" height="200">

- Shows available recipes. This version only has 7.
- Inputing 0 takes user back to main menu.
- Inputing a recipe number will display info and instructions about the recipe (Example shows recipe number 5) :
<img src="https://user-images.githubusercontent.com/37350658/180608993-4f4eb6b1-3322-4749-b26a-1da3eebf60aa.png"  width="380" height="200">

### :arrow_right: Add/subtract [Option 2]
<img src="https://user-images.githubusercontent.com/37350658/180609549-b27ed9ac-b928-48c9-83ba-e392fb9664fa.png"  width="900" height="200">

- Let's user add a recipe to the shopping list and displays it.
- Keeps asking for recipe # until user hit 0, which will make the application go back to main menu
- If user inputs a negative number, will subtract from the list (Example below) :
<img src="https://user-images.githubusercontent.com/37350658/181355425-1e9bf6b5-85cc-4e5f-9fc2-bed7d25bcbe8.png"  width="300" height="250">

### :arrow_right: Print Shopping List [Option 3]
<img src="https://user-images.githubusercontent.com/37350658/181356502-a9856b63-cd10-4e81-9e6a-2b6e9d52839b.png"  width="500" height="250">

- Based on the recipes chosen in option 2, application creates a shopping list, which adds all ingredients from all recipes into one table
- User can display the table in 2 measuring units, Metric and Imperial. This option can be changed in Main Menu

### :arrow_right: Change Units [Option 4]
<img src="https://user-images.githubusercontent.com/37350658/181356904-86a8e6d5-cab1-4a52-92a0-d4123217a211.png"  width="300" height="320">

- User can change units of the application from metric to imperial and vice versa. 
- Changes the units wherever there are ingredients being displayed. 

### :arrow_right: See Added Recipes [Option 5]
<img src="https://user-images.githubusercontent.com/37350658/181357354-a0432759-8440-48a0-96cc-2532834f181a.png"  width="300" height="220">

- Displays the recipes the user added to the shopping list. 

### :arrow_right: Quit the Application [Option 6]
<img src="https://user-images.githubusercontent.com/37350658/181357741-f7d7d99d-39fc-47a7-b397-1699d0e719d5.png"  width="200" height="120">

- Exits the application. 
- Before exiting, the signture of the author is displayed

### :arrow_right: Reprint the Main Menu [Option 0]
- Simply reprints the main menu endlessly. 









