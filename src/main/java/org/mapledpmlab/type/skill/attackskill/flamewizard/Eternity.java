package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Eternity extends AttackSkill {
    public Eternity() {
        this.setName("이터니티");
        this.setAttackCount(10L);
        this.setCooldown(360.0);
        this.setDamage(6600.0);
        this.setDotDuration(5070L);
        this.setLimitAttackCount(9L);
        this.setInterval(563L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new EternityCirculation());
    }
}
