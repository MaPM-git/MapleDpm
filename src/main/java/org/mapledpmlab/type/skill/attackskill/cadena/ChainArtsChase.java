package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChainArtsChase extends AttackSkill {
    public ChainArtsChase() {
        this.setName("체인아츠:체이스");
        this.setDelay(150L + 30);
        /*this.setDamage(100.0);
        this.setAttackCount(1L);
        //this.setDelayByAttackSpeed(660L);*/
        this.setCooldown(0.2);
        this.setApplyReuse(true);
    }
}
