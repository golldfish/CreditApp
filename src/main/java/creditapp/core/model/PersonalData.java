package creditapp.core.model;

public class PersonalData {
    private final String name;
    private final String lastName;
    private final String mothersMaidenName;
    private final MaritalStatus martialStatus;
    private final Education education;
    private final int numberOfFamilyDependents;

    public PersonalData(String name, String lastName, String mothersMaidenName, MaritalStatus martialStatus, Education education, int numberOfFamilyDependents) {
        this.name = name;
        this.lastName = lastName;
        this.mothersMaidenName = mothersMaidenName;
        this.martialStatus = martialStatus;
        this.education = education;
        this.numberOfFamilyDependents = numberOfFamilyDependents;
    }


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public MaritalStatus getMartialStatus() {
        return martialStatus;
    }

    public Education getEducation() {
        return education;
    }

    public int getNumberOfFamilyDependents() {
        return numberOfFamilyDependents;
    }
}
