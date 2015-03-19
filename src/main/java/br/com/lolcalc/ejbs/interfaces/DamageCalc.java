package br.com.lolcalc.ejbs.interfaces;

import javax.ejb.Remote;

@Remote
public interface DamageCalc {
	public Integer calcDamage(Integer damage, Integer armor, Integer penetration);
}
