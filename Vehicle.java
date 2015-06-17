import java.util.Scanner;

/**
 * Created by paljinda on 5/11/2015.
 */
public class Vehicle {
    public String make;
    public String model;
    public String registrationNumber;
    public int seat;
    public int transmission;
    public int wheel;
    public String startMode;
    public String color;
    public double speedLimit;
    public enum Behaviour { startV , stopV};
    public int speed;
    Behaviour behaviour;
    public String warehouse;


    public Vehicle() {
        this.behaviour = Behaviour.stopV;
    }

    public void insert ()
    {

        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter warehouse");
        warehouse = user_input.next();
        System.out.println("Enter make");
        make = user_input.next();
        System.out.println("Enter model");
        model = user_input.next();
        System.out.println("Enter Regisatartion number");
        registrationNumber = user_input.next();
        System.out.println("Enter seat");
        seat = user_input.nextInt();
        System.out.println("Enter transmission");
        transmission = user_input.nextInt();
        System.out.println("Enter wheel");
        wheel = user_input.nextInt();
        System.out.println("Enter start mode");
        startMode = user_input.next();
        System.out.println("Enter color");
        color = user_input.next();
        System.out.println("Enter speed limit");
        speedLimit = user_input.nextInt();
        speed = 0;
    }

    public void display()
    {
        System.out.println("Warehouse " +warehouse);
        System.out.println("Make: "+make);
        System.out.println("Model: " +model);
        System.out.println("registration number: " +registrationNumber);
        System.out.println("seat: " +seat);
        System.out.println("transmission: " +transmission);
        System.out.println("Wheel: " +wheel);
        System.out.println("Start mode: " +startMode);
        System.out.println("color: " +color);
        System.out.println("Speed limit: " +speedLimit);

    }

    public void start() {
        if (behaviour == Behaviour.stopV)
        {
            behaviour = Behaviour.startV;
        }
    }

    public void stop() {
        if (behaviour == Behaviour.startV)
        {
            behaviour = Behaviour.stopV;
        }
    }

    public void accelerate (int km)
    {
        speed = km;
    }
}
