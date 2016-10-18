package com.example.ashutosh.supertourism3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutTopTourism extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_top_tourism);
        textView = (TextView) findViewById(R.id.text);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String indexNum=bundle.getString("topPlaceName");
        textView.setText(""+indexNum);

        switch (indexNum)
        {
            case  ("Bangalore Fort"): {
                textView.setText("Bangalore fort was built as a mud fort by Kempe Gouda in 1537. " +
                        "It was converted to the stone fort almost 200 years later in 1761 by Haider Ali." +
                        " It served as the stronghold hold of Tipu Sultan until it fell to the British in 1791 during the third Mysore War." +
                        " After coming under British most of the fort was reconstructed into house schools and hospitals and roads.\n" +
                        "\n" +
                        "While most of the fort was dismantled during the British occupation and later, " +
                        "one can still see the parts of once a majestic and historical structure. " +
                        "The Delhi gate, the point of entry of British troops during the fall still stands and is a brilliant example of Islamic architecture." +
                        " It has motifs and other carved decorations on the wooden doors. The door also has spikes which had the purpose of stopping charging elephants to break open the door." +
                        " There is also Ganpati shrine which dates back to 500 years. It was built by Kempa Gouda when the fort was first built." +
                        " There is also a wooden palace of Tipu Sultan in the premises.\n");
            }
                break;
            case ("Hebbe Falls"): {
                textView.setText("hebbe falls");
            }
                break;
            case ("Lalbaag"): {
                textView.setText("lalbag");
            }
                break;
            case ("National Park"):
            {
                textView.setText("national park");
            }
                break;
            case ("Tipu Sultan Palace"):
            {
                textView.setText("tipu sultan palace");
            }

            default:
                textView.setText("What");

        }
    }
}
