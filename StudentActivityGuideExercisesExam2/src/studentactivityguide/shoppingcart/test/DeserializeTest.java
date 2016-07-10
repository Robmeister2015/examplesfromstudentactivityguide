package studentactivityguide.shoppingcart.test;

import studentactivityguide.shoppingcart.domain.Item;
import studentactivityguide.shoppingcart.domain.ShoppingCart;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.List;

public class DeserializeTest {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        String directory = "./"; // project home directory
//        String directory = "D:\\labs\\10-IO_Fundamentals\\practices\\";
        String cartId = null;
        System.out.println("Enter the ID of the cart file to deserialize or q exit.");
        // Wrap the System.in InputStream with a BufferedReader to read
        // each line from the keyboard.
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            cartId = in.readLine();
            if (cartId.equals("q")) {
                System.exit(0);
            }
        } catch (IOException e) { // Catch any IO exceptions.
            System.out.println("Exception: " + e);
            System.exit(-1);
        }

        // Attempt to open the file and deserialize it into an object
        String cartFile = directory + "cart" + cartId + ".ser";
        ShoppingCart cart = null;
        try(FileInputStream fis = new FileInputStream(cartFile); ObjectInputStream ois =
        		new ObjectInputStream(fis)){
        ShoppingCart c = (ShoppingCart) ois.readObject();
        System.out.println(c.getCartID());
        System.out.println(c.getCartSize());
        System.out.println(c.getCartTotal());
        List<Item> items = c.getItems();
        
        for(Item i : items){
        	System.out.println(i.getId());
        	System.out.println(i.getDescription());
        	System.out.println(i.getCost());
        }
        }catch(IOException e){
        	System.out.println("Failed to deserialize object");
        }
        
    }
}