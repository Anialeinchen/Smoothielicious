/*
* Smoothielicous !
*
* Nachdem man Button angeglickt hat, wird
* 1)Linear layout auf Visibile gestellt
* 2) die Anzahl von Calories wird angezeigt, Vitamins und auch hoffentlich die Farbe
* 3)auch der Name, der Aus ManKiwStrMel (3 Buchstäbigen Kompinationen besteht)
*
* */

//TODO change app name to Smoothielicious
package de.annamorgiel.smoothiemaster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    //Liste aus Kiw, Str, Man..  erste drei Buchstaben der vorher gewählten Obst
    List<String> allThreeLetters = new ArrayList<>();
    //String erzeugt aus der Zusammensetzung der List<String> allThreeLetters Elemente
    String threeLetters;
    String smoothieName;
    String smoothieVit;
    Integer smoothieCal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  void smoothie(){
        LinearLayout layone= (LinearLayout) View.findViewById(R.id.layoutId);
        layone.setVisibility(View.VISIBLE);
         }*/

        //TODO (?) sollte es nicht in der Fruit/Base Class sein?
        ArrayList<Base> listBase = new ArrayList<>();
        ArrayList<Fruit> listFruit = new ArrayList<>();
        ArrayList<Fruit> ingredients = new ArrayList<>();

        //ich initialisiere Instanzen der Fruit und Base Klasse mit ausgedachten Werten
        //TODO: richtige Werte fuer alle VitArray & CalArray waehlen
        String[] fruitNamesArray = {"Banana", "Kiwi", "Mango", "Strawberry", "Berries", "Peach"};
        String[] fruitVitArray = {"A,K", "C", "B12", "D", "B6", "C,D"};
        int[] fruitCalArray = {33, 66, 55, 33, 22, 11};

        String[] baseNamesArray = {"Banana", "Kiwi", "Mango", "Strawberry", "Berries", "Peach"};
        String[] baseVitArray = {"A,K", "C", "B12", "D", "B6", "C,D"};
        int[] baseCalArray = {33, 66, 55, 33, 22, 11};

        //GENERATE LISTS
        //ArrayList<Fruit> listFruit bekommt alle Elemente vom Typ Fruit
        for (int i = 0; i < fruitNamesArray.length; i++) {
            listFruit.add(new Fruit(fruitNamesArray[i], fruitVitArray[i], fruitCalArray[i]));
        }
        //ArrayList<Base> listBase bekommt alle Elemente vom Typ Base
        for (int i = 0; i < baseNamesArray.length; i++) {
            listBase.add(new Base(baseNamesArray[i], baseVitArray[i], baseCalArray[i]));
        }

        int sizeOfListFruit = listFruit.size();
        int newFruitPosition;
        Random generator = new Random();

        //ingriedients should have 4 Fruit items
        //TODO: lieber Namen als Objekte vergleichen
        while (ingredients.size() != 5) {
            newFruitPosition = generator.nextInt(sizeOfListFruit);
            //if newFruit not in listFruits => listFruits + newFruit
            if (!(ingredients.contains(listFruit.get(newFruitPosition)))) {
                ingredients.add(listFruit.get(newFruitPosition));
            }
        }
        //TODO: substrings statt charAt
        //ich generiere den Namen meines Smoothies ( ManKiwStrMel)
        for (int i = 0; i < 4; i++) {
            threeLetters = "" + (ingredients.get(i).getNameFruit().charAt(0)) + (ingredients.get(i).getNameFruit().charAt(1)) + (ingredients.get(i).getNameFruit().charAt(2));
            allThreeLetters.add(threeLetters);
            Collections.shuffle(allThreeLetters);
            smoothieCal = smoothieCal + ingredients.get(i).getCalFruit();
            smoothieVit = smoothieVit + ingredients.get(i).getVitFruit();
            for (int j = 0; j < 4; j++) {
                smoothieName = smoothieName + allThreeLetters.get(i);
            }
        }
    }

    public void smoothie(View view) {

        /* TODO: set visible
        LinearLayout layone= (LinearLayout) View.findViewById(R.id.layoutId);
        layone.setVisibility(View.VISIBLE);
        */
        TextView smoText = (TextView) findViewById(R.id.idTextView);
        smoText.setText(smoothieName);

        TextView smoCal = (TextView) findViewById(R.id.view_calories);
        smoCal.setText(String.format(" ",smoothieCal));

        TextView smoVit = (TextView) findViewById(R.id.view_nutritian);
        smoVit.setText(smoothieVit);

    }


}