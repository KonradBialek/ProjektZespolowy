package com.example.projektzespolowy;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.example.projektzespolowy.model.CalendarListViewItem;

public class CalendarActivity extends AppCompatActivity {

    Button menu;
    TextView calendarHeaderTextView;
    CalendarView plantsCalendar;
    LocalDate selectedDate; //data aktualnie wybrana na kalendarzu
    ListView listView;
    ArrayAdapter<CalendarListViewItem> arrayAdapter;

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        //inicjalizacja zdefiniowanych w tej klasie pól, łączenie pól z layoutem activity_calendar, za pomocą funkcji findViewById()
        menu = (Button) findViewById(R.id.menu);
        plantsCalendar = (CalendarView) findViewById(R.id.plantsCalendar);
        listView = (ListView) findViewById(R.id.calListView);


        plantsCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + (month+1) + "/" + year;
                calendarHeaderTextView.setText(date);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                    selectedDate = LocalDate.parse(date,formatter);
                }
                Log.i("selectedDate: ",selectedDate.toString());

                //TODO w tym miejscu pobieram z apki serwerowej liste kwiatow do podlania na konkretny dzien
                //TODO muszę dopisac implementacje pobierania listy z apki serwerowej
                CalendarListViewItem[] itemList = new CalendarListViewItem[2];
                itemList[0] = new CalendarListViewItem(1L, "fajen kwiatek",true);
                itemList[1] = new CalendarListViewItem(1L, "kolejny fajen kwiatek", false);


                arrayAdapter = new ArrayAdapter<CalendarListViewItem>(getApplicationContext(), android.R.layout.simple_list_item_multiple_choice, itemList);
                listView.setAdapter(arrayAdapter);

                validateWateringOfItems(arrayAdapter, listView); // w tym miejscu w listView zaznaczane sa checkboxy dla kwiatkow z bazy ktore zostaly juz podlane

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if(listView.isItemChecked(position)){
                            //TODO tutaj mogę wysylac zapis podlania do bazy danych (aplikacji serwerowej)
                            Log.i("TODO", "zapisz w bazie podlanie");
                            CalendarListViewItem item = (CalendarListViewItem) listView.getItemAtPosition(position);
                            Log.i("it:",item.getName());
                        }
                        if(!listView.isItemChecked(position)){
                            Log.i("ITEM:","Item zostal odklikniety");
                            //TODO mogę dopisac w tym miejscu obsluge odklikniecia podlania
                        }

                    }
                });
            }
        });

    }


    public void validateWateringOfItems(ArrayAdapter adapter, ListView listViewParam){
        CalendarListViewItem tmp;
        for(int i=0; i<adapter.getCount(); i++){
            tmp = (CalendarListViewItem) listViewParam.getItemAtPosition(i);
            if(tmp.isWatered()){
                listViewParam.setItemChecked(i,true);
            }
        }
    }
    */

    public void Menu(View view) {
        Intent menuIntent = new Intent(getApplicationContext(), NavigationActivity.class);
        startActivity(menuIntent);
    }
}