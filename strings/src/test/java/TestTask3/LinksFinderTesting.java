package TestTask3;


import static task3.LinksFinder.*;

public class LinksFinderTesting {
    public static void main(String[] args) {

        findLinksInTheMiddle().forEach(System.out::println);
        findLinksInTheEnd().forEach(System.out::println);
    }
}
