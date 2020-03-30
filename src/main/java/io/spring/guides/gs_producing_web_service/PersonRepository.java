package io.spring.guides.gs_producing_web_service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PersonRepository {
    private static List<Person> personList = new LinkedList<>();

    @PostConstruct
    public void addPersonsOnInit(){
        Person danil = new Person();
        danil.setId("1");
        danil.setPersonName("Danil");
        danil.setBirthYear(1998);
        personList.add(danil);

        Person serg = new Person();
        serg.setId("2");
        serg.setPersonName("Sergey");
        serg.setBirthYear(1999);
        personList.add(serg);

        Person tanya = new Person();
        tanya.setId("3");
        tanya.setPersonName("Tatyana");
        tanya.setBirthYear(1998);
        personList.add(tanya);
    }

    public Person getPersonById(String id){
        Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()){
            Person cash = iterator.next();
            if(cash.getId().equals(id)){
                return cash;
            }
        }
        return null;
    }

    public Person getPersonByName(String name){
        Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()){
            Person cash = iterator.next();
            if(cash.getPersonName().equals(name)){
                return cash;
            }
        }
        return null;
    }

    public List<Person> getPersonsByYear(int year){
        Iterator<Person> iterator = personList.iterator();
        List<Person> people = new ArrayList<>();
        while (iterator.hasNext()){
            Person cash = iterator.next();
            if(cash.getBirthYear()==year){
                people.add(cash);
            }
        }
        return people;
    }
}
