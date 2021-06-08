# Decorator

## GoF Definition

The Decorator Pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

## Implementation

- Abstract Component class is implemented by Concrete Component and Decorator. 
  - Decorator is implemented by Concrete Decorators
    - Concrete decorator HAS-A Component (instance variable, DI!)
