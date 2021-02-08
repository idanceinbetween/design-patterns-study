# Strategy

## GoF Definition

Define a family of algorithms, encapsulate each one, and make them interchangeable. 

Strategy lets the algorithm vary independently from the clients that use it.


## OO Principles

1. Encapsulate what varies 


2. Program to an interface, not an implementation.
- _Duck classes won’t need to know any of the implementation details for their own behaviors._


3. Favor composition over inheritance
- "HAS-A can be better than IS-A"
- _Duck class **has a** QuackBehaviour and FlyBehaviour_

Design Patterns give you a shared vocabulary with other developers. Once you’ve got the vocabulary you can more easily communicate with other developers and inspire those who don’t know patterns to start learning them. It also elevates your thinking about architectures by letting you think at the pattern level, not the nitty-gritty object level.
