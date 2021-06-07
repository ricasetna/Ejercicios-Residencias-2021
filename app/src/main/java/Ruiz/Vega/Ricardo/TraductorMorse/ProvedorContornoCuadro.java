package Ruiz.Vega.Ricardo.TraductorMorse;
import android.graphics.*;
import android.view.*;

public class ProvedorContornoCuadro extends ViewOutlineProvider
{
	@Override
	public void getOutline(View Vista, Outline Contorno) {
		final int Margen = Vista.getWidth() / 20;
		Contorno.setRoundRect(0,0, Vista.getWidth(),Vista.getHeight(), Margen / 4);
	}

}
