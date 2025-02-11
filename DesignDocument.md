# Payroll Generator Design Document


This document is meant to provide a tool for you to demonstrate the design process. You need to work on this before you code, and after have a finished product. That way you can compare the changes, and changes in design are normal as you work through a project. It is contrary to popular belief, but we are not perfect our first attempt. We need to iterate on our designs to make them better. This document is a tool to help you do that.


## (INITIAL DESIGN): Class Diagram

Place your class diagram below. Make sure you check the fil in the browser on github.com to make sure it is rendering correctly. If it is not, you will need to fix it. As a reminder, here is a link to tools that can help you create a class diagram: [Class Resources: Class Design Tools](https://github.com/CS5004-khoury-lionelle/Resources?tab=readme-ov-file#uml-design-tools)

![Initial Design](img/Initial%20Design%20Diagram.jpg)


## (INITIAL DESIGN): Tests to Write - Brainstorm

Write a test (in english) that you can picture for the class diagram you have created. This is the brainstorming stage in the TDD process. 

> [!TIP]
> As a reminder, this is the TDD process we are following:
> 1. Figure out a number of tests by brainstorming (this step)
> 2. Write **one** test
> 3. Write **just enough** code to make that test pass
> 4. Refactor/update  as you go along
> 5. Repeat steps 2-4 until you have all the tests passing/fully built program

You should feel free to number your brainstorm. 

1. Test that the `AbstractEmployee` class properly returns `name` from `getName()`
2. Test that the `AbstractEmployee` class properly returns `id` from `getId()`
3. `AbstractEmployee` class properly returns `payRate` from `getPayRate()`
4. `AbstractEmployee` class properly returns `employeeType` from `getEmployeeType()`
5. `AbstractEmployee` class properly returns `ytdEarnings` from `getYTDEarnings()`
6. `AbstractEmployee` class properly returns `ytdTaxesPaid` from `getYTDTaxesPaid()`
7. `HourlyEmployee` class properly returns `grossPay` from `calculateGrossPay()`
8. `SalaryEmployee` class properly returns `grossPay` from `calculateGrossPay()`
9. `TimeCard` class properly returns `employeeID` and `hoursWorked` from `getEmployeeID()` and `getHoursWorked()`
10. `PayStub` class properly returns `netPay` from `getPay()`
11. `PayStub` class properly returns `tax` from `getTaxesPaid()`
12. `Builder` class properly returns `Employee object` from `buildEmployeeFromCSV()`
13. `Builder` class properly returns `TimeCard object` from `buildTimeCardFromCSV()`



## (FINAL DESIGN): Class Diagram

Go through your completed code, and update your class diagram to reflect the final design. Make sure you check the file in the browser on github.com to make sure it is rendering correctly. It is normal that the two diagrams don't match! Rarely (though possible) is your initial design perfect.
![Final Design](img/Final%20UML.jpg)

> [!WARNING]
> If you resubmit your assignment for manual grading, this is a section that often needs updating. You should double check with every resubmit to make sure it is up to date.





## (FINAL DESIGN): Reflection/Retrospective

> [!IMPORTANT]
> The value of reflective writing has been highly researched and documented within computer science, from learning new information to showing higher salaries in the workplace. For this next part, we encourage you to take time, and truly focus on your retrospective.

Take time to reflect on how your design has changed. Write in *prose* (i.e. do not bullet point your answers - it matters in how our brain processes the information). Make sure to include what were some major changes, and why you made them. What did you learn from this process? What would you do differently next time? What was the most challenging part of this process? For most students, it will be a paragraph or two. 

**Answer:**

The first changes I made were adding the `PayStub` and `TimeCard` classes. I also removed the additional `Employee` class since it was a duplicate of the `AbstractEmployee` class. Additionally, I introduced an `enum` class to store `EmployeeType`, which I initially thought should be handled separately in different subclasses.

These changes were necessary due to a lack of clarity in the relationships between the classes and how they interact. The structure only became clearer as I delved deeper into coding. However, this led to mistakes early on, causing me to spend extra time debugging. Moving forward, it would be more efficient to thoroughly understand class relationships before writing any code.