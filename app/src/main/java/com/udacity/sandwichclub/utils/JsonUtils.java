package com.udacity.sandwichclub.utils;

import android.media.Image;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        List<String> ingredientsList = new ArrayList<>();
        List<String> alsoKnownAsList = new ArrayList<>();

        try {

            JSONObject sandwichObject = new JSONObject(json);
            JSONObject nameObject = sandwichObject.getJSONObject("name");
            String placeOfOrigin = sandwichObject.getString("placeOfOrigin");
            String description = sandwichObject.getString("description");
            JSONArray ingredientsArr = sandwichObject.getJSONArray("ingredients");
            String image = sandwichObject.getString("image");

            JSONArray alsoKnowAsArr = nameObject.getJSONArray("alsoKnownAs");
            sandwich.setMainName(nameObject.getString("mainName"));
            sandwich.setPlaceOfOrigin(placeOfOrigin);
            sandwich.setDescription(description);
            sandwich.setImage(image);

            for (int i = 0; i < alsoKnowAsArr.length(); i++){

                String alsoKnownAsObject = alsoKnowAsArr.getString(i);
                alsoKnownAsList.add(alsoKnownAsObject);
            }

            for (int i = 0; i < ingredientsArr.length(); i++){

                String ingredientObject = ingredientsArr.getString(i);
                ingredientsList.add(ingredientObject);
            }
            sandwich.setIngredients(ingredientsList);

        } catch (Exception e) {

            System.out.println("LALA ERROR: " + e);
        }

        return sandwich;
    }
}
