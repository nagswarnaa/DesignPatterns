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

In the Java Collections Framework, the principle of Single Responsibility is followed, ensuring that each class has one and only one reason to change. This principle is a key aspect of SOLID design principles, promoting a cleaner, more modular structure.

A clear example of the Single Responsibility Principle (SRP) in the Java Collections Framework is the distinction between the `List`, `Set`, and `Map` interfaces, each serving a distinct purpose:

- **`List` Interface**: Represents an ordered collection of elements that can contain duplicate values. It is responsible for maintaining the insertion order of the elements, and it allows positional access and insertion of elements. Classes like `ArrayList` and `LinkedList` implement the `List` interface, each with a specific approach to data storage and access, but all adhering to the single responsibility of managing an ordered collection.

- **`Set` Interface**: Represents a collection that cannot contain duplicate elements. It is designed for scenarios where uniqueness of the elements is crucial. Implementations of the `Set` interface, such as `HashSet` and `TreeSet`, ensure that no two elements in the collection are the same, adhering strictly to their single responsibility of managing a set of unique elements.

- **`Map` Interface**: Represents a collection of key-value pairs, where each key is unique. This interface is responsible for associating unique keys to specific values, allowing for efficient retrieval, update, and deletion of entries based on the key. Classes like `HashMap` and `TreeMap` implement the `Map` interface, each ensuring that they adhere to the single responsibility of managing a collection of key-value pairs where keys are unique.

## 2. Open/Closed Principle: 
    A Software entity(class, module) should be open for extension and closed for modification. This principle aims to allow systems to grow and change with new requirements without directly modifying existing source code, thereby reducing the risk of introducing new bugs in previously tested and validated code.
- **Open for Extension:** You should be able to extend the behavior of a module if the requirements of the application change, or to add new features.
- **Closed for Modification:** Extending the behavior of a module should not require changing the source code of the module itself. Instead, the new behavior should be added by creating new entities.
- 
**How to Apply OCP**

Applying OCP typically involves the use of interfaces or abstract classes to abstract away the concrete implementations of behaviors or algorithms. By programming to an interface, your system can easily incorporate new behaviors by adding new classes that implement these interfaces without changing the existing code.


      from abc import ABC, abstractmethod
     class ReportGenerator(ABC):
        @abstractmethod
        def generate_report(self, content):
            pass

    class PdfReportGenerator(ReportGenerator):
        def generate_report(self, content):
            # Logic to generate a PDF report
            print("Report generated in PDF format.")

    class HtmlReportGenerator(ReportGenerator):
        def generate_report(self, content):
            # Logic to generate an HTML report
            print("Report generated in HTML format.")

The above system is open for extension because you can add new report formats by creating new classes that implement the ReportGenerator interface. It is closed for modification because you do not need to change existing classes to add new types of reports.

The Open/Closed Principle, one of the SOLID design principles, states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This principle promotes the idea of designing your modules so that new functionality can be added without changing the existing code.

In the Java Collections Framework, the Open/Closed Principle is exemplified by the design of collection interfaces and their implementation classes. Let's focus on the `Collection` interface and its relationship with various concrete classes like `ArrayList`, `LinkedList`, `HashSet`, and `TreeSet`.

- **`Collection` Interface**: This is a root interface in the Collections Framework. It declares the essential operations that all collections will have, such as `add()`, `remove()`, `size()`, `iterator()`, etc. However, it does not provide any direct implementations of these operations.

- **Concrete Implementations**: Concrete classes like `ArrayList`, `LinkedList`, `HashSet`, and `TreeSet` implement the `Collection` interface. Each of these classes provides its own implementation of the methods defined in the interface, optimized for different use cases (e.g., `ArrayList` for fast random access, `LinkedList` for efficient insertions/deletions, `HashSet` for unique elements, and `TreeSet` for sorted unique elements).

The Open/Closed Principle is followed in this design in the following ways:

1. **Closed for Modification**: The `Collection` interface and its methods define a contract that all implementing classes agree to fulfill. This interface is closed for modifications; adding new methods to it would require changes in all implementing classes, which is not desirable.

2. **Open for Extension**: Despite being closed for modifications, the `Collection` framework is open for extension in several ways:
   - New classes can implement the `Collection` interface to create a new type of collection that adheres to the defined contract.
   - Existing classes can be extended to add new behavior. For example, you could extend `ArrayList` to create a `NotifyingArrayList` that emits events every time the collection is modified.
   - The framework can be extended with new interfaces and classes without altering the existing code. This has been seen over time with additions like the `Queue` interface and its implementations.



