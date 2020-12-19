# Factory

## GoF Definition

Define an interface for creating an object, but let subclasses decide which class to instantiate.

- Factory method *lets a class defer instantiation to subclasses*.
- In other words, the subclasses that derive from this abstract class perform the actual instantiation process.

## What problem does it solve?

- Use this when you don't know beforehand the exact types and dependencies of the objects your code should work with.
- This is useful if you want to provide users of your library or framework with a way to extend its internal components.
    - In this code example, if someone wants to create a new 'product', let's say a Duck, they just need to add a new
      DuckFactory which instantiates the Duck which implements the functions of the Animal class, and use the new
      DuckFactory.
- Note that factory method doesn't have to create new instances all the time. It can also return existing objects from a
  cache, an object pool or another source.

## Side tracked learnings

- Abstract vs interface

