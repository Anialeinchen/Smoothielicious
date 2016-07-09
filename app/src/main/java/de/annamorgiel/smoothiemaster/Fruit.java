package de.annamorgiel.smoothiemaster;

/**
 * Created by Ania on 08.07.2016.
 **/
public class Fruit {
    private
        String nameFruit;
        String vitFruit;
        int calFruit;

    public
        String getNameFruit(){
            return nameFruit;
    }
        String getVitFruit(){
            return vitFruit;
    }
    Integer getCalFruit(){
            return calFruit;
    }

        void setNameFruit(String nameFruit){
            this.nameFruit = nameFruit;
        }

        void setVitFruit(String vitFruit){
            this.vitFruit = this.vitFruit + ", " + vitFruit;
        }

        void setCalFruit(Integer calFruit){
            this.calFruit = this.calFruit + calFruit;
        }

        void resetVitFruit(){
            vitFruit = "";
        }

        void resetCalFruit(){
            calFruit = 0;
        }

    Fruit(){
        nameFruit = "Mumbo";
        vitFruit = "";
        calFruit = 0;
    }

    Fruit(String nameFruit, String vitFruit, int calFruit){
        setNameFruit(nameFruit);
        setVitFruit(vitFruit);
        setCalFruit(calFruit);
    }
}
