package model;


import utility.observer.javaobserver.NamedPropertyChangeSubject;

public interface Model extends NamedPropertyChangeSubject
{
    public void reserveVinyl(Vinyl vinyl);
    public void borrowVinyl(Vinyl vinyl);
    public void returnVinyl(Vinyl vinyl);
    public void removeVinyl(Vinyl vinyl);
}
