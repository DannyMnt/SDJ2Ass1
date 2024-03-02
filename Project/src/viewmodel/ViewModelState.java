package viewmodel;

import java.util.UUID;

public class ViewModelState {
    private UUID id;
    private boolean remove;

    private String state;
    public ViewModelState(){
        this.id = null;
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

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }


    public void removeNumber()
    {
        this.id = null;
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
