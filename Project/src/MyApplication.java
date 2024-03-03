import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import model.ModelManager;
import model.Vinyl;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class MyApplication extends Application
{
    public void start(Stage primaryStage)
    {
        String[] titles  = new String[]{"Echoes of the Cosmos","Neon Dreams", "Midnight Serenade", "Lost in the Groove", "Whispers in the Wind","Sands of Time","Jazz Noir","Galactic Odyssey","Rhythms of the Rainforest","Sunset Sonata"};
        String[] artists = new String[]{"Celestial Harmonies","Electric Horizon","Velvet Moonlight","Funky Junction","Mystical Echoes","Desert Nomads","The Midnight Mystics","Cosmic Voyager","Jungle Beats Collective","Twilight Symphony Orchestra"};
        String[] years = new String[]{"1978","1985","1963","1972","1991","1982","1957","1979","2003","1968"};

        ArrayList<Vinyl> vinyls = new ArrayList<Vinyl>();

        for (int i = 0; i < 10; i++)
        {

            Vinyl newVinyl = new Vinyl(titles[i],artists[i],years[i]);
            System.out.println(newVinyl.toString());
            vinyls.add(newVinyl);
        }



        Model model = new ModelManager(vinyls);
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler view = new ViewHandler(viewModelFactory);
        view.start(primaryStage);

        Thread bobThread = new Thread(() -> {
           while(true){
               Random random = new Random();
               int choice = random.nextInt(5);
               int vinylChoice = random.nextInt(10);
               switch (choice) {
                   case 0:
                       model.getAllVinyls().get(vinylChoice).borrowVinyl();
                       System.out.println("Bob is borrowing");
                       System.out.println(model.getAllVinyls().get(vinylChoice).getVinylState().toString());
                       break;
                   case 1:
                       model.getAllVinyls().get(vinylChoice).reserveVinyl();
                       System.out.println("Bob is reserving");
                       System.out.println(model.getAllVinyls().get(vinylChoice).getVinylState().toString());
                       break;
                   case 2:
                       model.getAllVinyls().get(vinylChoice).returnVinyl();
                       System.out.println("Bob is returning");
                       System.out.println(model.getAllVinyls().get(vinylChoice).getVinylState().toString());
                       break;
                   case 3:
                       model.getAllVinyls().get(vinylChoice).removeVinyl();
                       System.out.println("Bob is removing");
                       System.out.println(model.getAllVinyls().get(vinylChoice).getVinylState().toString());
                       break;
//                   case 4:
//                       model.getAllVinyls().get(vinylChoice).borrowAndReserveVinyl();
//                       System.out.println("Bob is borrowing and reserving");
//                       System.out.println(model.getAllVinyls().get(vinylChoice).getVinylState().toString());
//                       break;
                   default:
                       break;
               }
               try {
                   Thread.sleep(5000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }

           }
        });
        Thread wendyThread = new Thread(() -> {
            while(true){
                Random random = new Random();
                int choice = random.nextInt(5);
                int vinylChoice = random.nextInt(10);
                switch (choice) {
                    case 0:
                        model.getAllVinyls().get(vinylChoice).borrowVinyl();
                        System.out.println("Wendy is borrowing");
                        System.out.println(model.getAllVinyls().get(vinylChoice).getVinylState().toString());
                        break;
                    case 1:
                        model.getAllVinyls().get(vinylChoice).reserveVinyl();
                        System.out.println("Wendy is reserving");
                        System.out.println(model.getAllVinyls().get(vinylChoice).getVinylState().toString());

                        break;
                    case 2:
                        model.getAllVinyls().get(vinylChoice).returnVinyl();
                        System.out.println("Wendy is returning");
                        System.out.println(model.getAllVinyls().get(vinylChoice).getVinylState().toString());
                        break;
                    case 3:
                        model.getAllVinyls().get(vinylChoice).removeVinyl();
                        System.out.println("Wendy is removing");
                        System.out.println(model.getAllVinyls().get(vinylChoice).getVinylState().toString());
                        break;
//                    case 4:
//
//                        model.getAllVinyls().get(vinylChoice).borrowAndReserveVinyl();
//                        System.out.println("Wendy is reserving and borrowing");
//                        System.out.println(model.getAllVinyls().get(vinylChoice).getVinylState().toString());
//                        break;
                    default:
                        break;
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        bobThread.start();
        wendyThread.start();
    }
}
