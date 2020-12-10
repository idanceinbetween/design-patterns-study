#Prototype

## GoF Definition
Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype. 

## What problem does it solve?
There are a few problems by creating a new instance of the object and copy over all the fields to the new instance:
- Creating a new instance is expensive
- Some fields could be private, so we can't copy them from the outside
- Sometimes we only know the interface that the original object follows 
- It creates a dependency on the original object 

This pattern delegates the responsibility of cloning to the *original* object. 💪

## Basic implementation

- Have an interface that declares the cloning method(s) (doesn't have to be called the `Prototype` interface), most cases it's a single clone() method.
- Concrete Prototype class implements the cloning method

## Other considerations
### Shallow VS deep copy

Shallow copy is "also known as a _field-by-field copy_" (Sarcar). 

If a field in the original object (A) holds reference to another object (B), 
when we clone A to create C, the reference to B continues to hold, i.e. both 
A and C points to the same object B.

A deep copy would mean that there is D, which is a clone of object B, resulting in
 A referring to B, and C referring to D. 
 
 
 
 

## Sidetrack
### Data Class in Kotlin vs @Data in Lombok for Java 

The docs from Kotlin on Data class reminds me of Lombok's `@Data` annotation for Java, so I decided to compare them both:  

```
Kotlin docs: 

The compiler automatically derives the following members from all properties declared in the primary constructor:
- equals()/hashCode() pair;
- toString() of the form "User(name=John, age=42)";
- componentN() functions corresponding to the properties in their order of declaration;
- copy() function
```

```
Lombok docs:

@Data is a convenient shortcut annotation that bundles together the following features normally associated with POJOs:
- @ToString 
- @EqualsAndHashCode
- @Getter / @Setter
- @RequiredArgsConstructor 
```
### clone is broken in Java
- ["I think clone is deeply broken" by Josh Bloch](https://www.artima.com/intv/bloch.html#part13)
