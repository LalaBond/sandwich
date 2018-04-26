package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        List<String> ingredientsList = null, alsoKnownAsList = null;

        try {
            JSONObject sandwichObject = new JSONObject(json);

            sandwich.setMainName(sandwichObject.getString("mainName"));

            JSONArray alsoKnownAsArray = sandwichObject.getJSONArray("alsoKnownAs");

            for (int x = 0; alsoKnownAsArray.length() < x; x++) {
                alsoKnownAsList.add(alsoKnownAsArray.getString(x));
            }

            sandwich.setAlsoKnownAs(alsoKnownAsList);
            sandwich.setDescription(sandwichObject.getString("description"));
            sandwich.setPlaceOfOrigin(sandwichObject.getString("placeOfOrigin"));
            sandwich.setImage(sandwichObject.getString("image"));

            JSONArray ingredientsArray = sandwichObject.getJSONArray("ingredients");

            for (int x = 0; ingredientsArray.length() < x; x++) {
                ingredientsList.add(ingredientsArray.getString(x));
            }

            sandwich.setIngredients(ingredientsList);

        } catch (Exception e) {

            System.out.println("LALA ERROR: " + e);
        }


        return sandwich;
    }
}
