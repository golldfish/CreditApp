package creditapp.core.model;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTestFactory {

    public static Person create(double totalMonthlyIncomeInPln, int numOfDependants, Education education, MaritalStatus maritalStatus) {
        PersonalData personalData = new PersonalData("name", "lastName", "mothersMaidenName", maritalStatus, education, numOfDependants);
        return new Person(personalData, null, null);
    }

    public static Person create() {
        PersonalData personalData = new PersonalData("test", "test", "test", MaritalStatus.SINGLE, Education.MIDDLE, 2);
        return new Person(personalData, null, null);
    }

    public static Person create(Education education) {
        PersonalData personalData = new PersonalData("test", "test", "test", MaritalStatus.SINGLE, education, 2);
        return new Person(personalData, null, null);
    }

    public static Person create(MaritalStatus maritalStatus) {
        PersonalData personalData = new PersonalData("test", "test", "test", maritalStatus, Education.PRIMARY, 2);
        return new Person(personalData, null, null);
    }

    public static Person create(int numberOfFamilyDependents, SourceOfIncome... sourceOfIncomes) {
        PersonalData personalData = new PersonalData("test", "test", "test", MaritalStatus.SINGLE, Education.MIDDLE, numberOfFamilyDependents);
        return new Person(personalData, null, new FinanceData(sourceOfIncomes));
    }

}