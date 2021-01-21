# Factory

## GoF Definition

Define an interface for creating an object, but let subclasses decide which class to instantiate.

- Factory method *lets a class defer instantiation to subclasses*.
- In other words, the subclasses that derive from this abstract class perform the actual instantiation process.

## What problem does it solve?

- Use this when you don't know beforehand the exact types and dependencies of the objects your code should work with.
- This is useful if you want to provide users of your library or framework with a way to extend its internal components.
    - In this code example, if client wants two animals, a Duck and a Tiger, they just call the DuckFactory and 
      TigerFactory. As these two factories are subclasses of an AnimalFactory, there is full confidence that the Duck 
      and Tiger will be able to do everything that an Animal can do.
    - Note that factory method doesn't have to create new instances all the time. It can also return existing objects from a 
      cache, an object pool or another source.
  
## Relations with other patterns 

- Many designs start by using Factory method (less complicated and more customisable via subclasses) and evolve towards
  Abstract Factory, Prototype or Builder (more flexible but more complicated).

## Side tracked learnings

- Abstract vs interface
    - Abstract class doesn't support multiple inheritance; an interface does.
    - A class can extend one abstract class only, but can implement multiple interfaces.
- This factory code has spiralled out a bit to explore `extends` and `implements`...   

## References

- The tiger and dog example is adopted from Java Design Patterns book. 
