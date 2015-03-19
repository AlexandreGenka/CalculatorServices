package br.com.lolcalc.ejbs;

import javax.ejb.Stateless;

import br.com.lolcalc.ejbs.interfaces.DamageCalc;

@Stateless
public class DamageCalcImpl implements DamageCalc {

	public Integer calcDamage(Integer damage, Integer armor, Integer penetration) {
		Integer realDamage = null;
		Integer armorTmp = armor - penetration;
		if (armorTmp > 0) {
			realDamage = Math.round((damage * 100) / (100 + armorTmp));
		} else {
			realDamage = damage;
		}
		return realDamage;
	}

}