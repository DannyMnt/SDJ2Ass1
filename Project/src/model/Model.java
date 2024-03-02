package model;


import utility.observer.javaobserver.NamedPropertyChangeSubject;

public interface Model extends NamedPropertyChangeSubject
{
    public void reserveVinyl(String name, int id);
    public void borrowVinyl(String name, int id);
}
