package machine;

import java.util.Scanner;

public class CoffeeMachineUserCommunication {

    private final Scanner input;
    private final CoffeeMachineInternal coffeeMachineInternal;

    public CoffeeMachineUserCommunication(Scanner input, CoffeeMachineInternal coffeeMachineInternal) {
        this.input = input;
        this.coffeeMachineInternal = coffeeMachineInternal;
    }

    public void run() {
        askForAction();
        while (true) {
            String chosenAction = input.next();
            System.out.println();
            switch (chosenAction) {
                case "buy" -> buyCoffee();
                case "fill" -> fillCoffee();
                case "take" -> takeMoney();
                case "clean" -> clean();
                case "remaining" -> remaining();
                case "exit" -> {
                    return;
                }
            }
            System.out.println();
            askForAction();
        }
    }

    private void buyCoffee() {
        if (coffeeMachineInternal.needsCleaning()) {
            System.out.println("I need cleaning!");
            return;
        }

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = input.next();
        try {
            switch (choice) {
                case "1" -> {
                    coffeeMachineInternal.validateEspresso();
                    printEnoughResources();
                    coffeeMachineInternal.buyEspresso();
                }
                case "2" -> {
                    coffeeMachineInternal.validateLatte();
                    printEnoughResources();
                    coffeeMachineInternal.buyLatte();
                }
                case "3" -> {
                    coffeeMachineInternal.validateCappuccino();
                    printEnoughResources();
                    coffeeMachineInternal.buyCappuccino();
                }
                case "back" -> {
                }
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private void fillCoffee() {
        System.out.println("Write how many ml of water you want to add:");
        int water = input.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int milk = input.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int beans = input.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        int disposableCups = input.nextInt();

        coffeeMachineInternal.fill(water, milk, beans, disposableCups);
    }

    private void takeMoney() {
        int takenMoney = coffeeMachineInternal.take();
        System.out.printf("I gave you $%d\n", takenMoney);
    }


    private void clean() {
        coffeeMachineInternal.clean();
        System.out.println("I have been cleaned!");
    }

    private void remaining() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", coffeeMachineInternal.getWaterInMachine());
        System.out.printf("%d ml of milk\n", coffeeMachineInternal.getMilkInMachine());
        System.out.printf("%d g of coffee beans\n", coffeeMachineInternal.getBeansInMachine());
        System.out.printf("%d disposable cups\n", coffeeMachineInternal.getDisposableCupsInMachine());
        System.out.printf("$%d of money\n", coffeeMachineInternal.getMoneyInMachine());
    }

    private void askForAction() {
        System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
    }

    private void printEnoughResources() {
        System.out.println("I have enough resources, making you a coffee!");
    }


}
