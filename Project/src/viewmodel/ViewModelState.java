package viewmodel;

public class ViewModelState {
    private int number;
    private boolean remove;

    private String state;
    public ViewModelState(){
        this.number = -1;
        this.remove = false;
        this.state = null;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }


    public void removeNumber()
    {
        this.number = -1;
    }

    public boolean isRemove()
    {
        return remove;
    }

    public void setRemove(boolean remove)
    {
        this.remove = remove;
    }
}
