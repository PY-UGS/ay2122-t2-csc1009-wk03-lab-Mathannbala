//Import the libraries
import java.util.Date;
import java.util.Scanner;

//create class Loan
class Loan{
    //declare the variables
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate = new Date();

    public Loan(){
        this.annualInterestRate = 2.5;
        this.numberOfYears = 1;
        this.loanAmount = 1000;
        this.loanDate = new Date(System.currentTimeMillis());

    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount){
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;

    }

    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }

    public double getLoanAmount(){
        return this.loanAmount;
    }

    public int getNumberOfYears(){
        return this.numberOfYears;
    }

    public Date getLoanDate() {
        return this.loanDate;
    }

    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double principal){
        this.loanAmount = principal;
    }

    public double getMonthlyPayment(){
        //split as numerator and denominator
        double top = this.loanAmount * (this.annualInterestRate/12)/100;
        double bottom = (1 - (1 / (Math.pow((1 + (this.annualInterestRate/12)/100), (this.numberOfYears * 12)))));
        return (top/bottom);
    }
    public double getTotalPayment(){

        return getMonthlyPayment() * numberOfYears *12;

    }
}

class Main{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.print("Enter annual interest rate, for example, 8.25: ");
        double interestRate = input.nextDouble();
        System.out.print("Enter number of years as an integer: ");
        int numberOfYears = input.nextInt();
        System.out.print("Enter loan amount, for example, 120000.95: ");
        double loanAmount = input.nextDouble();
        input.close();

        Loan loan = new Loan(interestRate,numberOfYears,loanAmount);

        System.out.println("The loan was created on "+loan.getLoanDate());

        System.out.printf("The monthly payment is %.2f \n", loan.getMonthlyPayment());
        System.out.printf("The total payment is %.2f", loan.getTotalPayment());
    }
}