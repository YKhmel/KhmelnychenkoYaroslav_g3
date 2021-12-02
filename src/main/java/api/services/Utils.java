package api.services;

public class Utils {

    public static PeopleApiServices peopleApiServices = new PeopleApiServices("/");

    public static void resetSession(){
        peopleApiServices.resetRestAssured();
        peopleApiServices = PeopleApiServices.getInstance();
    }
}