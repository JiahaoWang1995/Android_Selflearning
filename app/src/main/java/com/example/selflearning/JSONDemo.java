package com.example.selflearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JSONDemo extends AppCompatActivity {
    private List<String[]> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsondemo);
        setTitle(getIntent().getStringExtra("title"));
        data = new ArrayList<String[]>();

        try {

            JSONObject newJSON = new JSONObject();
            newJSON.put("cat", "it");

            JSONObject lan1 = new JSONObject();
            lan1.put("id", 1);
            lan1.put("name", "Java");
            lan1.put("ide", "Idea");

            JSONObject lan2 = new JSONObject();
            lan2.put("id", 2);
            lan2.put("name", "JavaScript");
            lan2.put("ide", "Visual Studio");

            JSONObject lan3 = new JSONObject();
            lan3.put("id", 3);
            lan3.put("name", "Python");
            lan3.put("ide", "Pycharm");

            JSONArray array = new JSONArray();
            array.put(lan1);
            array.put(lan2);
            array.put(lan3);

            newJSON.put("languages", array);

            System.out.println(newJSON.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            InputStreamReader reader = new InputStreamReader(getAssets()
                    .open("my_json_demo.json"), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = bufferedReader.readLine())!=null) {
                builder.append(line);
            }
            bufferedReader.close();
            reader.close();
            JSONObject root = new JSONObject(builder.toString());
//            System.out.println("cat="+root.getString("cat"));
            JSONArray array = root.getJSONArray("languages");
            for (int i=0; i<array.length(); i++) {
                JSONObject item = array.getJSONObject(i);
                String[] strings = new String[3];
                strings[0] = String.valueOf(item.getInt("id"));
                strings[1] = item.getString("name");
                strings[2] = item.getString("ide");
                data.add(strings);
//                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
//                System.out.println("id="+item.getInt("id")+" name="+
//                        item.getString("name")+" ide="+item.getString("ide"));
            }

            ListView listView = findViewById(R.id.json_listview);
            MyJSONAdapter adapter = new MyJSONAdapter(this, R.layout.json_adapter, data);
            listView.setAdapter(adapter);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
