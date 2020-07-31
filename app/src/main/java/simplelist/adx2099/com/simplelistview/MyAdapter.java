package simplelist.adx2099.com.simplelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class  MyAdapter extends BaseAdapter {
    public Context context;
    private int layout;
    private List<String> names;

    //constructor
    public MyAdapter(Context context,int layout, List<String> names){
        this.context = context;
        this.layout = layout;
        this.names = names;
    }
    //Dice cuantas veces hay que iterar sobre una coleccion que le vamos a dar, el numero de item
    @Override
    public int getCount() {
        return this.names.size();
    }
    //Obtener un item de esta coleccion
    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }
    //Obtener el id del elemento de esa coleccion
    @Override
    public long getItemId(int id) {
        return id;
    }
    //Obtiene la vista pues es el clave en dinde esta la chiccha, esta es la lista que se va transformar
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        //--------------------------------------View Holder Pattern-----------------------------------------
        ViewHolder holder;
        if(convertView == null){
            //Inflamos la vista
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(this.layout, null);

            //Creamos una nueva instancia del Holder
            holder = new ViewHolder();
            //Referenciamos ele elemento a modificar con la nueva instancia que en este caso es el convertView
            //Pero jala el elemento que creaste dentro del View Holder
            holder.nameTextView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //--------------------------------------View Holder Pattern-----------------------------------------
        //Tomamos el layout que viene lo inflamos, lo personalizamos y lo devolvemos
        //La vista a inflar
        //View vista = convertView;
        //Tomamos del contexto un layout inflater
        //LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        //Inflamos el layout
        //vista = layoutInflater.inflate(R.layout.list_item,  null);
        //Nos traemos el valor actual dependiente de la posicion
        String currentName = names.get(position);
        //El find view no lo encuentras porque no estas en un contexto, para resolverlo tenemos que entrar a la vista que es la que cargo el layout
        //y ahi es donde podemos traer el textview
        //TextView textView = (TextView) vista.findViewById(R.id.textView);
        holder.nameTextView .setText(currentName);
        //Trabajar con getitem
        //currentName = (String) getItem(position);
        //regresamos la vista
        return convertView;
    }
    //--------------------------------------View Holder Pattern-----------------------------------------
    static class ViewHolder{
        private TextView nameTextView;

    }
    //--------------------------------------View Holder Pattern-----------------------------------------
}
