package com.demo.imagesearchapp.databasehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteMisuseException;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Image.db";
    public static final String IMAGES_TABLE_NAME = "images_table";
    public static final String IMAGES_COLUMN_IMAGE_ID = "image_id";
    public static final String IMAGES_COLUMN_COMMENT = "comment";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table images_table " +
                        "(image_id text primary key, comment text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS images_table");
        onCreate(sqLiteDatabase);
    }

    public boolean insertImages (String image_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("image_id", image_id);
        db.insertWithOnConflict("images_table", null, contentValues,SQLiteDatabase.CONFLICT_IGNORE);
        return true;
    }

    public Cursor getData(String image_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery( "select comment from images_table where image_id='"+image_id+"'", null );
    }

    public boolean updateComment (String comment, String image_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("comment", comment);
        db.update("images_table", contentValues, "image_id = ? ", new String[] { image_id } );
        return true;
    }
}
