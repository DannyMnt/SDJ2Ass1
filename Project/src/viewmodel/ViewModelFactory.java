package viewmodel;

import model.Model;

public class ViewModelFactory {
    private Model model;
    private LibraryViewModel libraryViewModel;
    private BorrowViewModel borrowViewModel;

    public ViewModelFactory(Model model){
        this.model = model;
        libraryViewModel = new LibraryViewModel(model);
        borrowViewModel = new BorrowViewModel(model);
    }

    public LibraryViewModel getLibraryViewModel() {
        return libraryViewModel;
    }

    public BorrowViewModel getBorrowViewModel() {
        return borrowViewModel;
    }
}
