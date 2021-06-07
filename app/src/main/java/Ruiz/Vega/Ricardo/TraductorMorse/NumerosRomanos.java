package Ruiz.Vega.Ricardo.TraductorMorse;
import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.text.*;

public class NumerosRomanos extends Activity
{

	private EditText CajaSuperior;
	private TextView CajaInferior;
	private LinearLayout Fondo;

	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numeros_romanos);

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
					CajaInferior.setText(Traducir(CajaSuperior.getText().toString().trim()));
				}

				@Override
				public void afterTextChanged(Editable p1)
				{
					// TODO: Implement this method
				}
			});
	
	}
	
	String Traducir(String Que)
	{
		String Res = "";
		try
		{
			int Numero = Integer.parseInt(Que);
			char[] Num = String.valueOf(Numero).toCharArray();
			if(Numero > 1000)
			{
				if(Num.length >= 5)
				{
					CajaSuperior.setText(String.valueOf(Num,0,4));
				}
				else
				{
					CajaSuperior.setText(String.valueOf(Num,0,3));
				}
				
				CajaSuperior.setSelection(CajaSuperior.getText().length());
				Toast.makeText(getApplicationContext(),"Solo numeros hasta mil",Toast.LENGTH_SHORT).show();
				return CajaInferior.getText().toString();
			}
			
			String NumeroFormateado = String.valueOf(Num);
			for(int A = Num.length; A < 4; A++)
			{
				NumeroFormateado = "0"+NumeroFormateado;
			}
			//Toast.makeText(getApplicationContext(),NumeroFormateado,Toast.LENGTH_SHORT).show();
			
			char Representacion[] = NumeroFormateado.toCharArray();
			for(int A = 0; A < Representacion.length; A++)
			{
				Res += Definiciones.DiccionarioNumerosRomanos[A][Representacion[A]-48];
			}
		}
		catch(NumberFormatException E)
		{
			if(!CajaSuperior.getText().toString().isEmpty())
			{
				Toast.makeText(getApplicationContext(),"Introduce solo numeros enteros positivos por favor",Toast.LENGTH_SHORT).show();
				CajaSuperior.setText("");
			}
				
		}
		return Res;
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu Menu)
	{
		Menu.add("Traductor Morse");
		Menu.add("Calculador Objetos");
		return super.onCreateOptionsMenu(Menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if(item.getTitle().equals("Traductor Morse"))
		{
			startActivity(new Intent(NumerosRomanos.this,TraductorMorse.class));
			finish();
		}
		
		if(item.getTitle().equals("Calculador Objetos"))
		{
			startActivity(new Intent(NumerosRomanos.this,Calculador.class));
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
		

		getWindow().setTitle("Numeros Romanos");
		getWindow().setStatusBarColor(Color.parseColor("#FFD600"));
		getWindow().setNavigationBarColor(Color.parseColor("#FFD600"));

		ActionBar BarraSuperior = getActionBar();
		BarraSuperior.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFD600")));
		BarraSuperior.setDisplayShowTitleEnabled(false);
		BarraSuperior.setDisplayShowTitleEnabled(true);
		BarraSuperior.setDisplayHomeAsUpEnabled(true);
		BarraSuperior.setTitle("Numeros Romanos");
		
		
		CajaSuperior.setHintTextColor(Color.parseColor("#F9A825"));
		CajaSuperior.setTextColor(Color.parseColor("#F9A825"));
		CajaSuperior.setGravity(Gravity.CENTER);
		CajaSuperior.setHint("Escribe un numero...");
		CajaSuperior.setInputType(InputType.TYPE_CLASS_NUMBER);
		
		CajaInferior.setTextColor(Color.parseColor("#F9A825"));
		CajaInferior.setHintTextColor(Color.parseColor("#F9A825"));
		CajaInferior.setGravity(Gravity.CENTER);
		CajaInferior.setTextIsSelectable(true);
		CajaInferior.setHint("El equivalente en numeracion Romana aparecera aqui...");

		Fondo.setBackgroundColor(Color.WHITE);
		

	}
	
}
