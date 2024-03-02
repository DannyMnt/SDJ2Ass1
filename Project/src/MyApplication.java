import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import model.ModelManager;
import model.Vinyl;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class MyApplication extends Application
{
    public void start(Stage primaryStage)
    {
        Model model = new ModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler view = new ViewHandler(viewModelFactory);
        view.start(primaryStage);

        String[] titles  = new String[]{"Echoes of the Cosmos","Neon Dreams", "Midnight Serenade", "Lost in the Groove", "Whispers in the Wind","Sands of Time","Jazz Noir","Galactic Odyssey","Rhythms of the Rainforest","Sunset Sonata"};
        String[] artists = new String[]{"Celestial Harmonies","Electric Horizon","Velvet Moonlight","Funky Junction","Mystical Echoes","Desert Nomads","The Midnight Mystics","Cosmic Voyager","Jungle Beats Collective","Twilight Symphony Orchestra"};
        int[] years = new int[]{1978,1985,1963,1972,1991,1982,1957,1979,2003,1968};

        for (int i = 0; i < 10; i++)
        {

            Vinyl newVinyl = new Vinyl(titles[i],artists[i],years[i]);
            System.out.println(newVinyl.toString());
            model.addVinyl(newVinyl);
        }
    }
}
