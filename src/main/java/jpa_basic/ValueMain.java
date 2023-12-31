package jpa_basic;

public class ValueMain {

    public static void main(String[] args) {

        int a = 10;
        int b = 10;

        System.out.println("(a == b) = " + (a == b)); // true

        Address address1 = new Address("city", "street", "1000");
        Address address2 = new Address("city", "street", "1000");
        System.out.println("(address1 == address2) = " + (address1 == address2)); // false
        System.out.println("(address1 equals address2) = " + (address1.equals(address2))); // address 클래스 메서드 추가 하면 true
    }
}
