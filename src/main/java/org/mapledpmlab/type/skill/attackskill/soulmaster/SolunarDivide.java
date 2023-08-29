package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SolunarDivide extends AttackSkill {
    public SolunarDivide() {
        this.setName("솔루나 디바이드");
        this.setAttackCount(15L);
        this.setDamage(2750.0);
        this.setDotDuration(750L);
        this.setInterval(150L);
        this.setLimitAttackCount(5L);
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new SolunarDivideDelay());
    }
}
