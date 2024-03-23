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
Above example is a violation of SRP Principle since it has multiple responsibilities, Checking-in the books(Inventory), persisting book data to a database, managing book properties. Refactoring above code adhering to SRP principle:

    class LibraryBook:
        def __init__(self, title, author, isbn):
            self.title = title
            self.author = author
            self.isbn = isbn

    class InventoryManager:
        def __init__(self):
            self.books = {}  # Stores book ISBNs and their locations

        def check_in(self, isbn, location):
            self.books[isbn] = location
            # Additional logic for adding the book back to inventory

        def check_out(self, isbn):
            self.books[isbn] = 'Checked out'
            # Additional logic for removing the book from inventory

    class BookPersistence:
        def save_book(self, library_book):
            # Logic to save the book details to a database
            pass

        def load_book(self, isbn):
            # Logic to load book details from a database
            pass
However, following the Single Responsibility Principle (SRP) often leads to a design with more classes, each handling a single responsibility. Applying SRP (and other design principles) requires balance. Over-segmentation can lead to an excessive number of classes, making the system overly complex and potentially difficult to navigate. The key is to identify genuinely distinct responsibilities that justify separation into different classes. The goal is to enhance the maintainability, scalability, and understandability of the code without overcomplicating the design.

Therefore, while SRP often results in creating more classes, the principle should be applied judiciously to strike the right balance between simplicity and modularity.

## 2. Open/Closed Principle: 


