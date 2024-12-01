package viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp5obligatorio.R;
import com.example.tp5obligatorio.model.Articulo;

import java.util.ArrayList;
import java.util.List;

public class ArticuloViewModel extends ViewModel {
    private MutableLiveData<List<Articulo>> articulosList;

    public ArticuloViewModel(){
        articulosList=new MutableLiveData<>();
        loadArticulos();
    }

    private void loadArticulos() {
        List<Articulo> articulos = new ArrayList<>();

        articulos.add(new Articulo(
                "Pantalón jeans dama",
                "Dama",
                List.of("S", "SM", "M", "L", "XL"),
                List.of("Blanco", "Azul", "Negro", "Celeste"),
                25000.0,
                "Levi's",
                50,
                R.drawable.jeandama
        ));

        articulos.add(new Articulo(
                "Pantalón jeans de hombre",
                "Hombre",
                List.of("S", "SM", "M", "L", "XL"),
                List.of("Azul", "Negro", "Celeste", "Gris"),
                31000.0,
                "Wrangler",
                30,
                R.drawable.jeanhombre
        ));

        articulos.add(new Articulo(
                "Blusa fibrana dama",
                "Dama",
                List.of("S", "SM", "M", "L", "XL"),
                List.of("Verde", "Azul", "Negro", "Estampado"),
                25000.0,
                "Zara",
                40,
                R.drawable.blusadama
        ));

        articulos.add(new Articulo(
                "Camisa de hombre",
                "Hombre",
                List.of("S", "SM", "M", "L", "XL"),
                List.of("Azul", "Rosa", "Crema", "Amarillo"),
                28000.0,
                "Ralph Lauren",
                25,
                R.drawable.camisahombre
        ));

        articulos.add(new Articulo(
                "Remera algodón dama",
                "Dama",
                List.of("S", "SM", "M", "L", "XL"),
                List.of("Verde", "Azul", "Negro", "Estampado"),
                25000.0,
                "H&M",
                35,
                R.drawable.remeradama
        ));

        articulos.add(new Articulo(
                "Remera algodón de hombre",
                "Hombre",
                List.of("S", "SM", "M", "L", "XL"),
                List.of("Negro", "Rojo"),
                20000.0,
                "Nike",
                45,
                R.drawable.remerahombre
        ));
        articulosList.setValue(articulos);
    }

    public MutableLiveData<List<Articulo>> getArticulosList() {
        return articulosList;
    }
}
