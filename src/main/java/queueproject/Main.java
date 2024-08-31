package queueproject;

import java.util.List;

public class Main {
    public static void main(String[] args) {
    List<String> people = List.of(
            "ADD PERSON(Tomasz_Romański)",
        "ADD PERSON(Rafał_Adamczuk)",
        "ADD PERSON(Tomasz_Romański)",
        "ADD PERSON(Mariusz_Wilczek,VIP)",
            "ADD PERSON(Mariusz_Wilczek,VIP)",
        "ADD PERSON(Zbigniew_Ratownik)",
        "ADD PERSON(Roman_Tomaszewski,VIP)",
        "PROCESS",
        "LEAVE PERSON(Zbigniew_Ratownik)",
        "LEAVE PERSON(Tomasz_Romański_2)",
        "PROCESS",
        "PROCESS",
        "PROCESS",
        "PROCESS"
    );
    GroceryStoreQueue groceryStoreQueue = new GroceryStoreQueue();

        for (String person : people) {

            groceryStoreQueue.processInput(person);

        }
    }
}