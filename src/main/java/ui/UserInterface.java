package ui;

import enums.*;
import model.*;
import receipt.ReceiptWriter;
import toppings.*;

public class UserInterface {
    private Console console = new Console();
    private Order currentOrder;

    public void display() {
        printLogo();

        boolean running = true;

        while (running) {
            System.out.println(ConsoleColors.CYAN + "\n=========== MAIN MENU ===========" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "1) New Order");
            System.out.println(ConsoleColors.RED + "0) Exit" + ConsoleColors.RESET);

            int choice = console.readIntInRange(0, 1);

            switch (choice) {
                case 1:
                    startOrder();
                    break;
                case 0:
                    System.out.println(ConsoleColors.YELLOW + "\nThanks for visiting El Loco Taco!" + ConsoleColors.RESET);
                    running = false;
                    break;
            }
        }
    }

    private void printLogo() {
        System.out.println(ConsoleColors.YELLOW + ConsoleColors.BOLD);
        System.out.println("========== EL LOCO TACO ==========");
        System.out.println(ConsoleColors.GREEN + "Fresh • Fast • Fully Custom" + ConsoleColors.RESET);
    }

    private void startOrder() {
        currentOrder = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println(ConsoleColors.PURPLE + "\n========== ORDER MENU ==========" + ConsoleColors.RESET);
            System.out.println("1) Add Taco");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips & Salsa");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            int choice = console.readIntInRange(0, 4);

            switch (choice) {
                case 1:
                    addTaco();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    if (checkout()) {
                        ordering = false;
                    }
                    break;
                case 0:
                    System.out.println(ConsoleColors.RED + "\nOrder canceled." + ConsoleColors.RESET);
                    ordering = false;
                    break;
            }
        }
    }

    private void addTaco() {
        System.out.println(ConsoleColors.YELLOW + "\n========== ADD TACO ==========" + ConsoleColors.RESET);

        System.out.println("Select shell:");
        System.out.println("1) Corn");
        System.out.println("2) Flour");
        System.out.println("3) Hard Shell");
        System.out.println("4) Bowl");
        int shellChoice = console.readIntInRange(1, 4);
        ShellType shell = ShellType.values()[shellChoice - 1];

        System.out.println("\nSelect size:");
        System.out.println("1) Single Taco");
        System.out.println("2) 3-Taco Plate");
        System.out.println("3) Burrito");
        int sizeChoice = console.readIntInRange(1, 3);
        TacoSize size = TacoSize.values()[sizeChoice - 1];

        Taco taco = new Taco(size, shell);

        System.out.println("\nSelect meat:");
        MeatType[] meats = MeatType.values();
        for (int i = 0; i < meats.length; i++) {
            System.out.println((i + 1) + ") " + meats[i]);
        }
        int meatChoice = console.readIntInRange(1, meats.length);
        System.out.println("Extra meat? (y/n)");
        boolean extraMeat = console.readYesNo();
        taco.addTopping(new Meat(meats[meatChoice - 1], extraMeat));

        System.out.println("\nSelect cheese:");
        CheeseType[] cheeses = CheeseType.values();
        for (int i = 0; i < cheeses.length; i++) {
            System.out.println((i + 1) + ") " + cheeses[i]);
        }
        int cheeseChoice = console.readIntInRange(1, cheeses.length);
        System.out.println("Extra cheese? (y/n)");
        boolean extraCheese = console.readYesNo();
        taco.addTopping(new Cheese(cheeses[cheeseChoice - 1], extraCheese));

        addRegularToppings(taco);
        addSauces(taco);

        System.out.println("Cover with salsa and queso? (y/n)");
        taco.setCovered(console.readYesNo());

        currentOrder.addItem(taco);
        System.out.println(ConsoleColors.GREEN + "\nTaco added!" + ConsoleColors.RESET);
    }

    private void addRegularToppings(Taco taco) {
        RegularToppingType[] regularToppings = RegularToppingType.values();
        boolean adding = true;

        while (adding) {
            System.out.println("\nSelect regular topping:");
            for (int i = 0; i < regularToppings.length; i++) {
                System.out.println((i + 1) + ") " + regularToppings[i]);
            }
            System.out.println("0) Done");

            int choice = console.readIntInRange(0, regularToppings.length);

            if (choice == 0) {
                adding = false;
            } else {
                taco.addTopping(new RegularTopping(regularToppings[choice - 1]));
                System.out.println("Add another regular topping? (y/n)");
                adding = console.readYesNo();
            }
        }
    }

    private void addSauces(Taco taco) {
        SauceType[] sauces = SauceType.values();
        boolean adding = true;

        while (adding) {
            System.out.println("\nSelect sauce:");
            for (int i = 0; i < sauces.length; i++) {
                System.out.println((i + 1) + ") " + sauces[i]);
            }
            System.out.println("0) Done");

            int choice = console.readIntInRange(0, sauces.length);

            if (choice == 0) {
                adding = false;
            } else {
                taco.addSauce(sauces[choice - 1]);
                System.out.println("Add another sauce? (y/n)");
                adding = console.readYesNo();
            }
        }
    }

    private void addDrink() {
        System.out.println(ConsoleColors.BLUE + "\n========== ADD DRINK ==========" + ConsoleColors.RESET);
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");

        int choice = console.readIntInRange(1, 3);
        DrinkSize size = DrinkSize.values()[choice - 1];

        System.out.println("Enter flavor:");
        String flavor = console.readString();

        currentOrder.addItem(new Drink(size, flavor));
        System.out.println(ConsoleColors.GREEN + "\nDrink added!" + ConsoleColors.RESET);
    }

    private void addChips() {
        System.out.println(ConsoleColors.YELLOW + "\n======= CHIPS & SALSA =======" + ConsoleColors.RESET);
        System.out.println("1) Salsa Verde");
        System.out.println("2) Salsa Roja");
        System.out.println("3) Chipotle");
        System.out.println("4) Habanero");
        System.out.println("5) Mild");
        System.out.println("6) Extra Hot");

        int choice = console.readIntInRange(1, 6);
        SauceType salsa = SauceType.values()[choice - 1];

        currentOrder.addItem(new ChipsAndSalsa(salsa));
        System.out.println(ConsoleColors.GREEN + "\nChips & Salsa added!" + ConsoleColors.RESET);
    }

    private boolean checkout() {
        if (!currentOrder.isValidOrder()) {
            System.out.println(ConsoleColors.RED + "\nInvalid order. Add at least one taco, drink, or chips & salsa." + ConsoleColors.RESET);
            return false;
        }

        System.out.println(ConsoleColors.YELLOW);
        System.out.println(currentOrder.getSummary());
        System.out.println(ConsoleColors.RESET);
        System.out.println("\nConfirm order? (y/n)");

        if (console.readYesNo()) {
            ReceiptWriter.saveReceipt(currentOrder);
            System.out.println(ConsoleColors.GREEN + "\nOrder completed!" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "\nOrder canceled." + ConsoleColors.RESET);
        }

        return true;
    }
}
