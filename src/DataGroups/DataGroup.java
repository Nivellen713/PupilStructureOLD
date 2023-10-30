package DataGroups;

import Structures.Person;

//1) Выделить один класс DataGroup, которые в качестве аргумента принимает лямбду, которая по конкретному
//объекту person определяет к какой группе он относиться. Таким образом будет реализован open-close принцип(
//реализации какой-либо еще группировки достаточно написать нужную лямбду, а класс DataGroup при этом никак не
//меняется).
public class DataGroup {

    public int getGroupKey(Person person, IGroupCriterion groupCriterion){
        return groupCriterion.getKey(person);

    }
}
