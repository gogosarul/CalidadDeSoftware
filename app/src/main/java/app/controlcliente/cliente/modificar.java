package app.controlcliente.cliente;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.controlcliente.cliente.R;


public class modificar extends ActionBarActivity {

    BDClientes bdClientes;
    EditText nombre_input;
    EditText apellido_input;
    EditText edad_input;
    EditText telefono_input;
    EditText email_input;
    //EditText categoria_input;
    int idglobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Aqui se hace el retrieve de la base de datos tomando un valor que viene en el intent anterior

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        nombre_input = (EditText) findViewById(R.id.nombre_input);
        apellido_input = (EditText) findViewById(R.id.apellido_input);
        edad_input = (EditText) findViewById(R.id.edad_input);
        telefono_input = (EditText) findViewById(R.id.telefono_input);
        email_input = (EditText) findViewById(R.id.email_input);
        //categoria_input = (EditText) findViewById(categoria_input);
        bdClientes = new BDClientes(this, null, null, 1);
        Clientes cliente = new Clientes(); //xdxdxdxdxd
        Intent i = getIntent(); // gets the previously created intent
        String stringid = i.getStringExtra("id_cliente");
        int id = Integer.parseInt(stringid);
        Cursor c = bdClientes.personabyid(id);

    //Vuelve a rellenar los inputs con los valores del cursor
        nombre_input.setText(c.getString(c.getColumnIndexOrThrow("nombre")));
        apellido_input.setText(c.getString(c.getColumnIndexOrThrow("apellido")));
        edad_input.setText(c.getString(c.getColumnIndexOrThrow("edad")));
        telefono_input.setText(c.getString(c.getColumnIndexOrThrow("telefono")));
        email_input.setText(c.getString(c.getColumnIndexOrThrow("email")));
        //categoria_input.setText(c.getString(c.getColumnIndexOrThrow("categoria")));
        idglobal = c.getInt(c.getColumnIndexOrThrow("_id"));

    }

    public void modificar_clicked(View view){

        Clientes cliente = new Clientes(nombre_input.getText().toString(), apellido_input.getText().toString(), Integer.parseInt(edad_input.getText().toString()), telefono_input.getText().toString(), email_input.getText().toString() );
        cliente.set_id(idglobal);
        bdClientes.updatecliente(cliente);
        confirmacion();
        limpiarcampos();
        finish(); //Termina la actividad y vuelve al menu principal

        }

    public void confirmacion(){

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Se ha modificado exitosamente!");
        dlgAlert.setTitle("Agregar Cliente");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    //Limpia los valores entrados para efectos de estetica
    public void limpiarcampos(){

        nombre_input.setText("");
        apellido_input.setText("");
        edad_input.setText("");
        telefono_input.setText("");
        email_input.setText("");
        //categoria_input.setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modificar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
