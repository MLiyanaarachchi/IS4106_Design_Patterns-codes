//Decorator design pattern

// Component Interface
public interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 10.00;
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Concrete Decorator 1: MilkDecorator
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 30.00;
    }
}

// Concrete Decorator 2: SugarDecorator
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 5.00;
    }
}

// Main class to test the decorators
class output {
    public static void main(String[] args) {
        // Create a SimpleCoffee object
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " Rs " + coffee.getCost());

        // Add MilkDecorator
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " Rs " + coffee.getCost());

        // Add SugarDecorator
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " Rs " + coffee.getCost());
    }
}
