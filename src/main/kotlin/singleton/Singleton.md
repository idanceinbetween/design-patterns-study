#Singleton Pattern

## GoF Definition
Ensure a class only has one instance, and provide a global point of access to it.

## What problem does it solve?
- Ensure a class has just a single instance - e.g. to control access to some shared resource (a database or a file)
- We can now access an object just like a global variable. However unlike a global variable, singleton object cannot 
be overwritten by other code.

## Basic principles for implementation 
- Make the default constructor private. Prevent other objects from new-ing it up.
- Create a *public static creation method* that acts as a constructor, and that is has lazy initialisation.  
    - If the rest of the code has access to this method, calls to this method will do the same thing: new up the 
    object if it doesn't exist, otherwise return the *cached instance*.
- Private static field to store the instance.
- In multithreaded environment, ensure multiple threads won't create a singleton object several times.

## Other considerations

- Difficult to unit test the client code of the Singleton, as many test frameworks rely on inheritance when producing
 mock objects.
- A bigger picture for consideration is that Singletons are global (mutable) state in disguise. 
    - By introducing Singletons in code, "you will couple every class, method and function which use these global 
    states together. Don’t forget: dependencies bring a lot of complexity." - [The Valuable Dev](https://thevaluable.dev/global-variable-explained/)
    - "Making something global to avoid passing it around is a code smell." ... "If your Singleton carries a significant global state, don’t use Singleton. This includes persistent storage 
    such as Databases, Files etc." - [Singleton Considerations](https://jorudolph.wordpress.com/2009/11/22/singleton-considerations/)

If n objects all know about each others, then a change to just one object can result in the other n-1 objects needing changes.
The Pragmatic Programmer
