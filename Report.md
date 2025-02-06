# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for?
   CSV stands for "comma-separated values," is a plain text file where data is organized in a table format with each value separated by a comma

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?
    Using `IEmployee` allows the flexibility to store any type of employee, such as `HourlyEmployee` or `SalaryEmployee`.
    Using `List<>` also allows the flexibility to change the collection type, such as `ArrayList` or `LinkedList`.

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?
    It's called "has-a" relationship when one class contains an instance of another class as an attribute.

4. Can you provide an example of a has-a relationship in your code (if one exists)?
   `public PayStub(IEmployee employee, double netPay, double tax) { this.employee = employee; }`

5. Can you provide an example of an is-a relationship in your code (if one exists)?
    `public class HourlyEmployee extends AbstractEmployee {}` 
   `HourlyEmployee` class extends from `AbstractEmployee` class.

6. What is the difference between an interface and an abstract class?
    An interface serves as a contract, defines the methods/behaviors that multiple classes should implement, and it cannot have constructors, only has abstract methods. An abstract class provides common functionality to subclasses to avoid repeated code, and it can have fields and contructors.

7. What is the advantage of using an interface over an abstract class?
   A class can implement multiple interfaces but can only extend one abstract class. Also, interface ensures consistency in method names and behavior across different implementations.

8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 
    No, it's not valid. The correct code should be `List<Integer> numbers = new ArrayList<>();` since `int` is a primitive type, but we should put a wrapper class like `Integer` for Generics and Collections.

9. Which class/method is described as the "driver" for your application?
    The `main` method in `PayrollGenerator` class is the driver of this application.

10. How do you create a temporary folder for JUnit Testing?
    `@TempDir Path tempDir`


## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 
