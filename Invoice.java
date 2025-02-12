import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private Customer customer;
    private List<Service> ServiceList;
    private double totalAmount;

    public Invoice(Customer customer) {
        this.customer = customer;
        ServiceList = new ArrayList<>();
        this.totalAmount = 0;
    }

    public void addServices(Service service)
    {
        ServiceList.add(service);
        totalAmount+= service.getPrice();
    }

    public void printInvoice()
    {
        System.out.println("----------Invoice----------");
        System.out.println();
        System.out.println("Customer: "+customer.getName()+ " | Phone: "+ customer.getPhone()+ " | Car Model: "
        + customer.getCar().getModel()+ " | Car Number: "+ customer.getCar().getCarNumber());
        System.out.println("Services:");
        for(int i=0; i<ServiceList.size();i++)
        {
            System.out.println(i+1+" "+ ServiceList.get(i).getName()+ ": $"+ ServiceList.get(i).getPrice());
        }
        for(Service service:ServiceList)
        {

        }
        System.out.println("Total Amount: $"+totalAmount);
        System.out.println();
        System.out.println("-----------------Thank You Visit Again--------------------");
    }
}
