package dao;

import java.util.ArrayList;

import bean.Convenzione;

public interface ConvenzioneDaoInterface {
	
	public boolean approvazioneRichiestaConvenzione(String piva);
	
	public ArrayList<Convenzione> getRichiesteConvenzione();
	
	public boolean invioRichiestaConvenzione(Convenzione convenzione, String email ,String piva);
}
