package DataGroups;

import Structures.Person;

// 2) Выделить Функциональный интерфейс GroupCriterion, который по person будет определять ключ группы (ну и
// реализовать три варианта, по возрасту, фамилии и классу)
@FunctionalInterface
public interface IGroupCriterion {
    int getKey(Person person);
}
