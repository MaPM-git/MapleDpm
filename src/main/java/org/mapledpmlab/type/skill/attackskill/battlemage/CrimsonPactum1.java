package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CrimsonPactum1 extends AttackSkill {
    public CrimsonPactum1() {
        this.setName("크림슨 팩텀1");
        this.setAttackCount(8L);
        this.setCooldown(360.0);
        this.setDamage(9000.0);
        this.setLimitAttackCount(13L);
        this.setDotDuration(3900L);
        this.setInterval(300L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new CrimsonPactum1Delay());
        this.setApplyFinalAttack(true);
    }
}
