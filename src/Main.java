// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Application started.");

        Logger anotherLogger = Logger.getInstance();
        anotherLogger.log("Another log message.");

        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        // Add MilkDecorator
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        // Add SugarDecorator
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        // Check if both loggers are the same instance
        WeatherStation weatherStation = new WeatherStation();

        // Create display devices (observers)
        DisplayDevice display1 = new DisplayDevice("Display 1");
        DisplayDevice display2 = new DisplayDevice("Display 2");

        // Add display devices to the weather station
        weatherStation.addObserver(display1);
        weatherStation.addObserver(display2);

        // Simulate weather updates
        weatherStation.setWeatherData("Sunny, 25°C");
        weatherStation.setWeatherData("Rainy, 18°C");

        // Remove a display device and simulate another weather update
        weatherStation.removeObserver(display2);
        weatherStation.setWeatherData("Cloudy, 20°C");
    }
    }
