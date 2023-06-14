package FinanceHub;

public class financeHub {
    double calcbalWithoutMonthlyDep(double intVest, double intRate, double numYears){
        double intNum = intRate/100;
        double yearEndBal = 0.00;
        double intEarned;

        if(numYears == 0){
            //do something
        }
        else{
            double n = 0.00; // place holder value
            for(int i = 0; i < numYears; i++){
                final double pow = Math.pow((1 + intNum / 12), (12 * i));
                if(i < 2){
                    yearEndBal = intVest * pow;
                    intEarned = (yearEndBal - n) - intVest;
                    n = intEarned;
                }
                else{
                    yearEndBal = intVest * pow;
                    intEarned = (yearEndBal - n) - intVest;
                    n = yearEndBal - intVest;
                }
            }
        }
        return yearEndBal;
    }

    double calcbalWithMonthlyDep(double intVest,double monthDep, double intRate, int numYears){
        double endingBal = intVest;
        double interest = intRate/100;
        double intEarned;
        double finialInt;
        double yearDep = monthDep * 12;
        int months = numYears * 12;

        if(numYears == 0){
            //do something
        }
        else{
            for( int i = 0; i < months; i++){
                intEarned = endingBal * ( interest / 12);
                endingBal += intEarned;
                endingBal += monthDep;

                if(i % 12 == 0){
                    finialInt = endingBal - intVest - yearDep;
                    intVest = endingBal;
                }
            }
        }
        return endingBal;
    }
}
