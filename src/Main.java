import CommandLineWork.CommandBuilder;

public class Main {
    // ar groupNum - возвращает среднюю оценку (ar - average rating) учеников "groupNum" группы
    // eo age - возвращает отличников старше (eo - excellent older) возраста "age"
    // ln lastName - возвращает учеников с фамилией (ln -lastname) "lastName"
    public static void main(String[] args) {
        new CommandBuilder().inputUserCommand();
    }
}