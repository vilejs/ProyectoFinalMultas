package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite_OpenHelper extends SQLiteOpenHelper {
    public SQLite_OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table usuarios(id integer primary key autoincrement, Nombre text, Ciudad text, Correo text, Password text)";
        db.execSQL(query);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //METODO  QUE PERMITE ABRIR LA BASE DE DATOS

    public  void abrir(){
        this.getWritableDatabase();

    }
    //METODO  QUE PERMITE CERRAR LA BASE DE DATOS
    public  void cerrar(){
        this.close();

    }
    //METODO QUE PERMITE INSERTAR REGISTROS EN LA TABLA USUSARIOS

    public  void insertarReg(String nom, String ciu, String corr, String pas){
        ContentValues values= new ContentValues();
        values.put("Nombre",nom);
        values.put("Ciudad",ciu);
        values.put("Correo",corr);
        values.put("Password",pas);
        this.getWritableDatabase().insert("usuarios",null,values);

    }

    // METODO QUE VALIDA SI EL USUARIO EXISTE

    public Cursor ConsultarUsuPas(String usu, String pas) throws SQLException {

        Cursor mcursor=null;
        mcursor=this.getReadableDatabase().query("usuarios",new String[]{"id","Nombre","Ciudad","Correo","Password"},"Correo like'"+usu+"' and Password like '"+pas+"'",null,null,null,null);
        return  mcursor;
    }



}
