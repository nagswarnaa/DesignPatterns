### SOLID Principles:
1. Single Responsibility Principle
2. Open/Closed Principle
3. Liskov Substitution Principle
4. Interface Seggregation Principle
5. Dependency Inversion Principle

Let's dive deep into each one these along with examples:

## 1. Single Responsibility Principle 
    A class should have only one reason to change, means a class should do only one job or should have only one responsibility.
Let's dive deeper into the Single Responsibility Principle (SRP) with a practical example. Consider a system for managing a library's book inventory. A common violation of SRP occurs when a class takes on responsibilities that should be separated into different classes.

    class LibraryBook:
      def __init__(self, title, author, isbn):
          self.title = title
          self.author = author
          self.isbn = isbn
          self.location = None

      def check_in(self, location):
          self.location = location
          # Logic to add the book back to the library inventory

      def check_out(self):
          self.location = 'Checked out'
          # Logic to remove the book from the library inventory

      def save(self):
          # Logic to save the book details to a database


