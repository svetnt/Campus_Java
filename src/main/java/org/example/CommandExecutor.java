package org.example;

import java.util.Scanner;

public class CommandExecutor {
    Scanner input = new Scanner(System.in);
    CoffeeMachine coffeeMachine = new CoffeeMachine();
    Coffee java = new Coffee("Java", Type.GROUND);
    Coffee buchido = new Coffee("Buchido", Type.BEANS);

    public void start() {
        String command = "";
        do {
            System.out.println("Введите команду.  Возможные команды:  Приготовить напиток, Добавить воды,  Добавить кофе,  Exit");
            command = input.nextLine();
            commandReader(command);
        } while (!command.equals("Exit"));
    }

    public void commandReader(String command) {

        switch (command) {
            case "Приготовить напиток":
                makCoffeeCommand();
                break;
            case "Добавить воды":
                addWaterCommand();
                break;
            case "Добавить кофе":
                addCoffeeCommand();
                break;
            case "Exit":
                System.exit(0);
            default:
                System.out.println("Некорректный ввод");
                System.exit(1);
        }
    }

    public void makCoffeeCommand() {
        InputInfo inputInfo = new InputInfo();
        System.out.println("Выберите желаемую крепость: введите М - для выбора MILD,  введите N - для выбора NORMAL, " +
                "введите S - для выбора STRONG");
        switch (input.nextLine()) {
            case "M":
                inputInfo.level = StrongLevel.MILD;
                break;
            case "N":
                inputInfo.level = StrongLevel.NORMAL;
                break;
            case "S":
                inputInfo.level = StrongLevel.STRONG;
                break;
            default:
                System.out.println("Некорректный ввод");
                System.exit(1);
        }

        System.out.println("Введите объем чашки в мл (от 10 до 300) ");
        int inputSize = Integer.parseInt(input.nextLine());
        if (inputSize >= 10 && inputSize <= 300) {
            inputInfo.sizeCup = inputSize;
        } else {
            System.out.println("Некорректный ввод");
            System.exit(1);
        }

        System.out.println("Выберите желаемый тип кофе. Введите 1 - для выбора кофе в зернах,  2 - для выбора молотого кофе");
        switch (input.nextLine()) {
            case "1":
                inputInfo.type = Type.BEANS;
                break;
            case "2":
                inputInfo.type = Type.GROUND;
                break;
            default:
                System.out.println("Некорректный ввод");
                System.exit(1);
        }

        coffeeMachine.makeCoffee(inputInfo.level, inputInfo.sizeCup, inputInfo.type);
    }

    public void addWaterCommand() {
        System.out.println("Какой объем воды хотите добавить?");
        String water = input.nextLine();
        coffeeMachine.addWater(Integer.parseInt(water));
    }

    public void addCoffeeCommand() {
        InputInfo addCoffeInfo = new InputInfo();
        System.out.printf("Выберите тип добавляемого кофе. Для добавления %s введите 1,  для добавления %s введите 2\n",
                java.getCoffeeName(), buchido.getCoffeeName());
        switch (input.nextLine()) {
            case "1":
                addCoffeInfo.coffee = java;
                break;
            case "2":
                addCoffeInfo.coffee = buchido;
                break;
            default:
                System.out.println("Некорректный ввод");
                System.exit(1);
        }
        System.out.println("Сколько кофе хотите добавить?");
        addCoffeInfo.addCoffee = Double.parseDouble(input.nextLine());
    }
}
