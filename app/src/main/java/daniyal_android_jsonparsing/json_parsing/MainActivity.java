package daniyal_android_jsonparsing.json_parsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    String jsonData = "[{\n" +
            "\n" +
            "\t\"properties\": [{\n" +
            "\t\t\"Name\": \"Shahan\",\n" +
            "\t\t\"prop_name\": \"Bonneville\",\n" +
            "\t\t\"address\": \"122 Lakeshore\",\n" +
            "\t\t\"city\": \"Ripley\",\n" +
            "\t\t\"state\": \"OH\",\n" +
            "\t\t\"zip\": \"11454\",\n" +
            "\t\t\"lat\": \"41.123\",\n" +
            "\t\t\"long\": \"-85.5034\"\n" +
            "\t}]\n" +
            "}]";



    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.name);


        JSONArray mJsonArray = null;
        JSONObject mJsonObject = null;
        try {
            mJsonArray = new JSONArray(jsonData);
            mJsonObject = mJsonArray.getJSONObject(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {

            JSONArray mJsonArrayProperty = mJsonObject.getJSONArray("properties");
            for (int i = 0; i < mJsonArrayProperty.length(); i++) {
                JSONObject mJsonObjectProperty = mJsonArrayProperty.getJSONObject(i);

                String JName = mJsonObjectProperty.getString("Name");

                name.setText(JName);

//                String prop_name = mJsonObjectProperty.getString("prop_name");
//                String address = mJsonObjectProperty.getString("address");
//                String city = mJsonObjectProperty.getString("city");
//                String state = mJsonObjectProperty.getString("state");
//                String zip = mJsonObjectProperty.getString("zip");
//                String lat = mJsonObjectProperty.getString("lat");
//                String lon = mJsonObjectProperty.getString("long");
            }


        }catch (Exception e){}



    }
}
