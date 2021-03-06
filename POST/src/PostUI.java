
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael Santer
 * 
 * PostUI handles all user interfacing. Communicates between Manager and Post. 
 */
public class PostUI {
    private Manager manager;
    private Post post;
    
    public PostUI(Manager manager){
        this.manager = manager;
    }
    
    /**
     * 
     * @param manager 
     */
    public void run(Manager manager){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Welcome to the point of sale terminal (POST)!");
        
        //Get name of store and ask manager to open store and init post. 
        System.out.print("Please enter the name of the store: ");
        try {
            manager.openStore(in.nextLine());
            manager.initPost();
            post = manager.getPost();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        //Get name of product catalog and ask manager to initialize it. 
        System.out.print("Please enter name of Product Catalog file: ");
        manager.setupProductCatalog(in.nextLine());
        

        while(true){ 
            // (create useful condition eventually)
            
            //get transaction file
            System.out.print("Please enter a transaction filename: "); 
            String transactFile = in.nextLine();
            
            /*Request Customer class to get transactions from file.
            *An available post is sent so that the customer can pass off the
            *transaction to the post for processing. */
            try {
            Customer.getTransactions(transactFile, post);
            } catch (FileNotFoundException ex) {
                System.out.println("File was not found!");
            } catch (IOException ex) {
                System.out.println("Error reading file. Check file format.");
            }
        
        }
    } 
}
