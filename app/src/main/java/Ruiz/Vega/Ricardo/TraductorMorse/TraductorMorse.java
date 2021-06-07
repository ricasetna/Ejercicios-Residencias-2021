package Ruiz.Vega.Ricardo.TraductorMorse;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.text.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class TraductorMorse extends Activity 
{
	private EditText CajaSuperior;
	private TextView CajaInferior;
	private Button Invertir;
	private LinearLayout Fondo;
	
	private boolean MorseEspa = true;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traductor_morse);
		
		CajaSuperior = findViewById(R.id.Superior);
		CajaInferior = findViewById(R.id.Inferior);
		Invertir = findViewById(R.id.Cambio);
		Fondo = findViewById(R.id.Fondo);
		
		InicializarControles();
		
		Invertir.setOnClickListener(new OnClickListener(){
			
				@Override
				public void onClick(View p1)
				{
					MorseEspa = !MorseEspa;
					
					if(MorseEspa)
					{
						if(CajaSuperior.getText().toString().isEmpty())
						{
							CajaSuperior.setHint("Texto en Morse...");
							CajaInferior.setText("Traduccion en Español...");
						}
						else
						{
							CajaSuperior.setText(CajaInferior.getText().toString().trim());
							CajaSuperior.setSelection(CajaSuperior.getText().length());
						}
						
					}
					else
					{
						if(CajaSuperior.getText().toString().isEmpty())
						{
							CajaSuperior.setHint("Texto en Español...");
							CajaInferior.setText("Traduccion en Morse...");
						}
						else
						{
							CajaSuperior.setText(CajaInferior.getText().toString().trim());
							CajaSuperior.setSelection(CajaSuperior.getText().length());
						}
					}
				}
			});
			
		Invertir.performClick();
		
		CajaSuperior.addTextChangedListener(new TextWatcher(){

				@Override
				public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
				{
					// TODO: Implement this method
				}

				@Override
				public void onTextChanged(CharSequence p1, int p2, int p3, int p4)
				{
					CajaInferior.setText(Traducir(CajaSuperior.getText().toString(),MorseEspa));
				}

				@Override
				public void afterTextChanged(Editable p1)
				{
					// TODO: Implement this method
				}
			});
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu Menu)
	{
		Menu.add("Numeros Romanos");
		Menu.add("Calculador Objetos");
		return super.onCreateOptionsMenu(Menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if(item.getTitle().equals("Numeros Romanos"))
		{
			startActivity(new Intent(TraductorMorse.this,NumerosRomanos.class));
			finish();
		}
		
		if(item.getTitle().equals("Calculador Objetos"))
		{
			startActivity(new Intent(TraductorMorse.this,Calculador.class));
			finish();
		}

		return super.onOptionsItemSelected(item);
	}
	
	private String Traducir(String Que, boolean AEspa)
	{
		String Res = "";
		
		if(AEspa)
		{
			String TextoTraducido = "";
			String Palabras[] = Que.split("   ");
			for(int A = 0; A < Palabras.length; A++)
			{
				String Letras[] = Palabras[A].split(" ");
				for(int B = 0; B < Letras.length; B++)
				{
					boolean Error = true;
					for(int C = 0; C < Definiciones.DiccionarioMorseLetras.length; C++)
					{
						if(Letras[B].equals(Definiciones.DiccionarioMorseLetras[C]))
						{
							TextoTraducido += (char)(C + 65);
							Error = false;
						}
					}

					for(int C = 0; C < Definiciones.DiccionarioMorseNumeros.length; C++)
					{
						if(Letras[B].equals(Definiciones.DiccionarioMorseNumeros[C]))
						{
							TextoTraducido += (char)(C + 48);
							Error = false;
						}
					}
					
					if(Error)
						TextoTraducido += "?";
				}
	
				TextoTraducido += " ";
				Res = TextoTraducido.trim();
			}
		}
		else
		{
			String TextoTraducido = "";
			Que = Que.toUpperCase();
			String Palabras[] = Que.split(" ");
			for(int A = 0; A < Palabras.length; A++)
			{
				char Letras[] = Palabras[A].toCharArray();
				for(int B = 0; B < Letras.length; B++)
				{
					boolean Error = true;
					
					if(Letras[B] >= 48 && Letras[B] <= 57)
					{
						Error = false;
						TextoTraducido += Definiciones.DiccionarioMorseNumeros[Letras[B]-48];
					}
					
					if(Letras[B] >= 65 && Letras[B] <= 90)
					{
						Error = false;
						TextoTraducido += Definiciones.DiccionarioMorseLetras[Letras[B]-65];
					}
					

					if(Error)
						TextoTraducido += "? ";
					else
						TextoTraducido += " ";
				}

				TextoTraducido += "  ";
				Res = TextoTraducido.trim();
			}
		}
		
		
		
		return Res;
	}
	
	private void InicializarControles()
	{
		Point Punto = new Point();
		getWindowManager().getDefaultDisplay().getSize(Punto);
		
		int Ancho = Punto.x;
		int Alto = Punto.y;
		
		CajaSuperior.setLayoutParams(new LinearLayout.LayoutParams(Ancho/10*9,LinearLayout.LayoutParams.WRAP_CONTENT));
		CajaInferior.setLayoutParams(new LinearLayout.LayoutParams(Ancho/10*9,LinearLayout.LayoutParams.WRAP_CONTENT));
		Invertir.setLayoutParams(new LinearLayout.LayoutParams(Ancho/10*3,LinearLayout.LayoutParams.WRAP_CONTENT));
		
		getWindow().setTitle("Traductor Morse");
		getWindow().setStatusBarColor(Color.parseColor("#FFD600"));
		getWindow().setNavigationBarColor(Color.parseColor("#FFD600"));
		
		ActionBar BarraSuperior = getActionBar();
		BarraSuperior.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFD600")));
		BarraSuperior.setDisplayShowTitleEnabled(false);
		BarraSuperior.setDisplayShowTitleEnabled(true);
		BarraSuperior.setDisplayHomeAsUpEnabled(true);
		BarraSuperior.setTitle("Traductor Morse");
		
		Invertir.setBackgroundColor(Color.parseColor("#FFD600"));
		Invertir.setClipToOutline(true);
		Invertir.setOutlineProvider(new ProvedorContornoCuadro());
		Invertir.setElevation(30);
		Invertir.setTextColor(Color.BLACK);
		
		CajaSuperior.setHintTextColor(Color.parseColor("#F9A825"));
		CajaSuperior.setTextColor(Color.parseColor("#F9A825"));
		CajaSuperior.setGravity(Gravity.CENTER);
		
		CajaInferior.setTextColor(Color.parseColor("#F9A825"));
		CajaInferior.setHintTextColor(Color.parseColor("#F9A825"));
		CajaInferior.setGravity(Gravity.CENTER);
		CajaInferior.setTextIsSelectable(true);
		
		Fondo.setBackgroundColor(Color.WHITE);
		
		
	}
}
