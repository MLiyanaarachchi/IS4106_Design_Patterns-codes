//Observer design pattern
import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class WeatherStation implements Subject {
    private List<Observer> observers;
    private String weatherData;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    public void setWeatherData(String weatherData) {
        this.weatherData = weatherData;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(weatherData);
        }
    }
}

// Observer interface
interface Observer {
    void update(String weatherData);
}

// Concrete Observer - Display Device
class DisplayDevice implements Observer {
    private String name;

    public DisplayDevice(String name) {
        this.name = name;
    }

    @Override
    public void update(String weatherData) {
        System.out.println(name + " received weather update: " + weatherData);
    }


}
class Display {
    public static void main(String[] args) {
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