package queueproject;

import java.util.*;

public class GroceryStoreQueue {

    ArrayDeque<Person> queue = new ArrayDeque<>();

    public void processInput(String input) {
        if (input.contains("ADD") && !input.contains("VIP")) {
            addPersonToQueue(input);
        } else if (input.contains("PROCESS")) {
            processQueue();

        } else if (input.contains("LEAVE")) {
            leavePersonFromQueue(input);

        } else if (input.contains("VIP")) {
            addPersonVipToQueue(input);
        } else {
            System.out.println("O co Ci chodzi?");
        }
    }

    private void processQueue() {
        Person processedPerson = queue.poll();
        System.out.println("Processing queue: " + processedPerson.getName() + processedPerson.getSurname() +
                            processedPerson.getCounter() + " arrived at the store");
        System.out.printf("%s%n", "Queue: " + queue);
        System.out.println();
    }
    private void leavePersonFromQueue(String input) {
        String[] strArr = getStrArr(input);
        String name = strArr[0];
        String surname = strArr[1];
        int counter = 1;
        Person personToLeave = new Person(name + "_", surname + "_", counter);
        if (!queue.contains(personToLeave)) {
            System.out.println(personToLeave + " is not in the queue");
            System.out.println();
            return;
        }
        if (strArr.length == 3) {
            counter = Integer.parseInt(strArr[2]);
            personToLeave = new Person(name + "_", surname + "_", counter);
        }
        System.out.println("Leaving queue: " + personToLeave);
        queue.remove(personToLeave);
        System.out.printf("%s%n", "Queue: " + queue);
        System.out.println();
    }

    public void addPersonToQueue(String input) {
        String[] strArr = getStrArr(input);
        String name = strArr[0];
        String surname = strArr[1];
        int counter = 1;
        Person personToAdd = new Person(name + "_", surname + "_", counter);
        personToAdd = checkPersonToAddInQueue(name, surname, personToAdd);
        boolean addFlag = queue.offer(personToAdd);
        System.out.printf("%s%s%d %s %b%n", personToAdd.getName(), personToAdd.getSurname(), personToAdd.getCounter(),
                                            "came to queue: ", addFlag);
        System.out.printf("%s%n", "Queue: " + queue);
        System.out.println();

    }

    public void addPersonVipToQueue(String input) {
        int index1 = input.indexOf("(");
        int index2 = input.indexOf(",");
        input = input.substring(index1 + 1, index2);
        String[] strArr = input.split("_");
        String name = strArr[0];
        String surname = strArr[1];
        int counter = 1;
        Person personToAdd = new Person(name + "_", surname + "_", counter);
        personToAdd = checkPersonToAddInQueue(name, surname, personToAdd);
        List<Person> list = new LinkedList<>(queue);
        personToAdd.setVip(true);
        int lastVipIndex = 0;
        for (Person person : list) {
           if (person.isVip()) {
               lastVipIndex++;
           }
        }
        if (lastVipIndex == 0) {
            queue.addFirst(personToAdd);
        } else {
            list.add(lastVipIndex, personToAdd);
            queue.clear();
            queue.addAll(list);
        }
        System.out.println(personToAdd + " come to the queue: " + personToAdd.isVip());
        System.out.printf("%s%n", "Queue: " + queue);
        System.out.println();
    }

    private Person checkPersonToAddInQueue(String name, String surname, Person personToAdd) {
        int counter;
        Iterator<Person> iterator = queue.iterator();
        while (iterator.hasNext()) {
            Person personFromQueue = iterator.next();
            String namePersonFromQue = personFromQueue.getName().substring(0, personFromQueue.getName().length()- 1);
            String surnamePersonFromQue = personFromQueue.getSurname().substring(0, personFromQueue.getSurname().length()- 1);
            if (surnamePersonFromQue.equals(surname) && namePersonFromQue.equals(name)) {
                counter = personFromQueue.getCounter();
                counter++;
                personToAdd = new Person(name + "_", surname + "_", counter);
            }
        }
        return personToAdd;
    }

    private static String[] getStrArr(String input) {
        int index1 = input.indexOf("(");
        int index2 = input.indexOf(")");
        input = input.substring(index1 + 1, index2);
        String[] strArr = input.split("_");
        return strArr;
    }
}
// map.getOrDefault(key, defValue)


