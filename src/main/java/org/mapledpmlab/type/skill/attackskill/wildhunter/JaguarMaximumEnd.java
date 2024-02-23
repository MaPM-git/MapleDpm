package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class JaguarMaximumEnd extends AttackSkill {
    public JaguarMaximumEnd() {
        this.setName("재규어 맥시멈(마무리 공격)");
        this.setDelay(630L);
        this.setDamage(740.0);
        this.setAttackCount(15L);
        this.addCriticalP(100.0);
        this.addIgnoreDefenseList(100L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.getMultiAttackInfo().add(360L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
