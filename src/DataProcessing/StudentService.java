package DataProcessing;

import DataGroups.ClassroomDataGroups;
import DataGroups.PersonAgeDataGroups;
import DataGroups.PersonNameDataGroup;

public class StudentService {
    PersonAgeDataGroups personAgeDataGroups = new PersonAgeDataGroups();
    ClassroomDataGroups classroomDataGroups = new ClassroomDataGroups();
    PersonNameDataGroup personNameDataGroup = new PersonNameDataGroup();

    public StudentService(IDataLoader dataLoader) {
        dataLoader.addAllPerson(personAgeDataGroups);
        dataLoader.addAllPerson(classroomDataGroups);
        dataLoader.addAllPerson(personNameDataGroup);
    }

    public PersonAgeDataGroups getPersonAgeDataGroups() {
        return personAgeDataGroups;
    }

    public ClassroomDataGroups getClassroomDataGroups() {
        return classroomDataGroups;
    }

    public PersonNameDataGroup getPersonNameDataGroup() {
        return personNameDataGroup;
    }
}
