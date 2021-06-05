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





    public void Menu(View view) {
        Intent menuIntent = new Intent(getApplicationContext(), NavigationActivity.class);
        startActivity(menuIntent);
    }
}