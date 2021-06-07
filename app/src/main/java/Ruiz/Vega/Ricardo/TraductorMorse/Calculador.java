package Ruiz.Vega.Ricardo.TraductorMorse;
import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.text.*;
import android.view.*;
import android.widget.*;

public class Calculador extends Activity
{

	private EditText CajaSuperior;
	private TextView CajaInferior;
	private LinearLayout Fondo;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculador);

		CajaSuperior = findViewById(R.id.Superior);
		CajaInferior = findViewById(R.id.Inferior);
		Fondo = findViewById(R.id.Fondo);

		InicializarControles();

		CajaSuperior.addTextChangedListener(new TextWatcher(){

				@Override
				public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
				{
					// TODO: Implement this method
				}

				@Override
				public void onTextChanged(CharSequence p1, int p2, int p3, int p4)
				{
					CajaInferior.setText(Calcular(CajaSuperior.getText().toString().trim()));
				}

				@Override
				public void afterTextChanged(Editable p1)
				{
					// TODO: Implement this method
				}
			});

	}
	
	String Calcular(String Cual)
	{
		String Res = "";
		
		Cubo Cubito = new Cubo();
		try
		{
			Cubito.EstablecerLado(Double.parseDouble(Cual));
		}
		catch(NumberFormatException Error)
		{
			Toast.makeText(getApplicationContext(),"Debes introducir solo numeros",Toast.LENGTH_SHORT).show();
			if(!CajaSuperior.getText().toString().isEmpty())
			{
				CajaSuperior.setText("");
			}
			return "";
		}
		catch(Cuadrado.LadoNegativoException Error)
		{
			Toast.makeText(getApplicationContext(),"La longitud de lado no puede ser negativa",Toast.LENGTH_SHORT).show();
			if(!CajaSuperior.getText().toString().isEmpty())
			{
				CajaSuperior.setText("");
			}
			return "";
		}
		
		try
		{
			Res = "Los resultados son: \r\n";
			Res += "Perimetro = " + String.valueOf(Cubito.CalcularPerimetro()) + "\r\n";
			Res += "Area = " + String.valueOf(Cubito.CalcularArea()) + "\r\n";
			Res += "Volumen = " + String.valueOf(Cubito.CalcularVolumen());
		}
		catch(Cuadrado.LadoNoEstablecidoException Error)
		{
			Toast.makeText(getApplicationContext(),"La longitud de lado no puede ser cero",Toast.LENGTH_SHORT).show();
			if(!CajaSuperior.getText().toString().isEmpty())
			{
				CajaSuperior.setText("");
			}
			return "";
		}
		
		return Res;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu Menu)
	{
		Menu.add("Traductor Morse");
		Menu.add("Numeros Romanos");
		return super.onCreateOptionsMenu(Menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if(item.getTitle().equals("Traductor Morse"))
		{
			startActivity(new Intent(Calculador.this,TraductorMorse.class));
			finish();
		}

		if(item.getTitle().equals("Numeros Romanos"))
		{
			startActivity(new Intent(Calculador.this,NumerosRomanos.class));
			finish();
		}

		return super.onOptionsItemSelected(item);
	}



	private void InicializarControles()
	{
		Point Punto = new Point();
		getWindowManager().getDefaultDisplay().getSize(Punto);

		int Ancho = Punto.x;
		int Alto = Punto.y;

		CajaSuperior.setLayoutParams(new LinearLayout.LayoutParams(Ancho/10*9,LinearLayout.LayoutParams.WRAP_CONTENT));
		CajaInferior.setLayoutParams(new LinearLayout.LayoutParams(Ancho/10*9,LinearLayout.LayoutParams.WRAP_CONTENT));


		getWindow().setTitle("Calculador Objetos");
		getWindow().setStatusBarColor(Color.parseColor("#FFD600"));
		getWindow().setNavigationBarColor(Color.parseColor("#FFD600"));

		ActionBar BarraSuperior = getActionBar();
		BarraSuperior.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFD600")));
		BarraSuperior.setDisplayShowTitleEnabled(false);
		BarraSuperior.setDisplayShowTitleEnabled(true);
		BarraSuperior.setDisplayHomeAsUpEnabled(true);
		BarraSuperior.setTitle("Calculador Objetos");


		CajaSuperior.setHintTextColor(Color.parseColor("#F9A825"));
		CajaSuperior.setTextColor(Color.parseColor("#F9A825"));
		CajaSuperior.setGravity(Gravity.CENTER);
		CajaSuperior.setHint("Introduzca la longitud de Lado...");


		CajaInferior.setTextColor(Color.parseColor("#F9A825"));
		CajaInferior.setHintTextColor(Color.parseColor("#F9A825"));
		CajaInferior.setGravity(Gravity.LEFT);
		CajaInferior.setTextIsSelectable(true);
		CajaInferior.setHint("El calculo de Perimetro, Area y Volumen aparecerá aqui...");

		Fondo.setBackgroundColor(Color.WHITE);


	}
	
}
