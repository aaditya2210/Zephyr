package com.example.voltify;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Faq extends AppCompatActivity {
    TextView textView14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        textView14 = findViewById(R.id.textView14);
        textView14.setText(getString(R.string.how_does_the_ev_trip_planner_work) +
                "\n\n" +
                "Our EV trip planner utilizes advanced algorithms to calculate the most efficient route for your electric vehicle based on factors like battery range, charging station availability, and your destination.\n\n" +
                "What type of electric vehicles does the app support?\n" +
                "\n" +
                "Our app supports a wide range of electric vehicles, including all major brands and models. We regularly update our database to ensure compatibility with the latest EVs on the market.\n\n" +
                "Can I customize my route preferences?\n" +
                "\n" +
                "Yes, you can customize your route preferences to prioritize factors like fastest route, shortest route, or routes with specific charging stations along the way. Simply adjust the settings in the app to tailor your trip to your preferences.\n\n" +
                "How accurate are the charging station locations?\n" +
                "\n" +
                "We strive to provide accurate and up-to-date information about charging station locations. However, since charging station availability can vary, especially in remote areas, we recommend double-checking the information within the app and using real-time data when available.\n\n" +
                "Does the app consider weather conditions in trip planning?\n" +
                "\n" +
                "While the app doesn't directly factor in weather conditions, it does take into account your vehicle's energy consumption and battery range, which can be affected by weather conditions like temperature and wind. We recommend adjusting your trip plan accordingly for extreme weather conditions.\n\n" +
                "Is the app available for both iOS and Android devices?\n" +
                "\n" +
                "Yes, our app is available for both iOS and Android devices. You can download it from the App Store or Google Play Store, depending on your device.\n\n" +
                "Can I plan multi-stop trips with the app?\n" +
                "\n" +
                "Absolutely! Our app allows you to plan multi-stop trips with ease. Simply input your desired destinations, and the app will optimize your route to include charging stops along the way, ensuring a seamless journey from start to finish.\n\n" +
                "Does the app provide real-time updates on charging station availability?\n" +
                "\n" +
                "Yes, the app provides real-time updates on charging station availability whenever possible. This feature helps you plan your stops more effectively, especially during peak travel times or in areas with high demand for charging stations.\n\n" +
                "Is there a cost associated with using the app?\n" +
                "\n" +
                "Our basic trip planning features are available for free, but we also offer premium features for a subscription fee. These premium features may include advanced route optimization, enhanced charging station information, and additional customization options.\n\n" +
                "How can I provide feedback or report an issue with the app?\n" +
                "\n" +
                "We welcome feedback from our users and strive to continuously improve the app. You can provide feedback or report any issues by contacting our support team directly through the app or via email. Your input helps us enhance the user experience for everyone");


        };
    }
