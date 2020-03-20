package hello.itay.com.demo5;

/**
 * Created by Itay kan on 3/18/2020.
 */

public class Flight {
    public Flight(String Id, String Company,String Origin, int ImageResourceId)
    {
        this.Id = Id;
        this.Company = Company;
        this.Origin = Origin;
        this.ImageResourceId = ImageResourceId;
    }
    public String Id;
    public String Company;
    public String Origin;
    public int ImageResourceId;

    @Override
    public String toString() {
        return "Flight Id: " + Id.toString() + " Company: " + Company + " From: " + Origin + " ";
    }
}
