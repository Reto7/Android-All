package com.androidatc.helloworldandroidapplication;

public class BmiBusinessComponent {


    public static String calculateBMI(float weight, float height) {
        // Koerpergewicht in Kilogramm geteilt durch das Quadrat der Koerpergroesse in Metern.
        height = height/100;
        float bmi = weight / (height*height);

        System.out.println("BMI:"+bmi);

        String interpretation = "";
        if      (bmi < 18.5f) interpretation = "Untergewicht";
        else if (bmi >= 18.5f && bmi <= 24.9f) interpretation = "Normalgewicht";
        else if (bmi >= 25 && bmi <= 29.9f) interpretation = "Uebergewicht";
        else if (bmi >= 30 && bmi <= 34.9f) interpretation = "Starkes Uebergewicht, Adipositas Grad I";
        else if (bmi >= 35 && bmi <= 39.9f) interpretation = "Starkes Uebergewicht, Adipositas Grad II";
        else if (bmi >= 40                ) interpretation = "Starkes Uebergewicht, Adipositas Grad III";

        /*
        Untergewicht: weniger als 18,5
        Normalgewicht: 18,5 - 24,9
        Uebergewicht: 25 - 29,9
        Starkes Übergewicht Adipositas Grad I:   30 - 34,9
        Starkes Übergewicht Adipositas Grad II:  35 - 39,9
        Starkes Übergewicht Adipositas Grad III: 40 oder mehr
        */

        return String.valueOf(bmi) + " (" +interpretation +")";
    }



}
