package com.example.hotel_information_system;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Spinner destinationSpinner;
    private Button showHotelsButton;
    private TextView hotelDetails;

    // Data for hotels
    private Map<String, String[]> hotelData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        destinationSpinner = findViewById(R.id.destination_spinner);
        showHotelsButton = findViewById(R.id.show_hotels_button);
        hotelDetails = findViewById(R.id.hotel_details);

        // Sample data for tourist destinations and their hotels
        String[] destinations = {"New York", "Paris", "Tokyo", "Dubai"};
        hotelData = new HashMap<>();
        hotelData.put("New York", new String[]{
                "Artezen Hotel \n24 John Street, New York, NY 10038, United States \n$188.10",
                "LUMA Hotel \n120 West 41st Street, New York, NY 10036-7315, United States.\n$475",
                "NobleDEN Hotel \n196 Grand Street, Little Italy, New York, NY 10013, United States \n$284",
                "Hotel Scherman \n346 West 46th Street, Hell's Kitchen, New York, NY 10036, United States \n$249",
                "The Hotel Chelsea \n222 West 23rd Street, Chelsea, New York, NY 10011, United States \n$468",
                "The Wallace Hotel \n242 West 76th Street, Upper West Side, New York, NY 10023, United States \n$458.10",
                "Mint House \n70 Pine Street, New York, NY 10005, United States \n$376"
        });
        hotelData.put("Paris", new String[]{
                "Mode Paris Aparthotel \n4 Rue Leroux, 16th arr., 75116 Paris, France \n$301",
                "Drawing House \n21 Rue Vercingétorix, 14th arr., 75014 Paris, France \n$305",
                "Maison Albar - Le Diamond \n4, rue de la Pépinière, 8th arr., 75008 Paris, France \n$480",
                "Sofitel Paris Arc De Triomphe \n14 Rue Beaujon, 8th arr., 75008 Paris, France \n$370",
                "Sofitel Paris Arc De Triomphe \n14 Rue Beaujon, 8th arr., 75008 Paris, France \n$364",
                "Le Basile Hôtel \n23 rue Godot de Mauroy, 9th arr., 75009 Paris, France \n$458",
                "Hôtel Chamar \n35, Rue La Bruyère, 9th arr., 75009 Paris, France \n$295"

        });
        hotelData.put("Tokyo", new String[]{
                "Tokyo Bay Shiomi Prince Hotel \n135-0052 Tokyo-to, Koto-ku Shiomi 2-8-16, Japan \n$280",
                "THE BLOSSOM HIBIYA \n105-0004 Tokyo-to, Shinbashi 1-1-13, Japan \n$258",
                "The Okura Tokyo \n105-0001 Tokyo-to, Minato-ku Toranomon 2-10-4, Japan \n$323",
                "MIMARU Tokyo Hatchobori \n103-0025 Tokyo-to, 3-8-8 NIhombashi Kayabacho, Chuo-ku, Japan\n$286",
                "Imperial Hotel Tokyo \n100-8558 Tokyo-to, Chiyoda-ku Uchisaiwai-cho 1-1-1, Japan \n$254",
                "The Tokyo Station Hotel \n100-0005 Tokyo-to, Chiyoda-ku Marunouchi 1-9-1, Japan \n$199",
        });
        hotelData.put("Dubai", new String[]{
                "Jumeirah Burj Al Arab Dubai \nJumeirah Beach Road, Dubai, United Arab Emirates \n$750",
                "One&Only One Za'abeel, \nZa'abeel Street Za'abeel 1 - Level 25, Trade Centre, Dubai, United Arab Emirates, \n$805.10",
                "Kempinski The Boulevard Dubai \nSheikh Mohamed Bin Rashid Boulevard, Downtown Dubai, PO Box 214477, Downtown Dubai, 214477 Dubai, United Arab Emirates \n$799.50",
                "The Lana - Dorchester Collection, \nMarasi Drive Burj Khalifa District, Dubai, United Arab Emirates \n$785",
                "Mandarin Oriental Jumeira \n1 Jumeirah Street Jumeirah Beach Road, Jumeirah, Dubai, United Arab Emirates \n$849",
                "Shangri-La Dubai, \nSheikh Zayed Road, Trade Centre, Dubai, United Arab Emirates \n$825",
        });

        // Populate the spinner with destinations
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, destinations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destinationSpinner.setAdapter(adapter);

        // Set up button click listener
        showHotelsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedDestination = destinationSpinner.getSelectedItem().toString();
                showHotels(selectedDestination);
            }
        });
    }

    private void showHotels(String destination) {
        String[] hotels = hotelData.get(destination);
        if (hotels != null) {
            StringBuilder details = new StringBuilder();
            for (String hotel : hotels) {
                details.append(hotel).append("\n\n");
            }
            hotelDetails.setText(details.toString().trim());
        } else {
            hotelDetails.setText("No hotels available for this destination.");
        }
    }
}
