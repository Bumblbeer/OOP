# Demonstration

## Ading shapes

<p align="center">
<img alt="Launched program" src="demoPics/mainscreen.png">
</p>

Now let's try to add a circle and test invalid values:

<p align="center">
<img alt="Negative value" src="demoPics/circleNegative.png">
<img alt="Zero value" src="demoPics/circleZero.png">
<img alt="Normal value" src="demoPics/circleNormal.png">
</p>

It's time for a rectangle:

<p align="center">
<img alt="Negative value" src="demoPics/rectangleNegative.png">
<img alt="Zero value" src="demoPics/rectangleZero.png">
<img alt="Normal value" src="demoPics/rectangleNormal.png">
</p>

Now we'll add a square:

<p align="center">
<img alt="Invalid value" src="demoPics/squareInvalid.png">
<img alt="Normal value" src="demoPics/squareNormal.png">
</p>

Finally, triangle:

<p align="center">
<img alt="Negative value" src="demoPics/triangleNegative.png">
<img alt="Zero value" src="demoPics/triangleZero.png">
<img alt="Normal value" src="demoPics/triangleNormal.png">
</p>

Let's check if the program handles impossible triangles:

<p align="center">
<img alt="Non-existing triangle" src="demoPics/triangleNonExists.png">
</p>

Also, behind the scenes, the circle with radius 0.5 was added. In result, we've got this list:

<p align="center">
<img alt="Modified list" src="demoPics/listModified.png">
</p>

## Modifying the list

Let's try to move a couple of shapes. We'll move the triangle up:

<p align="center">
<img alt="Shape moved up" src="demoPics/triangleMovedUp.png">
</p>

And let's move the new circle down:

<p align="center">
<img alt="Shape moved down" src="demoPics/circle05movedDown.png">
</p>

Now we'll check the remove button. For this, we'll remove the circle with radius equals to 0.5:

<p align="center">
<img alt="Shape removed" src="demoPics/circle05removed.png">
</p>

## Open/Save test

Now let's try to save this list to a **.json** file. After clicking on the save button, the system dialog window pops up:

<p align="center">
<img alt="Save dialog" src="demoPics/saveDialog.png">
</p>

The saved file is [here](shapesSaved.json)
We want to modify this list to show that open button is working, so let's add a square with each side equals to 55:

<p align="center">
<img alt="Modified list" src="demoPics/listModifiedAfterSave.png">
</p>

And right after this we'll click "Open". The system dialog pops up again:

<p align="center">
<img alt="open dialog" src="demoPics/openDialog.png">
</p>

And we've got the list that we've saved:

<p align="center">
<img alt="Opened list" src="demoPics/openedList.png">
</p>

And now it is time to close our program. Task required to give a possibility to save before closing. So we'll modify our list again:

<p align="center">
<img alt="Modified list" src="demoPics/listModifiedBeforeClosing.png">
</p>

And let's click on the close button. System dialog pops up giving an opportunity to save list:

<p align="center">
<img alt="Save dialog" src="demoPics/saveDialogClose.png">
</p>

The saved file is [here](shapesSaveAfterClose.json)
