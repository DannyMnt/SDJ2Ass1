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
               int choice = random.nextInt(4);
               int vinylChoice = random.nextInt(10);
               Vinyl selectedVinyl = model.getAllVinyls().get(vinylChoice);
               String currentState = selectedVinyl.getVinylState().getVinylStateName();

               switch (currentState) {
                   case "Available":
                       switch (choice) {
                           case 0:
                               selectedVinyl.borrowVinyl();
                               System.out.println("Bob is borrowing" + selectedVinyl.getTitle());
                               break;
                           case 1:
                               selectedVinyl.reserveVinyl();
                               System.out.println("Bob is reserving" + selectedVinyl.getTitle());
                               break;
                           case 3:
                               selectedVinyl.removeVinyl();
                               System.out.println("Bob is removing" + selectedVinyl.getTitle());
                               break;
                           default:
                               break;
                       }
                       break;
                   case "Reserved":
                       if (choice == 0) {
                           selectedVinyl.borrowVinyl();
                           System.out.println("Bob is borrowing" + selectedVinyl.getTitle());
                       }
                       break;
                   case "Borrowed":
                       switch (choice) {
                           case 2:
                               selectedVinyl.returnVinyl();
                               System.out.println("Bob is returning" + selectedVinyl.getTitle());
                               break;
                           case 1:
                               selectedVinyl.reserveVinyl();
                               System.out.println("Bob is reserving" + selectedVinyl.getTitle());
                               break;
                           default:
                               break;
                       }
                       break;
                   case "BorrowedAndReserved":
                       if (choice == 2) {
                           selectedVinyl.returnVinyl();
                           System.out.println("Bob is returning" + selectedVinyl.getTitle());
                       }
                       break;
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
                int choice = random.nextInt(4);
                int vinylChoice = random.nextInt(10);
                Vinyl selectedVinyl = model.getAllVinyls().get(vinylChoice);
                String currentState = selectedVinyl.getVinylState().getVinylStateName();

                switch (currentState) {
                    case "Available":
                        switch (choice) {
                            case 0:
                                selectedVinyl.borrowVinyl();
                                System.out.println("Bob is borrowing" + selectedVinyl.getTitle());
                                break;
                            case 1:
                                selectedVinyl.reserveVinyl();
                                System.out.println("Bob is reserving" + selectedVinyl.getTitle());
                                break;
                            case 3:
                                selectedVinyl.removeVinyl();
                                System.out.println("Bob is removing" + selectedVinyl.getTitle());
                                break;
                            default:
                                break;
                        }
                        break;
                    case "Reserved":
                        if (choice == 0) {
                            selectedVinyl.borrowVinyl();
                            System.out.println("Bob is borrowing" + selectedVinyl.getTitle());
                        }
                        break;
                    case "Borrowed":
                        switch (choice) {
                            case 2:
                                selectedVinyl.returnVinyl();
                                System.out.println("Bob is returning" + selectedVinyl.getTitle());
                                break;
                            case 1:
                                selectedVinyl.reserveVinyl();
                                System.out.println("Bob is reserving" + selectedVinyl.getTitle());
                                break;
                            default:
                                break;
                        }
                        break;
                    case "BorrowedAndReserved":
                        if (choice == 2) {
                            selectedVinyl.returnVinyl();
                            System.out.println("Bob is returning" + selectedVinyl.getTitle());
                        }
                        break;
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
