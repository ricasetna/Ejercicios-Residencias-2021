package Ruiz.Vega.Ricardo.TraductorMorse;
import Ruiz.Vega.Ricardo.TraductorMorse.Cuadrado.*;

public class Cuadrado
{
	protected double Lado = 0.0d;
	
	public Cuadrado(double LadoN) throws Cuadrado.LadoNegativoException
	{
		if(LadoN < 0.0d)
			throw new LadoNegativoException("Lado con longitud negativa");
		else
			this.Lado = LadoN;
	}
	
	public Cuadrado()
	{
		
	}
	
	public void EstablecerLado(double LadoN) throws Cuadrado.LadoNegativoException
	{
		if(LadoN < 0.0d)
			throw new LadoNegativoException("Lado con longitud negativa");
		else
			this.Lado = LadoN;
	}
	
	public double CalcularArea() throws Cuadrado.LadoNoEstablecidoException 
	{
		if(Lado == 0.0d)
			throw new LadoNoEstablecidoException("No se ha indicado la longitud de lado");
			
		else	
			return Lado*Lado;
	}
	
	public double CalcularPerimetro() throws Cuadrado.LadoNoEstablecidoException
	{
		if(Lado == 0.0d)
			throw new LadoNoEstablecidoException("No se ha indicado la longitud de lado");

		else	
			return Lado*4;
	}
	
	public class LadoNoEstablecidoException extends Exception 
	{
		public LadoNoEstablecidoException(String Exception)
		{
			super(Exception);
		}
	}
	
	public class LadoNegativoException extends Exception
	{
		public LadoNegativoException(String Exception)
		{
			super(Exception);
		}
	}
}
