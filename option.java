import java.security.PublicKey;
import java.util.Scanner;
/**
 * Created by paljinda on 5/12/2015.
 */
public class option {

    public static void main(String []args) {
        System.out.println("If want to insert new vehicle enter 1 and for search enter 2");
        Scanner user_input = new Scanner(System.in);
        int x;
        x = user_input.nextInt();
        VehicleStore vehiclestore = new VehicleStore();
        if(x == 1)
        vehiclestore.insert();
        else if(x==2)
        {
            vehiclestore.select();
        }
    }



}
