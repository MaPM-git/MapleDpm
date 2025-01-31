package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class JaguarMaximum extends AttackSkill {
    public JaguarMaximum() {
        this.setName("재규어 맥시멈");
        this.setDelay(960L);
        this.setDamage(740.0);
        this.setAttackCount(12L);
        this.setCooldown(120.0);
        this.addCriticalP(100.0);
        this.addIgnoreDefenseList(100L);
        this.setRelatedSkill(new JaguarMaximumEnd());
        this.addFinalDamage(1.6);       // 코어 강화
        this.getMultiAttackInfo().add(990L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(150L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(150L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
