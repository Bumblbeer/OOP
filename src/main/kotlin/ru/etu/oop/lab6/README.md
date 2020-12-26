#Demonstration
##Adding shapes
<img alt="Launched program" align="center" src="demoPics/mainScreen.png">
Now let's try to add a circle and test invalid values:
<img alt="Negative value" align="center" src="demoPics/circleNegative.png">
<img alt="Zero value" align="center" src="demoPics/circleZero.png">
<img alt="Normal value" align="center" src="demoPics/circleNormal.png">
It's time for a rectangle:
<img alt="Negative value" align="center" src="demoPics/rectangleNegative.png">
<img alt="Zero value" align="center" src="demoPics/rectangleZero.png">
<img alt="Normal value" align="center" src="demoPics/rectangleNormal.png">
Now we'll add a square:
<img alt="Invalid value" align="center" src="demoPics/squareInvalid.png">
<img alt="Normal value" align="center" src="demoPics/squareNormal.png">
Finally, triangle:
<img alt="Negative value" align="center" src="demoPics/triangleNegative.png">
<img alt="Zero value" align="center" src="demoPics/triangleZero.png">
<img alt="Normal value" align="center" src="demoPics/triangleNormal.png">
Let's check if the program handles impossible triangles:
<img alt="Non-existing triangle" align="center" src="demoPics/triangleNonExists.png">

Also, behind the scenes, the circle with radius 0.5 was added. In result, we've got this list:
<img alt="Modified list" align="center" src="demoPics/listModified.png">

##Modifying the list
Let's try to move a couple of shapes.
We'll move the triangle up:
<img alt="Shape moved up" align="center" src="demoPics/triangleMovedUp.png">
And let's move the new circle down:
<img alt="Shape moved down" align="center" src="demoPics/circle05movedDown.png">

Now we'll check the remove button. For this, we'll remove the circle with radius equals to 0.5:
<img alt="Shape removed" align="center" src="demoPics/circle05removed.png">

##Open/Save test
Now let's try to save this list to a **.json** file. After clicking on the save button, the system dialog window pops up:
<img alt="Save dialog" align="center" src="demoPics/saveDialog.png">
The saved file is [here](shapesSaved.json)
We want to modify this list to show that open button is working, so let's add a square with each side equals to 55:
<img alt="Modified list" align="center" src="demoPics/listModifiedAfterSave.png">
And right after this we'll click "Open". The system dialog pops up again:
<img alt="open dialog" align="center" src="demoPics/openDialog.png">
And we've got the list that we've saved:
<img alt="Opened list" align="center" src="demoPics/openedList.png">
And now it is time to close our program. Task required to give a possibility to save before closing. So we'll modify our list again:
<img alt="Modified list" align="center" src="demoPics/listModifiedBeforeClosing.png">
And let's click on the close button. System dialog pops up giving an opportunity to save list:
<img alt="Save dialog" align="center" src="demoPics/saveDialogClose.png">
The saved file is [here](shapesSaveAfterClose.json)