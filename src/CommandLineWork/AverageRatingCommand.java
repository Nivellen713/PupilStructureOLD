package CommandLineWork;

import DataProcessing.StudentService;

public class AverageRatingCommand implements ICommand {
    @Override
    public void execute(StudentService studentService, String parameter) {
        System.out.println(
                studentService.getClassroomDataGroups().getAverageRating(
                        Integer.parseInt(parameter)));
    }
}
