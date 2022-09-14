package com.bank;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
   static Stream<Account> stream=Stream.of(
            new Account("Ram",101,500),
            new Account("Raj",201,1000),
            new Account("Sam",340,3000),
            new Account("Ria",460,987),
            new Account("Renuka",533,2500)
    );
    static Map<Integer,Account> userHashMap=stream.collect(Collectors.toMap(Account::getAccount_number, Function.identity()));

    static Scanner sc=new Scanner(System.in);

    static String Password="Ramteja@777";

    public static void main(String[] args) {


        System.out.println("Welcome to ABC Bank");
        while(true)
        {
            System.out.println("Enter the service you want to use:");
            System.out.println("1.Create Account");
            System.out.println("2.Deposit Amount");
            System.out.println("3.Withdraw amount");
            System.out.println("4.Check Balance");
            System.out.println("6.Exit");

            int choice=sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter name: ");
                    String s = sc.next();
                    System.out.println("Enter account number: ");
                    int accNo = sc.nextInt();
                    System.out.println("Enter amount: ");
                    int amt=sc.nextInt();
                    Account acc = new Account(s, accNo, amt);
                    userHashMap.put(accNo,acc);
                    System.out.println("Account created successfully.");


                }

                case 2 -> {
                    System.out.println("Enter account number: ");
                    int num = sc.nextInt();
                    Account acc=userHashMap.get(num);
                    if(acc==null) {System.out.println("Invalid User");}
                    else {
                        System.out.println("Enter amount to deposit");
                        double depositAmount = sc.nextDouble();


                        acc.deposit(depositAmount);

                        System.out.println("amount " + depositAmount + " successfully deposited");
                    }

                }
                case 3 -> {
                    System.out.println("Enter account number ");
                    int no = sc.nextInt();
                    Account acc=userHashMap.get(no);
                    if(acc==null) {System.out.println("Invalid User");}
                    else {
                        System.out.println("Enter amount to withdraw");
                        double withdrawAmount = sc.nextDouble();

                        if (!(acc.withdraw(withdrawAmount))) {
                            System.out.println("Insufficient Funds " + acc.getName() + " !!!!");
                        } else {
                            System.out.println("Amount " + withdrawAmount + " withdrawn successfully");
                            System.out.println("Remaining balance " + acc.getAmount());
                        }
                    }

                }
                case 4 -> {
                    System.out.println("Enter account number: ");
                    int id = sc.nextInt();
                    Account acc=userHashMap.get(id);
                    if(acc==null) {System.out.println("Invalid User");}
                    else {
                        double balance = acc.getAmount();
                        System.out.println("Your remaining balance is: " + balance);
                    }
                }

                default -> System.exit(0);
            }

        }

    }
}