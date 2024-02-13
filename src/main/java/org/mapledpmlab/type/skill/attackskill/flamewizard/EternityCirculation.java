package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EternityCirculation extends AttackSkill {
    public EternityCirculation() {
        this.setName("이터니티(순환의 불꽃)");
        this.setAttackCount(13L);
        this.setDamage(3700.0);
        this.setDotDuration(30000L);
        this.setInterval(1200L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
    }
}
