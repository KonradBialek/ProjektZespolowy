package com.example.projektzespolowy;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalendarActivity extends AppCompatActivity {

    //definicje pól, nadaję im takie same nazwy jak id elementów
    Button menu;
    TextView calendarHeaderTextView;
    CalendarView plantsCalendar;
    ListView listView;
    LocalDate selectedDate; //data aktualnie wybrana na kalendarzu



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        //inicjalizacja zdefiniowanych w tej klasie pól, łączenie pól z layoutem activity_calendar, za pomocą funkcji findViewById()
        menu = (Button) findViewById(R.id.menu);
        plantsCalendar = (CalendarView) findViewById(R.id.plantsCalendar);
        listView = (ListView) findViewById(R.id.listView);

        //do edycji
        plantsCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {//trzeba sprawdzać datę
            // klikniętą w kalendarzu metodą setOnDateChangeListener
            //ustawia Listener na kalendarzu plantsCalendar

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override //metoda w której można sobie zapisać datę w wybranym formacie
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //jako argumenty pryjmuje: kalendarz, rok, miesiąc i dzień miesiąca w postaci intów

                String date = dayOfMonth + "/" + (month+1) + "/" + year;//tworzę stringa na podatawie intów podanych jako argumenty
                //miesiąc+1 ponieważ miesiąc jest przechowywany w postaci inta, ale zachyna się od zera
                calendarHeaderTextView.setText(date);//ustawiam wyświetlanie daty na headerze

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy"); //tworzymy formatter typu DateTimeFormatter
                    //żeby pokazać z jakiego formatu stringa chcę utworzyć obiekt typu local date, metodą ofPattern chcemy ustalić wzór
                    //(który podajemy w jej argumencie)
                    selectedDate = LocalDate.parse(date,formatter);//przekazuję formatter do funkcji LocalDate.parse i jeżeli będe parsować
                    //stringa który nazywa sie date to tym formatterem mówię, ja ci dam stringa który wygląda tak ("d/M/yyyy") i ty na
                    // podstawie tego stringa stwórz obiekt typu LocalDate który będzie domyślny i to LocalDate zapisze się do pola
                    // slectedDate które jest klasowe czyli dostępne dla wszystkich metod

                Log.i("selectedDate: ",selectedDate.toString());

            }
        });

    }
}