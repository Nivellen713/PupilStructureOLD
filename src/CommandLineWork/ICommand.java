package CommandLineWork;

import DataProcessing.StudentService;
public interface ICommand {
    void execute(StudentService studentService, String parameter);

}
