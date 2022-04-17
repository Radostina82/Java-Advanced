package DefiningClasses.Exercises.FamilyTree8;

public class Person {
    private String personName;
    private String personBirthDay;


    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPersonBirthDay(String personBirthDay) {
        this.personBirthDay = personBirthDay;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonBirthDay() {
        return personBirthDay;
    }
    @Override
    public String toString(){
        return this.personName + " " + this.personBirthDay;
    }
}
