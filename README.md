# Queue Project

This project is a solution to an exercise from the Udemy course
"[Warsztat Java - Java generics i kolekcje](https://www.udemy.com/course/kurs-java-generics-i-kolekcje/)"
by [Zajavka PL, Karol Rogowski].
The exercise involved creating a Java application that utilizes the Queue data structure.

## Description

This Java project implements an application that demonstrates the functionalities of `ArrayDeque`.
The solution is based on a course exercise, with my own implementation. 
The program simulates a queue management system for a grocery store.

The operations provided by the program include:

- **Adding a new person** to the queue.
- **Removing a person** from the queue on demand, without reaching the front.
- **Processing customers** reaching "the store" and leaving the queue following the FIFO rule.
- **Adding VIP customers** to the queue, allowing them to take a position at the front. If there is a collision between two VIPs, the later VIP takes the next available position at the front of the queue.

## Getting Started

To run the application, clone the repository and execute the main class in your Java IDE or use the command line.

## Cloning the repository

To clone this repository to your local machine, use the following commands:

```bash
https://github.com/michalandrejczuk/queueproject.git
cd queueproject