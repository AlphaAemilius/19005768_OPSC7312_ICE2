package com.vc19005768.sqllitetodo.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.vc19005768.sqllitetodo.ChoreModel;
import com.vc19005768.sqllitetodo.R;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Chores.db";
    private static final int DATABASE_VERSION = 1;

    private static String createTableQuery = "create table ChoreStore(cID INTEGER,Chore TEXT, Time TEXT)";

   public DatabaseHandler(@Nullable Context context){
       super(context,DATABASE_NAME,null,DATABASE_VERSION);
       this.context = context;

   }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            //db.execSQL(createTableQuery);                                            //creates the table on an instance of the DB
            Toast.makeText(context,"Table created", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(context,e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void WriteToDb(ChoreModel ch){ //commits values to the DB
        try {
            SQLiteDatabase cDb = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("cID", ch.getcID());
            contentValues.put("Chore", ch.getChore());
            contentValues.put("Time", ch.getTime());
            long checkIfQueryRuns = cDb.insert("ChoreStore",null,contentValues);

            if (checkIfQueryRuns!=-1) {
                Toast.makeText(context, "Chore saved",Toast.LENGTH_SHORT).show();
                cDb.close();
            } else {
                Toast.makeText(context, "Sum ting went wong",
                        Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Log.i("SAVE TO DB ", "StoreChoreError " +e.getMessage());

        }
    }


    public ArrayList<ChoreModel> readFromDb() {
        try {
            SQLiteDatabase cDatabase = this.getReadableDatabase();
            ArrayList<ChoreModel>dbChores = new ArrayList<>();
            Cursor cursor = cDatabase.rawQuery("select * from ChoreStore",null);

            if(cursor.getCount() != 0) {
                while(cursor.moveToNext()) {
                    int cID = cursor.getInt(0);
                    String cName = cursor.getString(1);
                    String cTime = cursor.getString(2);
                    dbChores.add(new ChoreModel(cID,cName,cTime));
                }
                Toast.makeText(context, "Loading Chores",
                        Toast.LENGTH_SHORT).show();
                return dbChores;
            }
            else {
                Toast.makeText(context, "No Chores Found ",
                        Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        catch (Exception e) {
            Log.i("Read TO DB ", "storeChoreLocal: " +e.getMessage());
            return null;
        }
    }
}
