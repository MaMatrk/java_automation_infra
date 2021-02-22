package enums;

public enum UserData {
    First_Name("First Name"),
    Last_Name("Last Name"),
    Email_Address("testemail@gmail.com"),
    Password("qwerasdf1234!"),
    Phone("0509997745"),
    City("London"),
    Company("Company"),
    Address("Address"),
    Post_Code("12345"),
    Country("United Kingdom"),
    Region_State("Bedfordshire");


    private String data;

    UserData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
