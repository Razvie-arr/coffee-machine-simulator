package machine;

public class CoffeeMachineInternal {

    private static final int WATER_FOR_ESPRESSO = 250;
    private static final int BEANS_FOR_ESPRESSO = 16;
    private static final int ESPRESSO_PRICE = 4;

    private static final int WATER_FOR_LATTE = 350;
    private static final int MILK_FOR_LATTE = 75;
    private static final int BEANS_FOR_LATTE = 12;
    private static final int LATTE_PRICE = 7;

    private static final int WATER_FOR_CAPPUCCINO = 200;
    private static final int MILK_FOR_CAPPUCCINO = 100;
    private static final int BEANS_FOR_CAPPUCCINO = 12;
    private static final int CAPPUCCINO_PRICE = 6;


    private int waterInMachine = 400;
    private int milkInMachine = 540;
    private int beansInMachine = 120;
    private int disposableCupsInMachine = 9;
    private int moneyInMachine = 550;

    private int cupsProducedBeforeCleaning = 0;

    public void validateEspresso() {
        validateResources(WATER_FOR_ESPRESSO, 0, BEANS_FOR_ESPRESSO);
    }

    public void validateLatte() {
        validateResources(WATER_FOR_LATTE, MILK_FOR_LATTE, BEANS_FOR_LATTE);
    }

    public void validateCappuccino() {
        validateResources(WATER_FOR_CAPPUCCINO, MILK_FOR_CAPPUCCINO, BEANS_FOR_CAPPUCCINO);
    }


    public void buyEspresso() {
        waterInMachine -= WATER_FOR_ESPRESSO;
        beansInMachine -= BEANS_FOR_ESPRESSO;
        disposableCupsInMachine -= 1;
        moneyInMachine += ESPRESSO_PRICE;

        cupsProducedBeforeCleaning++;
    }

    public void buyLatte() {
        waterInMachine -= WATER_FOR_LATTE;
        milkInMachine -= MILK_FOR_LATTE;
        beansInMachine -= BEANS_FOR_LATTE;
        disposableCupsInMachine -= 1;
        moneyInMachine += LATTE_PRICE;

        cupsProducedBeforeCleaning++;
    }

    public void buyCappuccino() {
        waterInMachine -= WATER_FOR_CAPPUCCINO;
        milkInMachine -= MILK_FOR_CAPPUCCINO;
        beansInMachine -= BEANS_FOR_CAPPUCCINO;
        disposableCupsInMachine -= 1;
        moneyInMachine += CAPPUCCINO_PRICE;

        cupsProducedBeforeCleaning++;
    }

    public void fill(int water, int milk, int beans, int disposableCups) {
        waterInMachine += water;
        milkInMachine += milk;
        beansInMachine += beans;
        disposableCupsInMachine += disposableCups;
    }

    public int take() {
        int takenMoney = moneyInMachine;
        moneyInMachine = 0;
        return takenMoney;
    }

    public boolean needsCleaning() {
        return cupsProducedBeforeCleaning >= 10;
    }

    public void clean() {
        cupsProducedBeforeCleaning = 0;
    }

    public int getWaterInMachine() {
        return waterInMachine;
    }

    public int getMilkInMachine() {
        return milkInMachine;
    }

    public int getBeansInMachine() {
        return beansInMachine;
    }

    public int getDisposableCupsInMachine() {
        return disposableCupsInMachine;
    }

    public int getMoneyInMachine() {
        return moneyInMachine;
    }

    private void validateResources(int neededWater, int neededMilk, int neededBeans) {
        String exceptionMessage = "Sorry, not enough %s!";
        if (waterInMachine < neededWater) {
            throw new IllegalStateException(exceptionMessage.formatted("water"));
        }
        if (milkInMachine < neededMilk) {
            throw new IllegalStateException(exceptionMessage.formatted("milk"));
        }
        if (beansInMachine < neededBeans) {
            throw new IllegalStateException(exceptionMessage.formatted("coffee beans"));
        }
        if (disposableCupsInMachine < 1) {
            throw new IllegalStateException(exceptionMessage.formatted("disposable cups"));
        }
    }

}