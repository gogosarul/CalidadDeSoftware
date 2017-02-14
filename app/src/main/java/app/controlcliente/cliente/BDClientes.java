package app.controlcliente.cliente;

/**
 * Created by jorge on 28/01/2017.
 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;


public class BDClientes extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "clientes.db";
    public static final String TABLA_CLIENTES = "clientes";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_APELLIDO = "apellido";
    public static final String COLUMN_EDAD = "edad";
    public static String COLUMN_TEL = "telefono";
    public static String COLUMN_EMAIL = "email";
    //public static String COLUMN_CATEGORIA = "categoria";


    public BDClientes(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLA_CLIENTES + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOMBRE + " TEXT, " +
                COLUMN_APELLIDO + " TEXT, " +
                COLUMN_EDAD + " INTEGER, " +
                COLUMN_TEL + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                //COLUMN_CATEGORIA + " TEXT " +
                ");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_CLIENTES);
        onCreate(db);
    }

    //Añade un nuevo Row a la Base de Datos

    public void addCliente(Clientes clientes) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, clientes.get_nombre());
        values.put(COLUMN_APELLIDO, clientes.get_apellido());
        values.put(COLUMN_EDAD, clientes.get_edad());
        values.put(COLUMN_TEL, clientes.get_telefono());
        values.put(COLUMN_EMAIL, clientes.get_email());
        //values.put(COLUMN_CATEGORIA, clientes.get_categoria());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLA_CLIENTES, null, values);
        db.close();

    }

    public void updatecliente(Clientes clientes){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, clientes.get_nombre());
        values.put(COLUMN_APELLIDO, clientes.get_apellido());
        values.put(COLUMN_EDAD, clientes.get_edad());
        values.put(COLUMN_TEL, clientes.get_telefono());
        values.put(COLUMN_EMAIL, clientes.get_email());
        //values.put(COLUMN_CATEGORIA, clientes.get_categoria());
        SQLiteDatabase db = getWritableDatabase();
        db.update(TABLA_CLIENTES, values, COLUMN_ID + "= ?", new String[] { String.valueOf(clientes.get_id())});
        db.close();

    }

    // Borrar un cliente de la Base de Datos

    public void borrarcliente(int cliente_id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLA_CLIENTES + " WHERE " + COLUMN_ID + " = " + cliente_id + ";");
        db.close();
    }

    //listar por id

    public Cursor personabyid(int id){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLA_CLIENTES + " WHERE " + COLUMN_ID + " = " + id + ";";
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }

    //listar a todos ls clientes
    public Cursor listarclientes(){
        SQLiteDatabase db = getReadableDatabase();
        String query = ("SELECT * FROM " + TABLA_CLIENTES + " WHERE 1 ORDER BY " + COLUMN_APELLIDO + ";");
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

            return c;
        }

}




