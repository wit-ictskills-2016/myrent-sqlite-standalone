package sqlite.myrentsqlite.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.UUID;

import sqlite.myrentsqlite.R;
import sqlite.myrentsqlite.app.MyRentApp;
import sqlite.myrentsqlite.models.Residence;

public class MyRent extends AppCompatActivity implements View.OnClickListener
{

  private Button addResidence;
  private Button selectResidence;

  MyRentApp app;
  Residence residence;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_myrent);

    app = MyRentApp.getApp();

    addResidence = (Button) findViewById(R.id.addResidence);
    addResidence.setOnClickListener(this);

    selectResidence = (Button) findViewById(R.id.selectResidence);
    selectResidence.setOnClickListener(this);
  }

  @Override
  public void onClick(View v)
  {
    switch (v.getId())
    {
      case R.id.addResidence:
        addResidence();
        break;

      case R.id.selectResidence:
        selectResidence();
        break;
    }
  }

  private void addResidence()
  {
    residence = new Residence();

    app.dbHelper.addResidence(residence);

  }

  /**
   * This method demonstrates how to select a Residence record, identified by its primary key, the UUID field.
   * To successfuly select a record it is necessary to obtain the key from an existing record by inspecting the database or from the Android Studio the debugger window.
   * The key here is to be taken as a placeholder.
   */
  public void selectResidence()
  {
    String id = "6277ba13-4868-4f1c-8ed5-9440d9a16bd5";
    UUID uuid = UUID.fromString(id);
    Residence residence = app.dbHelper.selectResidence(uuid);
    if (residence != null && residence.id.toString().equals(id))
    {
      Toast.makeText(this, "Residence record selected(id: " + residence.id, Toast.LENGTH_LONG).show();
    }
    else
    {
      Toast.makeText(this, "Failed to select Residence record", Toast.LENGTH_LONG).show();
    }
  }
}