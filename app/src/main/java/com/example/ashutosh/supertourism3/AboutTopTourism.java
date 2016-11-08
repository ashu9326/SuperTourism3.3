package com.example.ashutosh.supertourism3;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.ashutosh.supertourism3.model.CustomAdapter;

public class AboutTopTourism extends AppCompatActivity {
    private TextView textView;
    CustomAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("About Top Places");
        setContentView(R.layout.activity_about_top_tourism);
        textView = (TextView) findViewById(R.id.text);

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String indexNum = bundle.getString("topPlaceName");
        textView.setText("" + indexNum);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(indexNum);

        switch (indexNum) {
            case ("Hampi Village"): {
                adapter = new CustomAdapter(this,"Hampi Village" );
                textView.setText("Hampi is situated on the banks of the Tungabhadra River. It is 353 km from Bangalore and 74 km away from Bellary. Hosapete (Hospet), 13 km away, is the nearest railway head. Guntakal Jn S.C.Railway just 99 km from Guntakal, which is also on the banks of Tunghabhadra, in AP is some 150 km away.\n" +
                        "\n" +
                        "Emperor Ashoka's Rock Edicts in Nittur & Udegolan (both in Bellary district) suggest that this region was part of the Maurya Empire during the 3rd century BC. A Brahmi inscription and a terracotta seal dating to the 2nd century CE were also recovered from the excavation site.\n" +
                        "\n" +
                        "The first settlements in Hampi date from 1 CE.\n" +
                        "\n" +
                        "Immediately before the rise of the Vijayanagara kings, the region was probably in the hands of chiefs of Kampili, now a small town, 19 km east of Hampi.\n" +
                        "\n" +
                        "Kampili was said to have been founded by Gayathri Giri of Annar bara. Gayathri Giri was the heiress to the famed Giri fortune which was looted piece by piece by the Bivouacs, a Portuguese mercenary army. Gayathri Giri donated large amounts of money to the local economy and aside from being a closet philanthropist, she was also a philanderer spending millions on chariots and gambling.\n" +
                        "\n" +
                        "Gayathri Giri's biggest contribution to southern India was her penchant for setting up public washrooms and sheds for animals. Ruins of these sheds are still seen in Thanjavur and Rameshwaram. Gayathri Giri was said to be secretly in love with Premla Tapoonia, the queen of Mysore, and the constant rejection by Premla led to Gayathri's eventual demise from a broken heart. Premla moved on to marry Suresha Pallava, the king of Humanavarnam.\n" +
                        "\n" +
                        "Hampi was one of the best areas of the capital of the Vijayanagara Empire from 1343 to 1565, when it was besieged by the Deccan Muslim confederacy. Hampi was chosen because of its strategic location, bounded by the torrential Tungabhadra river on one side and surrounded by defensible hills on the other three sides.\n" +
                        "\n" +
                        "The ruins of Hampi were discovered by Colonel Colin Mackenzie in 1800.\n" +
                        "\n" +
                        "The site is significant historically and architecturally. The landscape abounds with large stones which have been used to make statues of Jaina deities. The Archaeological Survey of India continues to conduct excavations in the area to search for additional artifacts and temples.\n" +
                        "\n" +
                        "The Islamic Quarter, sometimes called the Moorish Quarter, is located between the northern slope of the Malyavanta hill and the Talarigatta Gate. According to archaeologists, high-ranking Muslim officers of the king's court and military officers lived in this area.");

                viewPager.setAdapter(adapter);
            }
            break;
            case ("Hebbe Falls"): {
                adapter = new CustomAdapter(this,"Hebbe Falls" );
                textView.setText("Hebbe Falls are situated at 13°32'29?N 75°43'30?E about 10 km away from the famous hill station Kemmangundi in \n" +
                        "Karnataka, India. This waterfalls are inside a coffee estate and can be reached either by walk or four-wheeler. \n" +
                        "Wikipedia\n" +
                        "Address: Kesavinamane, Karnataka 577131\n" +
                        "Height: 168 m\n" +
                        "Phone: 070263 15329\n" +
                        "\n" +
                        "Kemmannugundi is a hill station in Tarikere taluk of Chikkamagaluru district in the state of Karnataka, India. It \n" +
                        "is 1434m above sea level.[1] This was the summer retreat of Krishnaraja Wodeyar IV and as a mark of respect to the \n" +
                        "king, it is also known as Sri Krishnarajendra Hill Station. The station is ringed by the Baba Budan Giri Range, \n" +
                        "with cascades, mountain streams, and lush vegetation, Kemmangundi’s has ornamental gardens and mountains and \n" +
                        "valleys views. There is a spectacular sunset view from the Raj Bhavan.\n" +
                        "\n" +
                        "Transport[edit]\n" +
                        "Road[edit]\n" +
                        "Kemmannugundi is 53 km from Chikkamagaluru and 17 km from Lingadahalli by road. The nearest National Highways, \n" +
                        "NH-206 or NH-48, connect to Bangalore. There is another route via Mullayyanagiri, a scenic drive. If you are \n" +
                        "dependent only on public transport then you can catch a private bus from Lingadahalli at 9.30am and the same bus \n" +
                        "(last bus) comes at Kemmanagundi at 4.30pm goes to Birur via Lingadahalli.\n" +
                        "Rail[edit]\n" +
                        "The nearest railway station is 33 km away at Birur& Kadur.\n" +
                        "Air[edit]\n" +
                        "The nearest airports are at Mangalore (150 km) and Bangalore");
                viewPager.setAdapter(adapter);
            }
            break;
            case ("Lalbaag"): {
                adapter = new CustomAdapter(this,"Lalbaag" );
                textView.setText("Lalbagh is a 240 acres (0.97 km2) garden and is located in south Bangalore. It holds a number of flower shows, especially on the Republic Day (26 January). The garden has over 1,000 species of flora. The garden also has trees that are over 100 years old.\n" +
                        "\n" +
                        "The garden surrounds one of the towers erected by the founder of Bangalore, Kempe Gowda. The park has some rare species of plants brought from Persia, Afghanistan and France. With an intricate watering system for irrigation, this garden is aesthetically designed, with lawns, flowerbeds, lotus pools and fountains. Most of the centuries-old trees are labelled for easy identification. The Lalbagh Rock, one of the oldest rock formations on earth, dating back to 3,000 million years, is another attraction that attracts the crowds.\n" +
                        "\n" +
                        "Lalbagh remains open daily from 6:00 a.m. to 7:00 p.m. throughout the year. For the benefit of joggers, tourists and fitness enthusiasts, entry is free from 6:00 a.m. to 9:00 a.m. and from 5:30 p.m. to 7:00 p.m. At other times, a fee of Rs.20/- is charged. Entry for school children and the disabled is free all day.\n" +
                        "\n" +
                        "Flower shows are conducted every year during the week of Republic day and Independence day, to educate people about the variety of flora and develop public interest in plant conservation and cultivation.Entry fee for adults is Rs. 20/- (On weekends and Public holidays - Rs. 20/-) and for children below 12 years, Free.\n" +
                        "\n" +
                        "The government of Karnataka organizes \"Janapada Jaatre\" in Lalbagh on the second and fourth weekends (both Saturday and Sunday) of every month. Janapada Jaatre, which translates to Folk Fair, features folk dance, music and plays performed by troupes from all parts of Karnataka. The show mainly depicts the cultural folklore of Karnataka, the traditional costumes and musical instruments.\n" +
                        "\n" +
                        "A geological monument for the peninsular gneiss formation is also a tourist attraction at the gardens. This monument has been designated by the Geological Survey of India on the Lalbagh hill which is made up of 3,000 million-year-old peninsular gneissic rocks. One of the four cardinal towers erected by Kempegowda II, also a major tourist attraction, is seen above this hillock. This tower gives the full view of Bangalore from the top.");
                     viewPager.setAdapter(adapter);
            }
            break;
            case ("National Park"): {
                adapter = new CustomAdapter(this,"National Park" );
                textView.setText("Bannerghatta National Park, near Bangalore, Karnataka, was founded in 1970 and declared as a national park in 1974. In 2002 a portion of the park, became a biological reserve, the Bannerghatta Biological Park. It is a popular tourist destination with a zoo, a pet corner, an animal rescue centre, a butterfly enclosure, an aquarium, a snake house and a safari park. There are ancient temples in the park for worship and it is a destination for trekking and hiking. The Zoo Authority of Karnataka, the University of Agricultural Sciences, Bangalore, and the Ashoka Trust for Research in Ecology and Environment (ATREE) are collaborating agencies. Within the national park area are six rural villages enclosed within three large enclosures for sheep and cattle farming.\n" +
                        "\n" +
                        "Geography\n" +
                        "\n" +
                        "The 65,127.5 acre (260.51 km2[4]) national park is located about 22 km south of Bangalore in the hills of the Anekal range with an elevation of 1245 - 1634m. The park has a hilly terrain of granite sheets under moist deciduous forest valleys and scrubland on higher areas. Sixteen villages border the park. The park is part of a wildlife corridor for elephants which connects the BR Hills and the Sathyamangalam forest. The park is contiguous with Talli reserve forest in the southeast and Bilikal forest in the south.");
                viewPager.setAdapter(adapter);
            }
            break;
            case ("Tipu Sultan Palace"): {
                adapter = new CustomAdapter(this,"Tipu Sultan Palace" );
                textView.setText("Tipu Sultan's Summer Palace, in Bangalore, India, is an example of Indo-Islamic architecture and was the summer residence of the Mysorean ruler Tipu Sultan. Hyder Ali commenced its construction within the walls of the Bangalore Fort, and it was completed during the reign of Tipu Sultan in 1791. After Tipu Sultan's death in the Fourth Anglo-Mysore War, the British Administration used the palace for its Secretariat before moving to Attara Kacheri in 1868. Today the government of Karnataka maintains the palace, which is located at the center of Old Bangalore near the Kalasipalyam bus stand, as a tourist spot.\n" +
                        "\n" +
                        "The structure was built entirely of teak and stands adorned with pillars, arches and balconies. It is believed that Tipu Sultan used to conduct his durbar (court) from the eastern and western balconies of the upper floor. There are four smaller rooms in the corners of first floor which were used to known as Zenana Quarters.There are beautiful floral motifs embellishing the walls of the palace. The site also holds a painting of grand throne visualized by Tipu Sultan himself. Coated with gold sheets and stuck with precious emerald stones, Tipu had vowed never to use it until he completely defeated the English Army. After Tipu Sultan's death, the British dismantled the throne and auctioned its parts as it was too expensive for a single person to buy whole.[citation needed]\n" +
                        "\n" +
                        "The rooms in the ground floor have been converted into a small museum showcasing various achievements of Tipu Sultan and his administration. There are newly done portraits of the people and places of that time. There is a replica of Tipu's Tiger, which is in the Victoria and Albert Museum in London. Tipu Sultan's clothes and his crown are present in silver and gold pedestals. The silver vessels given by a general to Hyder Ali is also displayed.\n" +
                        "\n" +
                        "The Horticulture Department, Government of Karnataka, maintains the area in front of the palace as a garden and lawn.");
                viewPager.setAdapter(adapter);
            }
                 break;
            default:
                textView.setText("Sorry!,Nothing could be display.");

        }
    }
}
