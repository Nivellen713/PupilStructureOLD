package CommandLineWork;

import DataProcessing.StudentService;

import java.util.Arrays;

public class ExcellentOlderCommand implements ICommand{
    @Override
    public void execute(StudentService studentService, String parameter) {
        System.out.println(
                Arrays.toString(studentService.getPersonAgeDataGroups().getExcellentOlderThan(
                        Integer.parseInt(parameter))));
    }
}
