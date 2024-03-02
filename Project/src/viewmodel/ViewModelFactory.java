package viewmodel;

import model.Model;

public class ViewModelFactory {

//    private LibraryViewModel libraryViewModel;
//    private BorrowViewModel borrowViewModel;

    private ListVinylViewModel listVinylViewModel;

    private ManageVinylViewModel manageVinylViewModel;


    public ViewModelFactory(Model model){
        ViewModelState viewModelState = new ViewModelState();
        listVinylViewModel = new ListVinylViewModel(model, viewModelState);
        manageVinylViewModel = new ManageVinylViewModel(model, viewModelState);
    }

    public ListVinylViewModel getListVinylViewModel() {
        return listVinylViewModel;
    }

    public ManageVinylViewModel getManageVinylViewModel() {
        return manageVinylViewModel;
    }
}
