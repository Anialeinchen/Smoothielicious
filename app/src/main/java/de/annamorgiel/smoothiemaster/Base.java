package de.annamorgiel.smoothiemaster;

/**
 * Created by Ania on 08.07.2016.
 **/
public class Base{
    private
        String nameBase;
        String vitBase;
    Integer calBase;
    public
        String getNameBase(){
            return nameBase;
    }
        String getVitBase(){
            return vitBase;
        }
        int getCalBase(){
            return calBase;
        }

        void setNameBase(String nameBase){
            this.nameBase = nameBase;
        }

        void setVitBase(String nameBase){
            this.vitBase = this.vitBase + ", " + vitBase;
        }
        void setCalBase(Integer calBase){
            this.calBase = this.calBase + calBase;
        }
        void resetVitBase(){
            vitBase = "";
        }
        void resetCalBase(){
            calBase = 0;
        }

    Base(){
        nameBase = "Name of the Base";
        vitBase = "";
        calBase = 0;
    }
    Base(String nameBase, String vitBase, int calBase){
        this.nameBase = nameBase;
        this.vitBase = vitBase;
        this.calBase = calBase;
    }
}
