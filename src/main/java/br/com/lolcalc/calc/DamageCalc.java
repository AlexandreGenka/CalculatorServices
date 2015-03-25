package br.com.lolcalc.calc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/calc")
public class DamageCalc{

	@RequestMapping(value = "damage", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer calcDamage(@RequestParam("damage") Integer damage, @RequestParam("armor") Integer armor, @RequestParam("penetration") Integer penetration) {
		Integer realDamage = null;
		Integer armorTmp = armor - penetration;
		if (armorTmp > 0) {
			realDamage = Math.round((damage * 100) / (100 + armorTmp));
		} else {
			realDamage = damage;
		}
		return realDamage;
	}
	
	@RequestMapping(value = "calcDamagePerSeconds", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer calcDamagePerSeconds(@RequestParam("damage") Integer damage, @RequestParam("armor") Integer armor, @RequestParam("penetration") Integer penetration, Double atackSpeed, Integer seconds) {
		Integer totalAtacks = (int) Math.floor(atackSpeed * seconds);
		Integer damagePerHit = calcDamage(damage, armor, penetration);
		return totalAtacks * damagePerHit;
	}
	
	@RequestMapping(value = "criticalStrikeByHits", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer calcHitsWithCriticalStrike(@RequestParam("damage") Integer damage, @RequestParam("armor") Integer armor, @RequestParam("penetration") Integer penetration, @RequestParam("critPercent") Double critPercent){
		Double crit = new Integer(calcDamage(damage, armor, penetration)) *(1 + critPercent);
		return (int) Math.round(crit);
	}
	
	@RequestMapping(value = "criticalStrikeBySeconds", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String calcCriticalStrikeBySeconds(@RequestParam("damage") Integer damage, @RequestParam("armor") Integer armor, @RequestParam("penetration") Integer penetration, @RequestParam("critPercent") Double critPercent, @RequestParam("seconds") Integer seconds){
		
		return null;
	}

}