package com.bank;

public class Account  {
    String name;
    int account_number;
    double amount;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "acc_num=" + account_number +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }

    public int getAccount_number() {
        return account_number;
    }

    public double getAmount() {
        return amount;
    }

    public Account(String name, int account_number, double amount) {
       this.name=name;
       this.account_number=account_number;
       this.amount=amount;

    }
    public void deposit(double amount)
    {
        this.amount+=amount;
    }
    public boolean withdraw(double amt)
    {
        if(amount<amt)return false;
        else this.amount-=amt;
        return true;
    }





}

//    @Override
//    public <T> T[] toArray(IntFunction<T[]> generator) {
//        return super.toArray(generator);

//    }
