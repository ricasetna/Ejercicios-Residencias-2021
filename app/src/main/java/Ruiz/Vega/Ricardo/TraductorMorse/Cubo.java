package Ruiz.Vega.Ricardo.TraductorMorse;
import Ruiz.Vega.Ricardo.TraductorMorse.Cuadrado.*;

public class Cubo extends Cuadrado
{
	public Cubo(double Lado) throws Cuadrado.LadoNegativoException
	{
		super(Lado);
	}
	
	public Cubo()
	{
		super();
	}
	
	public double CalcularVolumen() throws Cuadrado.LadoNoEstablecidoException
	{
		if(Lado == 0.0d)
			throw new Cuadrado.LadoNoEstablecidoException("No se ha indicado la longitud de lado");
		else
			return Math.pow(Lado,3.0d);
	}

	@Override
	public double CalcularPerimetro() throws Cuadrado.LadoNoEstablecidoException
	{
		return super.CalcularPerimetro();
	}
	
}
