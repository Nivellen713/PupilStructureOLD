package CommandLineWork;

import DataProcessing.StudentService;
import Structures.Person;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CommandLineIO implements ICommand {

    StudentService studentService;

    public CommandLineIO(StudentService studentService) {
        this.studentService = studentService;
    }

    public void inputUserCommand(){
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            userInputHandler(bufferedReader.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void userInputHandler(String userInput){
        String[] userInputParameters = userInput.split("\\u0020");
        switch (userInputParameters[0]) {
            case "ar" -> System.out.println(
                    getAverageRatingByGroup(
                            Integer.parseInt(
                                    userInputParameters[1])));
            case "eo" -> System.out.println(
                    Arrays.toString(
                            getExcellentOlder(
                                    Integer.parseInt(
                                            userInputParameters[1]))));
            case "ln" -> System.out.println(
                    Arrays.toString(
                            getByLastName(
                                    userInputParameters[1])));
            default -> System.out.println("Command not found");
        }
    }

    @Override
    public double getAverageRatingByGroup(int groupNum) {
        return studentService.getClassroomDataGroups().getAverageRating(groupNum);
    }

    @Override
    public Person[] getExcellentOlder(int age) {
        return studentService.getPersonAgeDataGroups().getExcellentOlderThan(age);
    }

    @Override
    public Person[] getByLastName(String lastName) {
        return studentService.getPersonNameDataGroup().getByLastName(lastName);
    }
}
