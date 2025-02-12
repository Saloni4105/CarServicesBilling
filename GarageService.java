import java.util.*;

public class GarageService {

    private Map<String, Customer> customerMap;
    private List<Service> availableService;

    public GarageService() {
        this.customerMap = new HashMap<>();
        this.availableService = new ArrayList<>();
        loadServices();
    }

    public void loadServices()
    {
        availableService.add(new Service( "Car Wash", 500));
        availableService.add(new Service("Oil Change", 700));
        availableService.add(new Service("Wheel Alignment", 300));
        availableService.add(new Service("Tyre Replacement", 3000));
        availableService.add(new Service("Puncture", 50));
    }

    public void addCustomer(String name, String phone, String carNumber, String model)
    {
        Car car= new Car(carNumber,model);
        Customer customer= new Customer(name,phone,car);
        customerMap.put(carNumber, customer);
        System.out.println("Customer added successfully!");
    }

    public void createInvoice(String carNumber)
    {
        if(!customerMap.containsKey(carNumber))
        {
            System.out.println("No customer found with this car number: "+ carNumber);
            return;
        }
        Scanner sc= new Scanner(System.in);
        Customer customer= customerMap.get(carNumber);
        Invoice invoice = new Invoice(customer);
        System.out.println("Available Services:");
        for(int i=0;i<availableService.size();i++)
        {
            System.out.println((i+1)+ ". "+availableService.get(i).getName()+ " - $"+ availableService.get(i).getPrice());
        }
        while (true)
        {
            System.out.println("Enter service number to add or 0 to finish:");
            int choice= sc.nextInt();
            if(choice==0) break;
            if(choice>0 && choice<= availableService.size())
            {
                invoice.addServices(availableService.get(choice-1));
                System.out.println("Service Done...");
            }
            else {
                System.out.println("Invalid Choice");
            }
        }
        invoice.printInvoice();
    }
}
