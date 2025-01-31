package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Impale extends AttackSkill {
    public Impale() {
        this.setName("임페일");
        this.setDamage(748.0);
        this.setAttackCount(6L);
        this.setCooldown(7.0);
        this.setDelay(390L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new Resonance());
        //this.setApplyReuse(true);
    }
}
