# Observer

## GoF Definition

The Observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically.
- Adheres to the open close principles, removes coupling between the subject (Observable) and the Observers.

## Implementation Details

- 1x Subject interface and 1x Observer interface
    - The only thing a Subject knows is that there is an observer interface, but doesn't know who the concrete observers are.
    - We could even replace who the concrete observers are at Runtime, and all will still be good

### Attempt:
1. Subject has list of observers
2. Subject has an instance variable that is observed by observers (`by Delegates observable {call back for the listeners}`)
3. Observers each has an action when that observed variable changes
4. `with subject`, assign new value to the observed variable

Reference: [dbacinski's Design Patterns In Kotlin project](https://github.com/dbacinski/Design-Patterns-In-Kotlin/blob/master/patterns/src/test/kotlin/Listener.kt)

## Usage

- It is built in support for broadcast communication.
  - When visualising it, a newspaper subscription service with its publisher and subscribers is a good way to understand it.
- Most useful in Reactive programming.
- Vs other design patterns:
  - Structurally similar to Bridge, but the intention is different.
  - Mediator may be used to mediate between several subjects and observers. 

## Cons

- There might be unexpected updates
- It may be expensive and untimely
- [Lapsed Listener Problem blog post](https://ilkinulas.github.io/development/general/2016/04/17/observer-pattern.html)
  - Remember to deregister an observer when the time comes
  - Use `WeakReference` [WeakReference In Kotlin](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.native.ref/-weak-reference/)

## Other notes
- [Observer Is Deprecated In Java 9. What should we use instead of it](https://stackoverflow.com/questions/46380073/observer-is-deprecated-in-java-9-what-should-we-use-instead-of-it)
- https://www.agilelearner.com/presentation/418
- https://github.com/dbacinski/Design-Patterns-In-Kotlin#observer--listener
