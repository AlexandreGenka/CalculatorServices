package br.com.lolcalc.calc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/calc")
public class DamageCalcImpl{

	@RequestMapping(value = "damage", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String calcDamage(@RequestParam("damage") Integer damage, @RequestParam("armor") Integer armor, @RequestParam("penetration") Integer penetration) {
		Integer realDamage = null;
		Integer armorTmp = armor - penetration;
		if (armorTmp > 0) {
			realDamage = Math.round((damage * 100) / (100 + armorTmp));
		} else {
			realDamage = damage;
		}
		return String.valueOf(realDamage);
	}
	@RequestMapping(value = "criticalStrikeByHits", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String calcCriticalStrikeByHits(@RequestParam("damage") Integer damage, @RequestParam("armor") Integer armor, @RequestParam("penetration") Integer penetration, @RequestParam("critPercent") Double critPercent, @RequestParam("quanittyOfHits") Integer quanittyOfHits){
		return null;
	}
	
	@RequestMapping(value = "criticalStrikeBySeconds", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String calcCriticalStrikeBySeconds(@RequestParam("damage") Integer damage, @RequestParam("armor") Integer armor, @RequestParam("penetration") Integer penetration, @RequestParam("critPercent") Double critPercent, @RequestParam("seconds") Integer seconds){
		return null;
	}

}