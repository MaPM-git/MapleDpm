package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SolunarSlash extends AttackSkill {
    public SolunarSlash() {
        this.setName("솔루나 슬래시");
        this.setDelayByAttackSpeed(450L);
        this.setAttackCount(6L * 2);
        this.setDamage(243.0);
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setCooldown(5.0);
    }
}
