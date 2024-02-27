package viewmodel;

import model.Model;

public class ViewModelFactory {
    private Model model;
    private LibraryViewModel libraryViewModel;
    private ReturnViewModel returnViewModel;
    private BorrowViewModel borrowViewModel;

    public ViewModelFactory(Model model){
        this.model = model;
        libraryViewModel = new LibraryViewModel(model);
        borrowViewModel = new BorrowViewModel(model);
        returnViewModel = new ReturnViewModel(model);
    }

    public LibraryViewModel getLibraryViewModel() {
        return libraryViewModel;
    }

    public BorrowViewModel getBorrowViewModel() {
        return borrowViewModel;
    }

    public ReturnViewModel getReturnViewModel() {
        return returnViewModel;
    }
}
