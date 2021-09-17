package creditapp.client;

import creditapp.core.model.*;

import javax.xml.transform.Source;
import java.util.Scanner;

public class ConsoleReader {

    public LoanApplication readInputParameters() {
        Scanner input = new Scanner(System.in);

        System.out.println("Input name:");
        String name = input.next();

        System.out.println("Input last name:");
        String lastName = input.next();

        System.out.println("Input mothers maiden name:");
        String mothersMaidenName = input.next();

        System.out.println("Input martial status: (SINGLE, MARRIED, DIVORCED, WIDOWED, SEPARATED)");
        MaritalStatus martialStatus = MaritalStatus.valueOf(input.next());

        System.out.println("Input education level: (NONE, PRIMARY, MIDDLE, SECONDARY, POST_SECONDARY, TERTIARY)");
        Education education = Education.valueOf(input.next());

        System.out.println("Input email:");
        String email = input.next();

        System.out.println("Input phone number:");
        String phoneNumber = input.next();

        System.out.println("How many sources of income do you have?");
        int incomeNumber = input.nextInt();

        SourceOfIncome[] sourcesOfIncome = new SourceOfIncome[incomeNumber];
        for (int number = 0; number < incomeNumber; number++) {
            System.out.println("Enter type of source of income" + number + "(EMPLOYMENT_CONTRACT | SELF_EMPLOYMENT | RETIREMENT):");
            IncomeType incomeType = IncomeType.valueOf(input.next());
            System.out.println("Enter net monthly income of source of income" + number + ":");
            double netMonthlyIncome = input.nextDouble();

            SourceOfIncome sourceOfIncome = new SourceOfIncome(incomeType, netMonthlyIncome);
            sourcesOfIncome[number] = sourceOfIncome;

        }

        System.out.println("Input total monthly income in PLN:");
        double totalMonthlyIncomeInPln = input.nextDouble();

        System.out.println("Input number of family dependents:");
        int numberOfFamilyDependents = input.nextInt();

        System.out.println("Input purpose of loan: (MORTGAGE, PERSONAL_LOAN)");
        LoanType loanType = LoanType.valueOf(input.next());

        System.out.println("Input loan amount:");
        int loanAmount = input.nextInt();

        System.out.println("Input period amount:");
        byte period = input.nextByte();

        PersonalData personalData = new PersonalData(name, lastName, mothersMaidenName, martialStatus, education, numberOfFamilyDependents);
        ContactData contactData = new ContactData(email, phoneNumber);
        FinanceData financeData = new FinanceData(sourcesOfIncome);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(loanType, loanAmount, period);

        return new

                LoanApplication(new Person(personalData, contactData, financeData), purposeOfLoan);

    }
}
