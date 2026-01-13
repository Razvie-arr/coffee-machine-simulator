package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CoffeeMachineInternal coffeeMachineInternal = new CoffeeMachineInternal();
        CoffeeMachineUserCommunication userCommunication = new CoffeeMachineUserCommunication(input, coffeeMachineInternal);
        userCommunication.run();
    }

}

