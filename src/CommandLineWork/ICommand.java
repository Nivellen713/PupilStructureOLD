package CommandLineWork;

import DataProcessing.StudentService;

// 3) Выделить интерфейс Command, наследники которого будет отвечать за обработку конкретных консольных команд.
public interface ICommand {

    void execute(StudentService studentService, String parameter);

}
