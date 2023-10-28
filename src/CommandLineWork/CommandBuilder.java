package CommandLineWork;

import DataProcessing.DataLoader;
import DataProcessing.StudentService;
import Structures.Person;

// 6) Написать CommandBuilder, который зависит от StudentService и умеет создавать конкретные команды (классы,
// реализующие интерфейс Command и обрабатывающие консольные команды).
public class CommandBuilder implements ICommand{
    StudentService studentService = new StudentService(new DataLoader());

    public void getResultByUserCommand(){
        new CommandLineIO(studentService).inputUserCommand();
    }

    @Override
    public double getAverageRatingByGroup(int groupNum) {
        return new CommandLineIO(studentService).getAverageRatingByGroup(groupNum);
    }

    @Override
    public Person[] getExcellentOlder(int age) {
        return new CommandLineIO(studentService).getExcellentOlder(age);
    }

    @Override
    public Person[] getByLastName(String lastName) {
        return new CommandLineIO(studentService).getByLastName(lastName);
    }
}
