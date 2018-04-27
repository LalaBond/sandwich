package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    /*
    * @Params json
    * This method sets values to a Sandwich instance.  JSONObject and
    * JSONArray are used in order to get proper values from the
    * json string received
    * */
    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        List<String> ingredientsList = new ArrayList<>();
        List<String> alsoKnownAsList = new ArrayList<>();

        try {

            JSONObject sandwichObject = new JSONObject(json);
            JSONObject nameObject = sandwichObject.getJSONObject("name");
            String placeOfOrigin = sandwichObject.getString("placeOfOrigin");
            placeOfOrigin = placeOfOrigin.isEmpty()? "Unknown" : sandwichObject.getString("placeOfOrigin");

            String description = sandwichObject.getString("description");
            JSONArray ingredientsArr = sandwichObject.getJSONArray("ingredients");
            String image = sandwichObject.getString("image");

            JSONArray alsoKnowAsArr = nameObject.getJSONArray("alsoKnownAs");
            sandwich.setMainName(nameObject.getString("mainName"));
            sandwich.setPlaceOfOrigin(placeOfOrigin);
            sandwich.setDescription(description);
            sandwich.setImage(image);

            String alsoKnownAsObject;

            for (int i = 0; i < alsoKnowAsArr.length(); i++){

                alsoKnownAsObject = alsoKnowAsArr.getString(i);
                alsoKnownAsList.add(alsoKnownAsObject);
            }

            if(alsoKnownAsList.isEmpty()){
                alsoKnownAsList.add("N/A");
            }

            sandwich.setAlsoKnownAs(alsoKnownAsList);

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
