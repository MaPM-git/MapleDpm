package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Gathering extends AttackSkill {
    public Gathering(Long etherSword) {
        this.setName("게더링");
        this.setDamage(260.0 + 303);
        this.setAttackCount(4L * etherSword);
        this.setCooldown(15.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new Blossom(etherSword));
    }
}
