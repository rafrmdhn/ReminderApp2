package com.example.projek_tam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class calendar extends AppCompatActivity implements CalendarAdapter.OnItemListener{
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private LocalDate selectedDate;
    private TextView _edit;
    private TextView jumat_agung;
    private TextView alarm;
    private TextView notes;
    private TextView tgl_acara;
    private View rectangle_5;
    private View _rectangle_6;
    private ImageView _vector_ek11;
    private TextView i_want____;

    private int selectedDay;
    private String selectedMonthYear;
    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_page);
        rectangle_5 = (View) findViewById(R.id.rectangle_5);
        _rectangle_6 = (View) findViewById(R.id._rectangle_6);
        _vector_ek11 = (ImageView) findViewById(R.id._vector_ek11);
        i_want____ = (TextView) findViewById(R.id.i_want____);

        initWidgets();
        selectedDate = LocalDate.now();
        setMonthView();
        _vector_ek11.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent nextScreen = new Intent(getApplicationContext(), home_page_activity.class);
                startActivity(nextScreen);
            }
        });
    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
    }

    private void setMonthView()
    {
        monthYearText.setText(monthYearFromDate(selectedDate));
        ArrayList<String> daysInMonth = daysInMonthArray(selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }

    private ArrayList<String> daysInMonthArray(LocalDate date)
    {
        ArrayList<String> daysInMonthArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);

        int daysInMonth = yearMonth.lengthOfMonth();

        LocalDate firstOfMonth = selectedDate.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();

        for(int i = 1; i <= 42; i++)
        {
            if(i <= dayOfWeek || i > daysInMonth + dayOfWeek)
            {
                daysInMonthArray.add("");
            }
            else
            {
                daysInMonthArray.add(String.valueOf(i - dayOfWeek));
            }
        }
        return  daysInMonthArray;
    }

    private String monthYearFromDate(LocalDate date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }

    public void previousMonthAction(View view)
    {
        selectedDate = selectedDate.minusMonths(1);
        setMonthView();
    }

    public void nextMonthAction(View view)
    {
        selectedDate = selectedDate.plusMonths(1);
        setMonthView();
    }

    @Override
    public void onItemClick(int position, String dayText)
    {
        selectedDay = Integer.parseInt(dayText);
        selectedMonthYear = monthYearFromDate(selectedDate);
        String dayNumber = Integer.toString(selectedDay);

        if(!dayText.equals(""))
        {
            String message = "Selected Date " + dayText + " " + monthYearFromDate(selectedDate);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                calendar.this, R.style.BottomSheetDialogTheme
        );
        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(
                        R.layout.detail_calendar,
                        (LinearLayout)findViewById(R.id.bottomSheetContainer)
                );
        tgl_acara = bottomSheetView.findViewById(R.id.tgl_acara);
        jumat_agung = bottomSheetView.findViewById(R.id.jumat_agung);
        alarm = bottomSheetView.findViewById(R.id.alarm);
        notes = bottomSheetView.findViewById(R.id.notes);
        String tgl = dayNumber + " " + selectedMonthYear;
        tgl_acara.setText(tgl);
        db = FirebaseFirestore.getInstance();
        CollectionReference verifRef = db.collection("Calendar");
        Query query = verifRef.whereEqualTo("Tanggal", tgl);
        query.get().addOnSuccessListener(querySnapshot -> {
            for (DocumentSnapshot documentSnapshot : querySnapshot.getDocuments()) {
                if (documentSnapshot.exists()) {
                    String acara = documentSnapshot.getString("Acara");
                    String tanggal = documentSnapshot.getString("Tanggal");
                    String alarms = documentSnapshot.getString("Mulai");
                    String note = documentSnapshot.getString("Catatan");

                    jumat_agung.setText(acara);
                    alarm.setText(alarms);
                    notes.setText(note);
                }
            }
        }).addOnFailureListener(e -> {
            //error
        });

        bottomSheetView.findViewById(R.id._edit).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent nextScreen = new Intent(getApplicationContext(), edit_events_activity.class);
                nextScreen.putExtra("selectedDay", dayNumber);
                nextScreen.putExtra("selectedMonthYear", selectedMonthYear);
                startActivity(nextScreen);
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
}
